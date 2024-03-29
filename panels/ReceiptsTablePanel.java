/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import components.editors.MyAfmCellEditor;
import components.editors.MyAmountCellEditor;
import components.renderers.MyAmountCellRenderer;
import components.editors.MyJCalendarCellEditor;
import components.renderers.MyJCalendarCellRenderer;
import components.MyTableModel;
import components.MyTablePanel;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableModel;
import models.Type;
import tools.Helper;
import models.Receipt;
import receipts.Main;
import tools.options.Options;

/**
 *
 * @author lordovol
 */
public class ReceiptsTablePanel extends MyTablePanel {

  Main m;
  private boolean validReceipt;

  /** Creates new form TypoesPanel */
  public ReceiptsTablePanel(Main m, boolean validReceipt) {
    this.m = m;
    this.validReceipt = validReceipt;
    setModel();
    super.init();
    bt_popup.setVisible(false);
    popup_delete.setText(validReceipt ? "Διαγραφή" : "Επαναφορά");

    _NUMBER_OF_FIELDS = 6;
    _TABLE_NAME_ = _RECEIPTS_;
    setTitle("Λίστα " + (validReceipt ? "" : " Διεγραμμένων ") + " Αποδείξεων");
    setHint("Κάντε κλικ ή διπλό κλικ σε κάποιο πεδίο για να το μετατρέψετε και δεξί κλικ για να το διαγράψετε");
    setSecondHint("Με μπλε χρώμα εμφανίζονται οι αποδείξεις με ποσοστό διαφορετικό του 100%");
    object = Receipt.class;
    addColumns();
    addRows();
    tableModel.addTableModelListener(this);
    //AFM
    table.getColumn(Receipt.HEADER_AFM).setCellEditor(new MyAfmCellEditor());
    //POSO
    table.getColumn(Receipt.HEADER_AMOUNT).setCellRenderer(new MyAmountCellRenderer());
    table.getColumn(Receipt.HEADER_AMOUNT).setCellEditor(new MyAmountCellEditor());
    //HMEROMINIA
    table.getColumn(Receipt.HEADER_BUY_DATE).setCellEditor(new MyJCalendarCellEditor());
    table.getColumn(Receipt.HEADER_BUY_DATE).setCellRenderer(new MyJCalendarCellRenderer());
    // EIDOS
    JComboBox types = new JComboBox(Type.getComboBoxModel());
    table.getColumn(Receipt.HEADER_TYPE_ID).setCellEditor(new DefaultCellEditor(types));
    setVisible(true);
  }

  public final void addRows() {
    Vector<Object> col = Receipt.getCollection(false, "", validReceipt,"DESC");
    Iterator<Object> it = col.iterator();
    while (it.hasNext()) {
      Receipt rec = (Receipt) it.next();
      Object data[] = {
        rec.getReceipt_id(),
        rec.getAfm(),
        rec.getAmount(),
        rec.getDate(),
        //Helper.convertDateForView(rec.getDate()),
        rec.getType(),
        rec.getComments()};
      tableModel.addRow(data);
    }

  }

  public final void addColumns() {
    String[] names = {Receipt.HEADER_RECEIPT_ID, Receipt.HEADER_AFM, Receipt.HEADER_AMOUNT,
      Receipt.HEADER_BUY_DATE, Receipt.HEADER_TYPE_ID, Receipt.HEADER_COMMENTS};
    int[] pref = {40, 100, 100, 100, 100, 100};
    int[] min = {40, 60, 60, 100, 100, 100, 100};
    int[] max = {60, 100, 200, 200, 200, 200};
    super.addColumns(names, pref, min, max);

  }

  public void update() {
    tableModel.setRowCount(0);
    addRows();
  }

  @Override
  public void delete(int id) {
    if (validReceipt) {
      if (Helper.confirm("Διαγραφή απόδειξης", "Θέλετε να διαγραφεί η απόδειξη με Α/Α " + id + ";") == JOptionPane.YES_OPTION) {
        Receipt.deleteById(id);
      }
    } else {
      Receipt.restoreById(id);
    }
    update();
    ((Main) getTopLevelAncestor()).updateTotalsPanel();
  }

  private void setModel() {
    tableModel = new MyTableModel() {

      @Override
      public boolean isCellEditable(int row, int col) {
        if (col > 0) {
          return true;
        } else {
          return false;
        }
      }

      @Override
      public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
          return Integer.class;
        }
        if (columnIndex == 2) {
          return Double.class;
        }
        if (columnIndex == 3) {
          return Date.class;
        }
        return super.getColumnClass(columnIndex);
      }
    };
  }

  public void tableChanged(TableModelEvent e) {
    Object rec[] = new Object[_NUMBER_OF_FIELDS];
    if (e.getType() == TableModelEvent.UPDATE) {
      int row = e.getFirstRow();
      TableModel model = (TableModel) e.getSource();

      for (int i = 0; i < _NUMBER_OF_FIELDS; i++) {
        rec[i] = model.getValueAt(row, i);

      }
      Date date = (Date) rec[3];

      try {
        double amount = (Double) rec[2];

        int type_id = Type.getIdByField(Type.TABLE, Type.COLUMN_DESCRIPTION, Type.COLUMN_TYPE_ID, (String) rec[4]);
        Receipt receipt = new Receipt(
            (Integer) rec[0],
            (String) rec[1],
            (Double) amount,
            (Date) rec[3],
            (Integer) type_id,
            (String) rec[5],
            validReceipt);
        receipt.save();
        m.updateTotalsPanel();
      } catch (SQLException ex) {
        Helper.message("Κάποιο λάθος δημιουργήθηκε στη βάση.\n Η εγγραφη δεν αποθηκεύθηκε.", "SQL σφάλμα", JOptionPane.ERROR_MESSAGE);
        Main.log(Level.SEVERE, "Κάποιο λάθος δημιουργήθηκε στη βάση.\n Η εγγραφη δεν αποθηκεύθηκε.", ex);
      }

    }
  }
}

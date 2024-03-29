/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TypoesPanel.java
 *
 * Created on 16 Ιαν 2010, 12:05:59 μμ
 */
package components;

import com.lowagie.text.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author lordovol
 */
public abstract class MyStaticTablePanel extends javax.swing.JPanel {

  protected int rowSelected;
  protected int colSelected;
  protected String title = "";
  protected String hint = "";
  protected MyTableModel tableModel;
  protected static Object object;
  protected int colNumber;
  protected int _NUMBER_OF_FIELDS;
  protected String _TABLE_NAME_;
  protected String _KIND_STATISTICS_ = "Kind statistics";
  protected String _MONTHLY_STATISTICS_ = "Monthly statistics";
  protected String _RECEIPTS_ = "Receipts";

  public MyStaticTablePanel() {
    super();
  }

  protected void init() {
    initComponents();
    table.getTableHeader().setFont(table.getTableHeader().getFont().deriveFont(Font.BOLD));
    scrollPane_table.setBorder(BorderFactory.createEmptyBorder());
    scrollPane_table.getViewport().setOpaque(false);
  }

  public void setTitle(String title) {
    label_title.setText(title);
  }

  public void setHint(String hint) {
    label_hint.setText(hint);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    scrollPane_table = new javax.swing.JScrollPane();
    table = new javax.swing.JTable();
    label_title = new javax.swing.JLabel();
    label_hint = new javax.swing.JLabel();
    label_hint2 = new javax.swing.JLabel();
    bt_popup = new javax.swing.JButton();
    panel_filter = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    tf_filter = new javax.swing.JTextField();

    scrollPane_table.setOpaque(false);

    table.setAutoCreateRowSorter(true);
    table.setModel(tableModel);
    table.setOpaque(false);
    table.setRowHeight(20);
    table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    scrollPane_table.setViewportView(table);

    label_title.setFont(label_title.getFont().deriveFont(label_title.getFont().getStyle() | java.awt.Font.BOLD, label_title.getFont().getSize()+2));
    label_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    label_title.setText(title);

    label_hint.setText(hint);

    label_hint2.setForeground(Color.BLUE);
    label_hint2.setText(hint);

    bt_popup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pie_chart.png"))); // NOI18N
    bt_popup.setBorder(null);
    bt_popup.setBorderPainted(false);
    bt_popup.setContentAreaFilled(false);
    bt_popup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel1.setText("Φίλτρο:");

    tf_filter.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        tf_filterKeyReleased(evt);
      }
    });

    javax.swing.GroupLayout panel_filterLayout = new javax.swing.GroupLayout(panel_filter);
    panel_filter.setLayout(panel_filterLayout);
    panel_filterLayout.setHorizontalGroup(
      panel_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panel_filterLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(tf_filter, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(35, Short.MAX_VALUE))
    );
    panel_filterLayout.setVerticalGroup(
      panel_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panel_filterLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panel_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(tf_filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(panel_filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addComponent(bt_popup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(scrollPane_table, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
              .addComponent(label_hint, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
              .addComponent(label_hint2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
              .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addGap(25, 25, 25)))
            .addContainerGap())))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(bt_popup, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addGap(11, 11, 11)
            .addComponent(label_title)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(panel_filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(scrollPane_table, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(label_hint)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(label_hint2)
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void tf_filterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_filterKeyReleased
    String text = tf_filter.getText().trim();
    final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
   table.setRowSorter(sorter);
    if (text.length() == 0) {
      sorter.setRowFilter(null);
    } else {
      sorter.setRowFilter(RowFilter.regexFilter("(?iu)" + text));
    }
  }//GEN-LAST:event_tf_filterKeyReleased

  protected void addColumns(String[] names, int[] pref, int[] min, int[] max) {

    colNumber = names.length;
    for (int i = 0; i < colNumber; i++) {
      tableModel.addColumn(names[i]);
      table.getTableHeader().getColumnModel().getColumn(i).setPreferredWidth(pref[i]);
      table.getTableHeader().getColumnModel().getColumn(i).setMaxWidth(max[i]);
      table.getTableHeader().getColumnModel().getColumn(i).setMinWidth(min[i]);
    }


  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  protected javax.swing.JButton bt_popup;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel label_hint;
  private javax.swing.JLabel label_hint2;
  private javax.swing.JLabel label_title;
  protected javax.swing.JPanel panel_filter;
  private javax.swing.JScrollPane scrollPane_table;
  protected javax.swing.JTable table;
  private javax.swing.JTextField tf_filter;
  // End of variables declaration//GEN-END:variables

  /**
   * @param secondHint the secondHint to set
   */
  public void setSecondHint(String secondHint) {
    label_hint2.setText(secondHint);
  }
}

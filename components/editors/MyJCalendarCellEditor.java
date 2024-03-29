/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package components.editors;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;
import receipts.Main;
import tools.options.Options;

/**
 * The cell editor for the datechooser
 * @author lordovol
 */
public class MyJCalendarCellEditor extends AbstractCellEditor implements TableCellEditor {

  private static final long serialVersionUID = 917881575221755609L;
  /**
   * The date chooser
   */
  private JDateChooser dateChooser = new JDateChooser();
  /**
   * The date format
   */
  private SimpleDateFormat f = new SimpleDateFormat(Options.DATE_FORMAT);
  Date originalValue;

  /**
   * Get the cell component
   * @param table The cells table
   * @param value The cells value
   * @param isSelected If the cell is selected
   * @param row The row number
   * @param column The column number
   * @return The date Chooser object
   */
  public Component getTableCellEditorComponent(JTable table, Object value,
          boolean isSelected, int row, int column) {
    originalValue =(Date) value;
    if (value instanceof Date) {
      dateChooser.setDateFormatString(Options.DATE_FORMAT);
      dateChooser.setDate((Date) value);
      return dateChooser;
    } else if (value instanceof String) {
      try {
        SimpleDateFormat sdf = new SimpleDateFormat(Options.DATE_FORMAT);
        Date date = sdf.parse((String) value);
        dateChooser.setDateFormatString(Options.DATE_FORMAT);
        dateChooser.setDate(date);
        return dateChooser;
      } catch (ParseException ex) {
        Main.log(Level.SEVERE, null, ex);
        return null;
      }
    }
    return null;
  }

   /**
   * Get the value of the cell
   * @return The cells value
   */
  public Date getCellEditorValue() {
    try {
      return dateChooser.getDate();
    } catch (NullPointerException ex) {
      return null;
    }
  }

  @Override
  public boolean stopCellEditing() {
      if(dateChooser.getDate()==null){
         dateChooser.setDate(originalValue);
      }
    return super.stopCellEditing();
  }


}

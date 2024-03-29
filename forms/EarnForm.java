/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CalcTaxes.java
 *
 * Created on 16 Φεβ 2011, 8:44:43 πμ
 */
package forms;

import com.googlecode.svalidators.formcomponents.ValidationGroup;
import com.googlecode.svalidators.validators.NumericValidator;
import com.googlecode.svalidators.validators.PositiveNumberValidator;
import components.MyDraggable;
import javax.swing.JOptionPane;
import models.Receipt;
import receipts.Main;
import tools.Helper;

/**
 *
 * @author ssoldatos
 */
public class EarnForm extends MyDraggable {

  private float totalAmount;
  public double owner = 0.0;
  public double married = 0.0;
  public boolean cancel = false;

  /** Creates new form CalcTaxes */
  public EarnForm() {
    Main.glassPane.activate(null);
    initComponents();
    countTotal();
    lb_totals.setText(Helper.convertAmountForViewing(totalAmount));
    tf_owner.addValidator(new PositiveNumberValidator("", false, false));
    tf_married.addValidator(new PositiveNumberValidator("0.00", false,true));
    setLocationRelativeTo(null);
    setVisible(true);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel2 = new javax.swing.JPanel();
    jPanel1 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    tf_owner = new com.googlecode.svalidators.formcomponents.STextField();
    tf_married = new com.googlecode.svalidators.formcomponents.STextField();
    jLabel4 = new javax.swing.JLabel();
    lb_totals = new javax.swing.JLabel();
    bt_cancel = new javax.swing.JButton();
    bt_ok = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

    jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanel1.setName("Εισόδημα συζύγου"); // NOI18N

    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel2.setText("Εισόδημα υπόχρεου :");

    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel3.setText("Εσόδημα συζύγου :");

    tf_owner.setName("Εισόδημα υπόχρεου"); // NOI18N
    tf_owner.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        tf_ownerFocusLost(evt);
      }
    });
    tf_owner.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        tf_ownerKeyReleased(evt);
      }
    });

    tf_married.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        tf_marriedFocusLost(evt);
      }
    });
    tf_married.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        tf_marriedKeyReleased(evt);
      }
    });

    jLabel4.setText("Συνολικό ποσό αποδείξεων :");

    lb_totals.setFont(lb_totals.getFont().deriveFont(lb_totals.getFont().getStyle() | java.awt.Font.BOLD));

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
          .addComponent(jLabel4))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(tf_owner, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
              .addComponent(tf_married, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(6, 6, 6)
            .addComponent(lb_totals, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(11, 11, 11)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(tf_owner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(tf_married, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel4)
          .addComponent(lb_totals, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE))
        .addContainerGap())
    );

    bt_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
    bt_cancel.setToolTipText("Ακύρωση");
    bt_cancel.setBorder(null);
    bt_cancel.setBorderPainted(false);
    bt_cancel.setContentAreaFilled(false);
    bt_cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    bt_cancel.setFocusPainted(false);
    bt_cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_cancelActionPerformed(evt);
      }
    });

    bt_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ok.png"))); // NOI18N
    bt_ok.setToolTipText("Υπολογισμός");
    bt_ok.setBorder(null);
    bt_ok.setBorderPainted(false);
    bt_ok.setContentAreaFilled(false);
    bt_ok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    bt_ok.setFocusPainted(false);
    bt_ok.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_okActionPerformed(evt);
      }
    });

    jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, jLabel1.getFont().getSize()+2));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Υπολογισμός φόρου");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
            .addContainerGap())
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(bt_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(4, 4, 4))
          .addComponent(bt_ok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(bt_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
        .addComponent(bt_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void bt_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelActionPerformed
      dispose();
      cancel = true;
      Main.glassPane.deactivate();
    }//GEN-LAST:event_bt_cancelActionPerformed

    private void bt_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_okActionPerformed
      ValidationGroup group = new ValidationGroup();
      group.addComponent(tf_married);
      group.addComponent(tf_owner);
      if (group.validate()) {
        owner = Double.parseDouble(tf_owner.getText().trim());
        married = Double.parseDouble(tf_married.getText().trim().equals("") ? "0.0" :  tf_married.getText().trim());
        dispose();
        Main.glassPane.deactivate();
      } else {
        String er = group.getErrorMessage();
        Helper.message(er, "Υπολογισμός φόρου", JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_bt_okActionPerformed

    private void tf_ownerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_ownerFocusLost
      String am = Helper.fixAmount(tf_owner.getText().trim());
      tf_owner.setText(am);
    }//GEN-LAST:event_tf_ownerFocusLost

    private void tf_marriedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_marriedFocusLost
      String am = Helper.fixAmount(tf_married.getText().trim());
      tf_married.setText(am);
    }//GEN-LAST:event_tf_marriedFocusLost

    private void tf_ownerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_ownerKeyReleased
      tf_owner.setText(tf_owner.getText().replaceAll(",", "."));
    }//GEN-LAST:event_tf_ownerKeyReleased

    private void tf_marriedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_marriedKeyReleased
      tf_married.setText(tf_married.getText().replaceAll(",", "."));
    }//GEN-LAST:event_tf_marriedKeyReleased
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton bt_cancel;
  private javax.swing.JButton bt_ok;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JLabel lb_totals;
  private com.googlecode.svalidators.formcomponents.STextField tf_married;
  private com.googlecode.svalidators.formcomponents.STextField tf_owner;
  // End of variables declaration//GEN-END:variables

  private void countTotal() {
    totalAmount = Receipt.getAmount("");
  }
}

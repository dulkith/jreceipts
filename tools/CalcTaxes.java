/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CalcTaxes.java
 *
 * Created on 16 Φεβ 2011, 9:25:48 πμ
 */
package tools;

import components.MyDraggable;
import models.Receipt;
import org.jopendocument.util.PrintUtilities;
import receipts.Main;

/**
 *
 * @author ssoldatos
 */
public class CalcTaxes extends MyDraggable implements Taxes {

  private static final long serialVersionUID = 45757585L;
  private final double owner;
  private final double married;
  private float total;
  private double ownerNeeded;
  private String ownerNeededExpl;
  private double marriedNeeded;
  private String marriedNeededExpl;
  private double ownerRatio;
  private String ownerRatioExpl;
  private double marriedRatio;
  private String marriedRatioExpl;
  private double totalNeeded;
  private double ownerTax;
  private String ownerTaxExp;
  private double marriedTax;
  private String marriedTaxExp;
  private double totalTax;
  private String taxResult;
  private String totalForosResult;

  public CalcTaxes(double owner, double married) {
    Main.glassPane.activate(null);
    this.owner = owner;
    this.married = married;
    total = Receipt.getAmount("");
    if (married == 0) {
      if (total > MAX_OWNER_TOTAL) {
        total = MAX_OWNER_TOTAL;
      }
    } else {
      if (total > MAX_OWNER_MARRIED_TOTAL) {
        total = MAX_OWNER_MARRIED_TOTAL;
      }
    }
    calculate();
    initComponents();
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

    jPanel1 = new javax.swing.JPanel();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    panel = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    jLabel12 = new javax.swing.JLabel();
    lb_foros = new javax.swing.JLabel();
    jLabel14 = new javax.swing.JLabel();
    jLabel15 = new javax.swing.JLabel();
    lb_totalForos = new javax.swing.JLabel();
    lb_totalEarn = new javax.swing.JLabel();
    lb_total_owner = new javax.swing.JLabel();
    lb_total_married = new javax.swing.JLabel();
    lb_totalEarn3 = new javax.swing.JLabel();
    lb_owner_needed = new javax.swing.JLabel();
    lb_owner_neededExp = new javax.swing.JLabel();
    lb_married_needed = new javax.swing.JLabel();
    lb_married_neededExp = new javax.swing.JLabel();
    lb_total_needed = new javax.swing.JLabel();
    lb_owner_ratio = new javax.swing.JLabel();
    lb_owner_ratioExp = new javax.swing.JLabel();
    lb_married_ratio = new javax.swing.JLabel();
    lb_married_ratioExp = new javax.swing.JLabel();
    lb_owner_tax = new javax.swing.JLabel();
    lb_owner_taxExp = new javax.swing.JLabel();
    lb_married_tax = new javax.swing.JLabel();
    lb_married_taxExp = new javax.swing.JLabel();
    lb_total_tax = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
    jButton1.setToolTipText("Κλείσιμο");
    jButton1.setBorder(null);
    jButton1.setBorderPainted(false);
    jButton1.setContentAreaFilled(false);
    jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jButton1.setFocusPainted(false);
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/printer.png"))); // NOI18N
    jButton2.setToolTipText("Εκτύπωση");
    jButton2.setBorder(null);
    jButton2.setBorderPainted(false);
    jButton2.setContentAreaFilled(false);
    jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jButton2.setFocusPainted(false);
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    panel.setBackground(new java.awt.Color(255, 255, 255));
    panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel2.setText("Συνολικό εισόδημα :");

    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel3.setText("Εισόδημα υπόχρεου :");

    jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel4.setText("Εισόδημα συζύγου :");

    jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel5.setText("Συνολικό ποσό αποδείξεων :");

    jLabel6.setFont(jLabel6.getFont().deriveFont(jLabel6.getFont().getStyle() | java.awt.Font.BOLD));
    jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel6.setText("Υπολογισμός απαιτούμενου ποσού αποδείξεων");

    jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel7.setText("Υπόχρεου :");

    jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel8.setText("Συζύγου :");

    jLabel9.setText("Συνολικό ποσό απαιτούμενων αποδείξεων :");

    jLabel10.setFont(jLabel10.getFont().deriveFont(jLabel10.getFont().getStyle() | java.awt.Font.BOLD));
    jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel10.setText("Επιμερισμός ποσού δηλωμένων αποδείξεων");

    jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel11.setText("Υπόχρεου :");

    jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel12.setText("Συζύγου :");

    lb_foros.setFont(lb_foros.getFont().deriveFont(lb_foros.getFont().getStyle() | java.awt.Font.BOLD));
    lb_foros.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lb_foros.setText(taxResult);

    jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel14.setText("Υπόχρεου :");

    jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel15.setText("Συζύγου :");

    lb_totalForos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    lb_totalForos.setText(totalForosResult);

    lb_totalEarn.setFont(lb_totalEarn.getFont().deriveFont(lb_totalEarn.getFont().getStyle() | java.awt.Font.BOLD));
    lb_totalEarn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lb_totalEarn.setText(Helper.convertAmountForViewing(married+owner));

    lb_total_owner.setFont(lb_total_owner.getFont().deriveFont(lb_total_owner.getFont().getStyle() | java.awt.Font.BOLD));
    lb_total_owner.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lb_total_owner.setText(Helper.convertAmountForViewing(owner));

    lb_total_married.setFont(lb_total_married.getFont().deriveFont(lb_total_married.getFont().getStyle() | java.awt.Font.BOLD));
    lb_total_married.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lb_total_married.setText(Helper.convertAmountForViewing(married));

    lb_totalEarn3.setFont(lb_totalEarn3.getFont().deriveFont(lb_totalEarn3.getFont().getStyle() | java.awt.Font.BOLD));
    lb_totalEarn3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lb_totalEarn3.setText(Helper.convertAmountForViewing(total));

    lb_owner_needed.setFont(lb_owner_needed.getFont().deriveFont(lb_owner_needed.getFont().getStyle() | java.awt.Font.BOLD));
    lb_owner_needed.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lb_owner_needed.setText(Helper.convertAmountForViewing(ownerNeeded));

    lb_owner_neededExp.setText(ownerNeededExpl);

    lb_married_needed.setFont(lb_married_needed.getFont().deriveFont(lb_married_needed.getFont().getStyle() | java.awt.Font.BOLD));
    lb_married_needed.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lb_married_needed.setText(Helper.convertAmountForViewing(marriedNeeded));

    lb_married_neededExp.setText(marriedNeededExpl);

    lb_total_needed.setFont(lb_total_needed.getFont().deriveFont(lb_total_needed.getFont().getStyle() | java.awt.Font.BOLD));
    lb_total_needed.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lb_total_needed.setText(Helper.convertAmountForViewing(totalNeeded));

    lb_owner_ratio.setFont(lb_owner_ratio.getFont().deriveFont(lb_owner_ratio.getFont().getStyle() | java.awt.Font.BOLD));
    lb_owner_ratio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lb_owner_ratio.setText(Helper.convertAmountForViewing(ownerRatio));

    lb_owner_ratioExp.setText(ownerRatioExpl);

    lb_married_ratio.setFont(lb_married_ratio.getFont().deriveFont(lb_married_ratio.getFont().getStyle() | java.awt.Font.BOLD));
    lb_married_ratio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lb_married_ratio.setText(Helper.convertAmountForViewing(marriedRatio));

    lb_married_ratioExp.setText(marriedRatioExpl);

    lb_owner_tax.setFont(lb_owner_tax.getFont().deriveFont(lb_owner_tax.getFont().getStyle() | java.awt.Font.BOLD));
    lb_owner_tax.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lb_owner_tax.setText(Helper.convertAmountForViewing(ownerTax));

    lb_owner_taxExp.setText(ownerTaxExp);

    lb_married_tax.setFont(lb_married_tax.getFont().deriveFont(lb_married_tax.getFont().getStyle() | java.awt.Font.BOLD));
    lb_married_tax.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lb_married_tax.setText(Helper.convertAmountForViewing(marriedTax));

    lb_married_taxExp.setText(marriedTaxExp);

    lb_total_tax.setFont(lb_total_tax.getFont().deriveFont(lb_total_tax.getFont().getStyle() | java.awt.Font.BOLD, lb_total_tax.getFont().getSize()+2));
    lb_total_tax.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lb_total_tax.setText(Helper.convertAmountForViewing(totalTax));
    lb_total_tax.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
    panel.setLayout(panelLayout);
    panelLayout.setHorizontalGroup(
      panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(panelLayout.createSequentialGroup()
            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(lb_totalEarn, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
              .addComponent(lb_total_owner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
              .addComponent(lb_total_married, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
              .addComponent(lb_totalEarn3, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE))
            .addGap(56, 56, 56))
          .addGroup(panelLayout.createSequentialGroup()
            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(lb_married_taxExp, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGroup(panelLayout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(lb_married_ratio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                      .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(lb_owner_ratio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(lb_married_needed, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                      .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(lb_owner_needed, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addGroup(panelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lb_married_tax, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addGroup(panelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lb_owner_tax, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(254, 254, 254))
              .addGroup(panelLayout.createSequentialGroup()
                .addComponent(lb_totalForos, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_total_tax, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201))
              .addGroup(panelLayout.createSequentialGroup()
                .addComponent(lb_foros, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(panelLayout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 517, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(panelLayout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
              .addGroup(panelLayout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_total_needed, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(panelLayout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 517, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(panelLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(panelLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(panelLayout.createSequentialGroup()
                .addComponent(lb_owner_neededExp, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addGap(254, 254, 254))
              .addGroup(panelLayout.createSequentialGroup()
                .addComponent(lb_married_neededExp, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(panelLayout.createSequentialGroup()
                .addComponent(lb_owner_ratioExp, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(panelLayout.createSequentialGroup()
                .addComponent(lb_married_ratioExp, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(panelLayout.createSequentialGroup()
                .addComponent(lb_owner_taxExp, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(395, 395, 395))))
    );

    panelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lb_married_neededExp, lb_married_ratioExp, lb_married_taxExp, lb_owner_neededExp, lb_owner_ratioExp, lb_owner_taxExp});

    panelLayout.setVerticalGroup(
      panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lb_totalEarn))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
          .addComponent(lb_total_owner, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
          .addComponent(lb_total_married))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(jLabel5)
          .addComponent(lb_totalEarn3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addComponent(jLabel6)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lb_owner_needed, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(lb_owner_neededExp, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lb_married_needed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(lb_married_neededExp)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lb_owner_ratio, javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel9)
              .addComponent(lb_total_needed))
            .addGap(27, 27, 27)
            .addComponent(jLabel10)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel11)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(lb_owner_ratioExp)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lb_married_ratio, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(lb_married_ratioExp)
        .addGap(18, 18, 18)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lb_owner_tax, javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
            .addComponent(lb_foros, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel14)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(lb_owner_taxExp)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lb_married_tax, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(lb_married_taxExp)
        .addGap(7, 7, 7)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lb_totalForos)
          .addComponent(lb_total_tax))
        .addContainerGap())
    );

    jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, jLabel1.getFont().getSize()+2));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Υπολογισμός φόρου");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(11, 11, 11)
            .addComponent(jLabel1)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Main.glassPane.deactivate();
    dispose();
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    PrintUtilities.printComponent(panel);
  }//GEN-LAST:event_jButton2ActionPerformed
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JLabel lb_foros;
  private javax.swing.JLabel lb_married_needed;
  private javax.swing.JLabel lb_married_neededExp;
  private javax.swing.JLabel lb_married_ratio;
  private javax.swing.JLabel lb_married_ratioExp;
  private javax.swing.JLabel lb_married_tax;
  private javax.swing.JLabel lb_married_taxExp;
  private javax.swing.JLabel lb_owner_needed;
  private javax.swing.JLabel lb_owner_neededExp;
  private javax.swing.JLabel lb_owner_ratio;
  private javax.swing.JLabel lb_owner_ratioExp;
  private javax.swing.JLabel lb_owner_tax;
  private javax.swing.JLabel lb_owner_taxExp;
  private javax.swing.JLabel lb_totalEarn;
  private javax.swing.JLabel lb_totalEarn3;
  private javax.swing.JLabel lb_totalForos;
  private javax.swing.JLabel lb_total_married;
  private javax.swing.JLabel lb_total_needed;
  private javax.swing.JLabel lb_total_owner;
  private javax.swing.JLabel lb_total_tax;
  private javax.swing.JPanel panel;
  // End of variables declaration//GEN-END:variables

  private void calculate() {
    calcOwnerNeeded();
    calcMarriedNeeded();
    totalNeeded = ownerNeeded + marriedNeeded;
    calcOwnerRatio();
    calcMarriedRatio();
    calcOwnerTax();
    calcMarriedTax();
    calcTotalTax();
  }

  private void calcOwnerNeeded() {
    Object[] c = calcNeeded(owner);
    ownerNeeded = (Double) c[0];
    ownerNeededExpl = (String) c[1];
  }

  private void calcMarriedNeeded() {
    Object[] c = calcNeeded(married);
    marriedNeeded = (Double) c[0];
    marriedNeededExpl = (String) c[1];
  }

  private Object[] calcNeeded(double amount) {
    if (amount <= MIN_EARN_THAT_NOT_NEEDS_RECEIPT) {
      return new Object[]{0.0, "Δεν απαιτούνται"};
    } else if (amount > MAX_EARN) {
      return new Object[]{MAX_NEED, "Μεγιστο ποσό για εισοδήματα > " + MAX_EARN};
    } else {
      double validPercent = MAX_NEED * PER_CENT_FOR_VALID_RECEIPTS / 100;
      double invalidPercent = (amount - MAX_NEED) * PER_CENT_FOR_INVALID_RECEIPTS / 100;
      double tot = validPercent + invalidPercent;
      String ex = "("
          + Helper.convertAmountForViewing(12000) + " x " + PER_CENT_FOR_VALID_RECEIPTS + "% + "
          + (Helper.convertAmountForViewing(amount - 12000)) + " x " + PER_CENT_FOR_INVALID_RECEIPTS + "% = "
          + Helper.convertAmountForViewing(validPercent + invalidPercent) + ")";
      return new Object[]{tot, ex};
    }
  }

  private void calcOwnerRatio() {
    Object[] c = calcRatio(owner);
    ownerRatio = (Double) c[0];
    ownerRatioExpl = (String) c[1];
  }

  private void calcMarriedRatio() {
    Object[] c = calcRatio(married);
    marriedRatio = (Double) c[0];
    marriedRatioExpl = (String) c[1];
  }

  private Object[] calcRatio(double amount) {
    double t = total * (amount / (owner + married));
    String e = Helper.convertAmountForViewing(total) + " x ("
        + Helper.convertAmountForViewing(amount) + "/("
        + Helper.convertAmountForViewing(owner) + " +"
        + Helper.convertAmountForViewing(married) + "))";

    return new Object[]{t, e};
  }

  private void calcOwnerTax() {
    ownerTax = (ownerRatio - ownerNeeded) * PER_CENT_TAX_BONUS / 100;
    ownerTaxExp = "(" + Helper.convertAmountForViewing(ownerRatio) + " - "
        + Helper.convertAmountForViewing(ownerNeeded) + ") x " + PER_CENT_TAX_BONUS + "%";
  }

  private void calcMarriedTax() {
    marriedTax = (marriedRatio - marriedNeeded) * PER_CENT_TAX_BONUS / 100;
    marriedTaxExp = "(" + Helper.convertAmountForViewing(marriedRatio) + " - "
        + Helper.convertAmountForViewing(marriedNeeded) + ") x " + PER_CENT_TAX_BONUS + "%";
  }

  private void calcTotalTax() {
    totalTax = ownerTax + marriedTax;
    if (totalTax < 0) {
      taxResult = "Επιβάρυνση φόρου";
      totalForosResult = "Συνολική επιβάρυνση φόρου:";
    } else {
      taxResult = "Ωφέλεια φόρου";
      totalForosResult = "Συνολική ωφέλεια φόρου:";
    }
  }
}

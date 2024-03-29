/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * OptionsForm.java
 *
 * Created on 18 Φεβ 2011, 7:44:03 πμ
 */
package tools.options;

import components.MyDraggable;
import components.buttons.Button;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import receipts.Main;
import tools.Helper;
import tools.LookAndFeels;

/**
 *
 * @author ssoldatos
 */
public class OptionsForm extends MyDraggable {

  private static final long serialVersionUID = 34643574757L;
  public static String GENERAL = "Γενικα";
  public static String VASEIS = "Βάσεις";
  public static String INTERNET = "Internet";
  private JPanel generalPanel = new GeneralPanel();
  private JPanel dbPanel = new DBPanel();
  private JPanel internetPanel = new InternetPanel();
  private Main m;

  /** Creates new form OptionsForm */
  public OptionsForm(Main m) {
    this.m = m;
    Main.glassPane.activate(null);
    initComponents();
    tree.setSelectionRow(1);
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

    panel_top = new javax.swing.JPanel();
    panel_main = new javax.swing.JPanel();
    panel_options = new javax.swing.JPanel();
    panel_tree = new javax.swing.JScrollPane();
    tree = new javax.swing.JTree();
    jLabel1 = new javax.swing.JLabel();
    bt_cancel = new components.buttons.Button();
    bt_ok = new components.buttons.Button(Button.OK);

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

    panel_top.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    panel_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Ρυθμίσεις");
    javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Γενικά");
    treeNode1.add(treeNode2);
    treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Βάσεις");
    treeNode1.add(treeNode2);
    treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Internet");
    treeNode1.add(treeNode2);
    tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
    tree.setCellRenderer(new OptionsTreeCellRenderer());
    tree.setRowHeight(24);
    tree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
      public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
        treeValueChanged(evt);
      }
    });
    panel_tree.setViewportView(tree);

    javax.swing.GroupLayout panel_mainLayout = new javax.swing.GroupLayout(panel_main);
    panel_main.setLayout(panel_mainLayout);
    panel_mainLayout.setHorizontalGroup(
      panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panel_mainLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(panel_tree, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(panel_options, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
        .addContainerGap())
    );
    panel_mainLayout.setVerticalGroup(
      panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_mainLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(panel_options, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
          .addComponent(panel_tree, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
        .addContainerGap())
    );

    jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, jLabel1.getFont().getSize()+2));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Ρυθμίσεις");

    bt_cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_cancelActionPerformed(evt);
      }
    });

    bt_ok.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_okActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout panel_topLayout = new javax.swing.GroupLayout(panel_top);
    panel_top.setLayout(panel_topLayout);
    panel_topLayout.setHorizontalGroup(
      panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panel_topLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_topLayout.createSequentialGroup()
              .addComponent(panel_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addContainerGap())
            .addComponent(bt_cancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panel_topLayout.createSequentialGroup()
              .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addContainerGap()))
          .addComponent(bt_ok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
    );
    panel_topLayout.setVerticalGroup(
      panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panel_topLayout.createSequentialGroup()
        .addComponent(bt_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(panel_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bt_ok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
      .addGroup(panel_topLayout.createSequentialGroup()
        .addGap(9, 9, 9)
        .addComponent(jLabel1)
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel_top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel_top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void bt_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelActionPerformed
      Main.glassPane.deactivate();
      dispose();
    }//GEN-LAST:event_bt_cancelActionPerformed

    private void bt_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_okActionPerformed
      Main.glassPane.deactivate();
      try {
        String oldLook = Options.toString(Options.LOOK_FEEL);
        new OptionsParser(new JPanel[]{dbPanel, internetPanel, generalPanel});
        String newLook = Options.toString(Options.LOOK_FEEL);
        if (!oldLook.equals(newLook)) {
          LookAndFeels.setLookAndFeel(Options.toString(Options.LOOK_FEEL));
          SwingUtilities.updateComponentTreeUI(m);
          m.pack();

        }
      } catch (Exception ex) {
        Main.logger.log(Level.SEVERE, null, ex);
      }
      dispose();
    }//GEN-LAST:event_bt_okActionPerformed

    private void treeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeValueChanged
      String sel = evt.getNewLeadSelectionPath().getLastPathComponent().toString();
      if (sel.equals(VASEIS)) {
        setPanel(dbPanel);
      } else if (sel.equals(INTERNET)) {
        setPanel(internetPanel);
      } else if (sel.equals(GENERAL)) {
        setPanel(generalPanel);
      } else {
        setPanel(generalPanel);
      }
    }//GEN-LAST:event_treeValueChanged
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private components.buttons.Button bt_cancel;
  private components.buttons.Button bt_ok;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel panel_main;
  private javax.swing.JPanel panel_options;
  private javax.swing.JPanel panel_top;
  private javax.swing.JScrollPane panel_tree;
  private javax.swing.JTree tree;
  // End of variables declaration//GEN-END:variables

  private void setPanel(JPanel panel) {
    if (panel_options.getComponentCount() > 0) {
      panel_options.remove(0);
    }
    panel_options.add(panel);
    panel_options.validate();
    panel_options.repaint();
  }
}

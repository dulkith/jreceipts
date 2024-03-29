/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Main.java
 *
 * Created on 14 Ιαν 2010, 6:53:26 μμ
 */
package receipts;

import com.googlecode.svalidators.validators.PositiveNumberValidator;
import com.googlecode.svalidators.validators.RequiredValidator;
import com.googlecode.svalidators.validators.SValidator;
import models.Database;
import components.MyDisabledGlassPane;
import exceptions.ErrorMessages;
import export.CsvExport;
import export.ExcelExport;
import export.PdfExport;
import forms.AddReceipt;
import forms.InputField;
import importDb.ImportAscii;
import importDb.ImportMdb;
import importDb.ImportOds;
import importDb.ImportXls;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
import models.Afm;
import models.Receipt;
import models.Type;
import panels.AfmsTablePanel;
import panels.KindTablePanel;
import panels.MonthlyTablePanel;
import panels.ReceiptsTablePanel;
import panels.TypesTablePanel;
import panels.totalsPanel;
import forms.EarnForm;
import java.awt.Font;
import java.io.FilenameFilter;
import java.net.URI;
import javax.swing.UIManager;
import tools.About;
import tools.CalcTaxes;
import tools.CheckUpdate;
import tools.Fonts;
import tools.Helper;
import tools.LookAndFeels;
import tools.options.Options;
import tools.log.myLogger;
import tools.options.OptionsForm;

/**
 *
 * @author lordovol
 */
public class Main extends javax.swing.JFrame {

  public static MyDisabledGlassPane glassPane;
  public static final long serialVersionUID = 13456457457L;
  public static Logger logger;
  public static String version = "1.0 beta";
  public static String revision = "42";
  public static String date = "17/02/2010";
  public static String TITLE = "Αποδείξεις";
  private static String tmpCompany = "";

  /** Creates new form Main */
  public Main() throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

    setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/receiptsList.png")).getImage());
    createDirs();
    // if (Options.toBoolean(Options.DEBUG)) {
    createLogger();
    // }
    Options.getOptions();
     Fonts f = new Fonts();
    f.setDefaultFont("Arial");
    LookAndFeels laf = new LookAndFeels();
    try {
      laf.setLookAndFeel(Options.toString(Options.LOOK_FEEL));
    } catch (Exception ex) {
      try {
        laf.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      } catch (Exception ex1) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
      }
    }
    SwingUtilities.updateComponentTreeUI(this);

   
    //Skin skin = new Skin(Color.yellow);
    //Skin.applySkin();

    logger.log(Level.INFO, "Initializing components");
    initComponents();

    glassPane = new MyDisabledGlassPane();
    JRootPane root = SwingUtilities.getRootPane(this);
    root.setGlassPane(glassPane);
    logger.log(Level.FINE, "Components initialized");
    logger.log(Level.INFO, "Creating connection to database");
    Database.createConnection(false);
    if (Options.toBoolean(Options.START_UP_BACKUP)) {
      backUpDb();
    }
    logger.log(Level.FINE, "Connected to database: {0}", Options.toString(Options.DATABASE));
    logger.log(Level.INFO, "Setting the year");
    setYear();
    logger.log(Level.FINE, "Year set to : {0}", Options.YEAR);
    setAppTitle();
    logger.log(Level.INFO, "Updating panels");
    updateReceiptPanel();
    updateTotalsPanel();
    logger.log(Level.FINE, "Panels updated");
    setLocationRelativeTo(null);
    if (Options.toBoolean(Options.AUTO_UPDATE)) {
      CheckUpdate c = new CheckUpdate(true);
    }
    setVisible(true);

  }

  public static void log(Level level, String message, Exception ex) {
    if (Options.toBoolean(Options.DEBUG)) {
      logger.log(level, message, ex);
    }
  }

  private static void createLogger() {
    // Create an appending file handler
    logger = myLogger.createHtmlLogger("JRECEIPTS", Options.LOG_PATH + "Receipts", 262144, true, 1);
//      boolean append = true;
//      int limit = 1000000; // 1 Mb
//      int numLogFiles = 5;
//      FileHandler fh = new FileHandler(Options.LOG_PATH + "Receipts_%g.html", limit, numLogFiles, true);
//      fh.setFormatter(new SimpleFormatter());
//      // Add to the desired logger
//      logger = Logger.getLogger("Receipts");
//      logger.addHandler(fh);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    toolbar = new javax.swing.JToolBar();
    toolbar_button_addDatabase = new javax.swing.JButton();
    toolbar_button_loadDatabase = new javax.swing.JButton();
    toolbal_button_renameDatabase = new javax.swing.JButton();
    toolbar_button_deleteDatabase = new javax.swing.JButton();
    toolbar_button_restoreBackup = new javax.swing.JButton();
    toolbar_button_selectYear = new javax.swing.JButton();
    jSeparator9 = new javax.swing.JToolBar.Separator();
    toolbar_button_addReceipt = new javax.swing.JButton();
    toolbar_button_listReceipts = new javax.swing.JButton();
    toolbar_button_deletedReceipts = new javax.swing.JButton();
    jSeparator1 = new javax.swing.JToolBar.Separator();
    toolbar_button_addType = new javax.swing.JButton();
    toolbar_button_typeList = new javax.swing.JButton();
    jSeparator2 = new javax.swing.JToolBar.Separator();
    toolbar_button_addAfm = new javax.swing.JButton();
    toolbar_button_listAfm = new javax.swing.JButton();
    jSeparator3 = new javax.swing.JToolBar.Separator();
    bt_calcTaxes = new javax.swing.JButton();
    toolbal_button_settings = new javax.swing.JButton();
    toolbar_button_monthlyStats = new javax.swing.JButton();
    toolbar_button_kindStats = new javax.swing.JButton();
    jSeparator4 = new javax.swing.JToolBar.Separator();
    button_excel = new javax.swing.JButton();
    button_csv = new javax.swing.JButton();
    button_pdf = new javax.swing.JButton();
    panel_body = new javax.swing.JPanel();
    splitPane = new javax.swing.JSplitPane();
    panel_leftTop = new javax.swing.JPanel();
    panel_main = new javax.swing.JPanel();
    menuBar = new javax.swing.JMenuBar();
    databases = new javax.swing.JMenu();
    menu_edit = new javax.swing.JMenu();
    menuItem_addDatabase = new javax.swing.JMenuItem();
    menuItem_loadDatabase = new javax.swing.JMenuItem();
    menuItem_deleteDatabase = new javax.swing.JMenuItem();
    menuItem_restoreBackup = new javax.swing.JMenuItem();
    menuItem_renameDatabase = new javax.swing.JMenuItem();
    menu_importDatabase = new javax.swing.JMenu();
    menuItem_importAscii = new javax.swing.JMenuItem();
    menuItem_importXls = new javax.swing.JMenuItem();
    menuItem_importMdb = new javax.swing.JMenuItem();
    menuItem_importOds = new javax.swing.JMenuItem();
    jMenu1 = new javax.swing.JMenu();
    menuItem_excel = new javax.swing.JMenuItem();
    menuItem_csv = new javax.swing.JMenuItem();
    menuItem_pdf = new javax.swing.JMenuItem();
    menuItem_selectYear = new javax.swing.JMenuItem();
    jSeparator5 = new javax.swing.JPopupMenu.Separator();
    menuItem_exit = new javax.swing.JMenuItem();
    receipts = new javax.swing.JMenu();
    menuItem_addReceipt = new javax.swing.JMenuItem();
    menuItem_receiptList = new javax.swing.JMenuItem();
    menuItem_deletedReceipts = new javax.swing.JMenuItem();
    types = new javax.swing.JMenu();
    menuItem_addType = new javax.swing.JMenuItem();
    menuItem_editType = new javax.swing.JMenuItem();
    jSeparator6 = new javax.swing.JSeparator();
    menuItem_addAfm = new javax.swing.JMenuItem();
    menuItem_editAfm = new javax.swing.JMenuItem();
    menuItem_toolbar = new javax.swing.JCheckBoxMenuItem();
    stats = new javax.swing.JMenu();
    menuItem_calcTaxes = new javax.swing.JMenuItem();
    jSeparator8 = new javax.swing.JPopupMenu.Separator();
    menuItem_monthlyStats = new javax.swing.JMenuItem();
    menuItem_kindStats = new javax.swing.JMenuItem();
    jSeparator7 = new javax.swing.JSeparator();
    menuItem_options = new javax.swing.JMenuItem();
    help = new javax.swing.JMenu();
    menuItem_help = new javax.swing.JMenuItem();
    menuItem_website = new javax.swing.JMenuItem();
    menuItem_contact = new javax.swing.JMenuItem();
    jSeparator11 = new javax.swing.JPopupMenu.Separator();
    menuItem_info = new javax.swing.JMenuItem();
    MenuItem_checkUpdate = new javax.swing.JMenuItem();
    menuItem_logFile = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Αποδείξεις (Βάση:"+Options.toString(Options.DATABASE)+")");
    setMinimumSize(new java.awt.Dimension(800, 600));
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent evt) {
        formWindowClosing(evt);
      }
    });

    toolbar.setRollover(true);
    toolbar.setMargin(new java.awt.Insets(2, 2, 2, 2));

    toolbar_button_addDatabase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/database_save.png"))); // NOI18N
    toolbar_button_addDatabase.setToolTipText("Προσθήκη βάσης");
    toolbar_button_addDatabase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    toolbar_button_addDatabase.setFocusable(false);
    toolbar_button_addDatabase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    toolbar_button_addDatabase.setOpaque(false);
    toolbar_button_addDatabase.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    toolbar_button_addDatabase.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        toolbar_button_addDatabaseActionPerformed(evt);
      }
    });
    toolbar.add(toolbar_button_addDatabase);

    toolbar_button_loadDatabase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/load_database.png"))); // NOI18N
    toolbar_button_loadDatabase.setToolTipText("Επιλογή βάσης");
    toolbar_button_loadDatabase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    toolbar_button_loadDatabase.setFocusable(false);
    toolbar_button_loadDatabase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    toolbar_button_loadDatabase.setOpaque(false);
    toolbar_button_loadDatabase.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    toolbar_button_loadDatabase.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        toolbar_button_loadDatabaseActionPerformed(evt);
      }
    });
    toolbar.add(toolbar_button_loadDatabase);

    toolbal_button_renameDatabase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rename.png"))); // NOI18N
    toolbal_button_renameDatabase.setToolTipText("Μετονομασία βάσης");
    toolbal_button_renameDatabase.setFocusable(false);
    toolbal_button_renameDatabase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    toolbal_button_renameDatabase.setOpaque(false);
    toolbal_button_renameDatabase.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    toolbal_button_renameDatabase.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        toolbal_button_renameDatabaseActionPerformed(evt);
      }
    });
    toolbar.add(toolbal_button_renameDatabase);

    toolbar_button_deleteDatabase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/database_delete.png"))); // NOI18N
    toolbar_button_deleteDatabase.setToolTipText("Διαγραφή βάσης");
    toolbar_button_deleteDatabase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    toolbar_button_deleteDatabase.setFocusable(false);
    toolbar_button_deleteDatabase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    toolbar_button_deleteDatabase.setOpaque(false);
    toolbar_button_deleteDatabase.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    toolbar_button_deleteDatabase.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        toolbar_button_deleteDatabaseActionPerformed(evt);
      }
    });
    toolbar.add(toolbar_button_deleteDatabase);

    toolbar_button_restoreBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/restore_backup.png"))); // NOI18N
    toolbar_button_restoreBackup.setToolTipText("Άνοιγμα backup βάσης");
    toolbar_button_restoreBackup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    toolbar_button_restoreBackup.setFocusable(false);
    toolbar_button_restoreBackup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    toolbar_button_restoreBackup.setOpaque(false);
    toolbar_button_restoreBackup.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    toolbar_button_restoreBackup.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        toolbar_button_restoreBackupActionPerformed(evt);
      }
    });
    toolbar.add(toolbar_button_restoreBackup);

    toolbar_button_selectYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/year.png"))); // NOI18N
    toolbar_button_selectYear.setToolTipText("Επιλογή έτους");
    toolbar_button_selectYear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    toolbar_button_selectYear.setFocusable(false);
    toolbar_button_selectYear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    toolbar_button_selectYear.setOpaque(false);
    toolbar_button_selectYear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    toolbar_button_selectYear.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        toolbar_button_selectYearActionPerformed(evt);
      }
    });
    toolbar.add(toolbar_button_selectYear);
    toolbar.add(jSeparator9);

    toolbar_button_addReceipt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addReceipts.png"))); // NOI18N
    toolbar_button_addReceipt.setToolTipText("Εισαγωγή απόδειξης");
    toolbar_button_addReceipt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    toolbar_button_addReceipt.setFocusable(false);
    toolbar_button_addReceipt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    toolbar_button_addReceipt.setMargin(new java.awt.Insets(2, 2, 2, 2));
    toolbar_button_addReceipt.setOpaque(false);
    toolbar_button_addReceipt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    toolbar_button_addReceipt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        toolbar_button_addReceiptActionPerformed(evt);
      }
    });
    toolbar.add(toolbar_button_addReceipt);

    toolbar_button_listReceipts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/receiptsList.png"))); // NOI18N
    toolbar_button_listReceipts.setToolTipText("Λίστα αποδείξεων");
    toolbar_button_listReceipts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    toolbar_button_listReceipts.setFocusable(false);
    toolbar_button_listReceipts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    toolbar_button_listReceipts.setMargin(new java.awt.Insets(2, 2, 2, 2));
    toolbar_button_listReceipts.setOpaque(false);
    toolbar_button_listReceipts.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    toolbar_button_listReceipts.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        toolbar_button_listReceiptsActionPerformed(evt);
      }
    });
    toolbar.add(toolbar_button_listReceipts);

    toolbar_button_deletedReceipts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trash.png"))); // NOI18N
    toolbar_button_deletedReceipts.setToolTipText("Διεγραμμένες αποδείξεις");
    toolbar_button_deletedReceipts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    toolbar_button_deletedReceipts.setFocusable(false);
    toolbar_button_deletedReceipts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    toolbar_button_deletedReceipts.setOpaque(false);
    toolbar_button_deletedReceipts.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    toolbar_button_deletedReceipts.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        toolbar_button_deletedReceiptsActionPerformed(evt);
      }
    });
    toolbar.add(toolbar_button_deletedReceipts);
    toolbar.add(jSeparator1);

    toolbar_button_addType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addShop.png"))); // NOI18N
    toolbar_button_addType.setToolTipText("Προσθήκη Καταστήματος");
    toolbar_button_addType.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    toolbar_button_addType.setFocusable(false);
    toolbar_button_addType.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    toolbar_button_addType.setMargin(new java.awt.Insets(2, 2, 2, 2));
    toolbar_button_addType.setOpaque(false);
    toolbar_button_addType.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    toolbar_button_addType.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        toolbar_button_addTypeActionPerformed(evt);
      }
    });
    toolbar.add(toolbar_button_addType);

    toolbar_button_typeList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shopList.png"))); // NOI18N
    toolbar_button_typeList.setToolTipText("Λίσρα Καταστημάτων");
    toolbar_button_typeList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    toolbar_button_typeList.setFocusable(false);
    toolbar_button_typeList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    toolbar_button_typeList.setMargin(new java.awt.Insets(2, 2, 2, 2));
    toolbar_button_typeList.setOpaque(false);
    toolbar_button_typeList.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    toolbar_button_typeList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        toolbar_button_typeListActionPerformed(evt);
      }
    });
    toolbar.add(toolbar_button_typeList);
    toolbar.add(jSeparator2);

    toolbar_button_addAfm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addAfm.png"))); // NOI18N
    toolbar_button_addAfm.setToolTipText("Προσθήκη Α.Φ.Μ.");
    toolbar_button_addAfm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    toolbar_button_addAfm.setFocusable(false);
    toolbar_button_addAfm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    toolbar_button_addAfm.setMargin(new java.awt.Insets(2, 2, 2, 2));
    toolbar_button_addAfm.setOpaque(false);
    toolbar_button_addAfm.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    toolbar_button_addAfm.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        toolbar_button_addAfmActionPerformed(evt);
      }
    });
    toolbar.add(toolbar_button_addAfm);

    toolbar_button_listAfm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/afmList.png"))); // NOI18N
    toolbar_button_listAfm.setToolTipText("Λίστα Α.Φ.Μ.");
    toolbar_button_listAfm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    toolbar_button_listAfm.setFocusable(false);
    toolbar_button_listAfm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    toolbar_button_listAfm.setMargin(new java.awt.Insets(2, 2, 2, 2));
    toolbar_button_listAfm.setOpaque(false);
    toolbar_button_listAfm.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    toolbar_button_listAfm.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        toolbar_button_listAfmActionPerformed(evt);
      }
    });
    toolbar.add(toolbar_button_listAfm);
    toolbar.add(jSeparator3);

    bt_calcTaxes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/euro.png"))); // NOI18N
    bt_calcTaxes.setToolTipText("Υπολογισμός φόρου");
    bt_calcTaxes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    bt_calcTaxes.setFocusable(false);
    bt_calcTaxes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    bt_calcTaxes.setOpaque(false);
    bt_calcTaxes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    bt_calcTaxes.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_calcTaxesActionPerformed(evt);
      }
    });
    toolbar.add(bt_calcTaxes);

    toolbal_button_settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings.png"))); // NOI18N
    toolbal_button_settings.setToolTipText("Ρυθμίσεις");
    toolbal_button_settings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    toolbal_button_settings.setFocusable(false);
    toolbal_button_settings.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    toolbal_button_settings.setOpaque(false);
    toolbal_button_settings.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    toolbal_button_settings.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        toolbal_button_settingsActionPerformed(evt);
      }
    });
    toolbar.add(toolbal_button_settings);

    toolbar_button_monthlyStats.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/monthlyStats.png"))); // NOI18N
    toolbar_button_monthlyStats.setToolTipText("Στατιστικά ανά μήνα");
    toolbar_button_monthlyStats.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    toolbar_button_monthlyStats.setFocusable(false);
    toolbar_button_monthlyStats.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    toolbar_button_monthlyStats.setOpaque(false);
    toolbar_button_monthlyStats.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    toolbar_button_monthlyStats.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        toolbar_button_monthlyStatsActionPerformed(evt);
      }
    });
    toolbar.add(toolbar_button_monthlyStats);

    toolbar_button_kindStats.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shopStats.png"))); // NOI18N
    toolbar_button_kindStats.setToolTipText("Στατιστικά ανά είδος");
    toolbar_button_kindStats.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    toolbar_button_kindStats.setFocusable(false);
    toolbar_button_kindStats.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    toolbar_button_kindStats.setOpaque(false);
    toolbar_button_kindStats.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    toolbar_button_kindStats.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        toolbar_button_kindStatsActionPerformed(evt);
      }
    });
    toolbar.add(toolbar_button_kindStats);
    toolbar.add(jSeparator4);

    button_excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/export_xls.png"))); // NOI18N
    button_excel.setToolTipText("Export to excel file");
    button_excel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    button_excel.setFocusable(false);
    button_excel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    button_excel.setOpaque(false);
    button_excel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    button_excel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_excelActionPerformed(evt);
      }
    });
    toolbar.add(button_excel);

    button_csv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/export_csv.png"))); // NOI18N
    button_csv.setToolTipText("Export to csv file");
    button_csv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    button_csv.setFocusable(false);
    button_csv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    button_csv.setOpaque(false);
    button_csv.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    button_csv.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_csvActionPerformed(evt);
      }
    });
    toolbar.add(button_csv);

    button_pdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/export_pdf.png"))); // NOI18N
    button_pdf.setToolTipText("Export to pdf file");
    button_pdf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    button_pdf.setFocusable(false);
    button_pdf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    button_pdf.setOpaque(false);
    button_pdf.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    button_pdf.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_pdfActionPerformed(evt);
      }
    });
    toolbar.add(button_pdf);

    getContentPane().add(toolbar, java.awt.BorderLayout.NORTH);

    panel_body.setMinimumSize(new java.awt.Dimension(800, 500));
    panel_body.setPreferredSize(new java.awt.Dimension(800, 500));

    splitPane.setDividerLocation(200);
    splitPane.setAlignmentY(2.0F);
    splitPane.setMaximumSize(new java.awt.Dimension(2000, 2000));
    splitPane.setMinimumSize(new java.awt.Dimension(600, 500));

    panel_leftTop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
    panel_leftTop.setMaximumSize(new java.awt.Dimension(400, 500));
    panel_leftTop.setMinimumSize(new java.awt.Dimension(200, 500));
    panel_leftTop.setPreferredSize(new java.awt.Dimension(200, 500));
    panel_leftTop.setLayout(new javax.swing.BoxLayout(panel_leftTop, javax.swing.BoxLayout.PAGE_AXIS));
    splitPane.setLeftComponent(panel_leftTop);

    panel_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
    panel_main.setMaximumSize(new java.awt.Dimension(2000, 2000));
    panel_main.setMinimumSize(new java.awt.Dimension(500, 500));
    panel_main.setLayout(new java.awt.BorderLayout());
    splitPane.setRightComponent(panel_main);

    javax.swing.GroupLayout panel_bodyLayout = new javax.swing.GroupLayout(panel_body);
    panel_body.setLayout(panel_bodyLayout);
    panel_bodyLayout.setHorizontalGroup(
      panel_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panel_bodyLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(splitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        .addContainerGap())
    );
    panel_bodyLayout.setVerticalGroup(
      panel_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panel_bodyLayout.createSequentialGroup()
        .addComponent(splitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
        .addContainerGap())
    );

    getContentPane().add(panel_body, java.awt.BorderLayout.CENTER);

    databases.setText("Βάσεις");

    menu_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/database.png"))); // NOI18N
    menu_edit.setText("Επεξεργασία...");

    menuItem_addDatabase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/database_save.png"))); // NOI18N
    menuItem_addDatabase.setText("Δημιουργία Βάσης");
    menuItem_addDatabase.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_addDatabaseActionPerformed(evt);
      }
    });
    menu_edit.add(menuItem_addDatabase);

    menuItem_loadDatabase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/load_database.png"))); // NOI18N
    menuItem_loadDatabase.setText("Επιλογή Βάσης");
    menuItem_loadDatabase.setToolTipText("Επιλογή άλλης  βάσης");
    menuItem_loadDatabase.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_loadDatabaseActionPerformed(evt);
      }
    });
    menu_edit.add(menuItem_loadDatabase);

    menuItem_deleteDatabase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/database_delete.png"))); // NOI18N
    menuItem_deleteDatabase.setText("Διαγραφή Βάσης");
    menuItem_deleteDatabase.setToolTipText("Διαγραφή Βάσης");
    menuItem_deleteDatabase.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_deleteDatabaseActionPerformed(evt);
      }
    });
    menu_edit.add(menuItem_deleteDatabase);

    menuItem_restoreBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/restore_backup.png"))); // NOI18N
    menuItem_restoreBackup.setText("Άνοιγμα backup βάσης");
    menuItem_restoreBackup.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_restoreBackupActionPerformed(evt);
      }
    });
    menu_edit.add(menuItem_restoreBackup);

    menuItem_renameDatabase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rename.png"))); // NOI18N
    menuItem_renameDatabase.setText("Μετονομασία βάσης");
    menuItem_renameDatabase.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_renameDatabaseActionPerformed(evt);
      }
    });
    menu_edit.add(menuItem_renameDatabase);

    databases.add(menu_edit);

    menu_importDatabase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/import_database.png"))); // NOI18N
    menu_importDatabase.setText("Εισαγωγή από ...");

    menuItem_importAscii.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ascii.png"))); // NOI18N
    menuItem_importAscii.setText("αρχείο ascii");
    menuItem_importAscii.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_importAsciiActionPerformed(evt);
      }
    });
    menu_importDatabase.add(menuItem_importAscii);

    menuItem_importXls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excel.png"))); // NOI18N
    menuItem_importXls.setText("αρχείο excel");
    menuItem_importXls.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_importXlsActionPerformed(evt);
      }
    });
    menu_importDatabase.add(menuItem_importXls);

    menuItem_importMdb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/access.png"))); // NOI18N
    menuItem_importMdb.setText("αρχείο access");
    menuItem_importMdb.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_importMdbActionPerformed(evt);
      }
    });
    menu_importDatabase.add(menuItem_importMdb);

    menuItem_importOds.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ods.png"))); // NOI18N
    menuItem_importOds.setText("αρχείο ods");
    menuItem_importOds.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_importOdsActionPerformed(evt);
      }
    });
    menu_importDatabase.add(menuItem_importOds);

    databases.add(menu_importDatabase);

    jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/export.png"))); // NOI18N
    jMenu1.setText("Εξαγωγή σε...");

    menuItem_excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/export_xls.png"))); // NOI18N
    menuItem_excel.setText("αρχείο excel");
    menuItem_excel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_excelActionPerformed(evt);
      }
    });
    jMenu1.add(menuItem_excel);

    menuItem_csv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/export_csv.png"))); // NOI18N
    menuItem_csv.setText("αρχείο ascii");
    menuItem_csv.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_csvActionPerformed(evt);
      }
    });
    jMenu1.add(menuItem_csv);

    menuItem_pdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/export_pdf.png"))); // NOI18N
    menuItem_pdf.setText("αρχείο pdf");
    menuItem_pdf.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_pdfActionPerformed(evt);
      }
    });
    jMenu1.add(menuItem_pdf);

    databases.add(jMenu1);

    menuItem_selectYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/year.png"))); // NOI18N
    menuItem_selectYear.setText("Επιλογή Έτους");
    menuItem_selectYear.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_selectYearActionPerformed(evt);
      }
    });
    databases.add(menuItem_selectYear);
    databases.add(jSeparator5);

    menuItem_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
    menuItem_exit.setText("Έξοδος");
    menuItem_exit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_exitActionPerformed(evt);
      }
    });
    databases.add(menuItem_exit);

    menuBar.add(databases);

    receipts.setText("Αποδείξεις");

    menuItem_addReceipt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addReceipts.png"))); // NOI18N
    menuItem_addReceipt.setText("Εισαγωγή");
    menuItem_addReceipt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_addReceiptActionPerformed(evt);
      }
    });
    receipts.add(menuItem_addReceipt);

    menuItem_receiptList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/receiptsList.png"))); // NOI18N
    menuItem_receiptList.setText("Λίστα Αποδείξεων");
    menuItem_receiptList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_receiptListActionPerformed(evt);
      }
    });
    receipts.add(menuItem_receiptList);

    menuItem_deletedReceipts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trash.png"))); // NOI18N
    menuItem_deletedReceipts.setText("Διεγραμμένες αποδείξεις");
    menuItem_deletedReceipts.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_deletedReceiptsActionPerformed(evt);
      }
    });
    receipts.add(menuItem_deletedReceipts);

    menuBar.add(receipts);

    types.setText("Βοηθητικά");

    menuItem_addType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addShop.png"))); // NOI18N
    menuItem_addType.setText("Προσθήκη Είδους");
    menuItem_addType.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_addTypeActionPerformed(evt);
      }
    });
    types.add(menuItem_addType);

    menuItem_editType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shopList.png"))); // NOI18N
    menuItem_editType.setText("Λίστα Ειδών");
    menuItem_editType.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_editTypeActionPerformed(evt);
      }
    });
    types.add(menuItem_editType);
    types.add(jSeparator6);

    menuItem_addAfm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addAfm.png"))); // NOI18N
    menuItem_addAfm.setText("Προσθήκη Α.Φ.Μ.");
    menuItem_addAfm.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_addAfmActionPerformed(evt);
      }
    });
    types.add(menuItem_addAfm);

    menuItem_editAfm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/afmList.png"))); // NOI18N
    menuItem_editAfm.setText("Λίστα Α.Φ.Μ.");
    menuItem_editAfm.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_editAfmActionPerformed(evt);
      }
    });
    types.add(menuItem_editAfm);

    menuItem_toolbar.setSelected(true);
    menuItem_toolbar.setText("Εμφανιση γραμμής εργαλείων");
    menuItem_toolbar.setToolTipText("Εμφανιση γραμμής εργαλείων");
    menuItem_toolbar.setMinimumSize(new java.awt.Dimension(22, 22));
    menuItem_toolbar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_toolbarActionPerformed(evt);
      }
    });
    types.add(menuItem_toolbar);

    menuBar.add(types);

    stats.setText("Εργαλεία");

    menuItem_calcTaxes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/euro.png"))); // NOI18N
    menuItem_calcTaxes.setText("Υπολογισμός φόρου");
    menuItem_calcTaxes.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_calcTaxesActionPerformed(evt);
      }
    });
    stats.add(menuItem_calcTaxes);
    stats.add(jSeparator8);

    menuItem_monthlyStats.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/monthlyStats.png"))); // NOI18N
    menuItem_monthlyStats.setText("Στατιστικά ανά μήνα");
    menuItem_monthlyStats.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_monthlyStatsActionPerformed(evt);
      }
    });
    stats.add(menuItem_monthlyStats);

    menuItem_kindStats.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shopStats.png"))); // NOI18N
    menuItem_kindStats.setText("Στατιστικά ανά είδος");
    menuItem_kindStats.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_kindStatsActionPerformed(evt);
      }
    });
    stats.add(menuItem_kindStats);
    stats.add(jSeparator7);

    menuItem_options.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings.png"))); // NOI18N
    menuItem_options.setText("Ρυθμίσεις");
    menuItem_options.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_optionsActionPerformed(evt);
      }
    });
    stats.add(menuItem_options);

    menuBar.add(stats);

    help.setText("Βοήθεια");
    help.setToolTipText("Βοήθεια");

    menuItem_help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help.png"))); // NOI18N
    menuItem_help.setText("Βοήθεια");
    menuItem_help.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_helpActionPerformed(evt);
      }
    });
    help.add(menuItem_help);

    menuItem_website.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/website.png"))); // NOI18N
    menuItem_website.setText("Ιστοσελίδα");
    menuItem_website.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_websiteActionPerformed(evt);
      }
    });
    help.add(menuItem_website);

    menuItem_contact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/contact.png"))); // NOI18N
    menuItem_contact.setText("Επικοινωνία");
    menuItem_contact.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_contactActionPerformed(evt);
      }
    });
    help.add(menuItem_contact);
    help.add(jSeparator11);

    menuItem_info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info_small.png"))); // NOI18N
    menuItem_info.setText("Πληροφορίες");
    menuItem_info.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_infoActionPerformed(evt);
      }
    });
    help.add(menuItem_info);

    MenuItem_checkUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
    MenuItem_checkUpdate.setText("Έλεγχος νέας έκδοσης");
    MenuItem_checkUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        MenuItem_checkUpdateActionPerformed(evt);
      }
    });
    help.add(MenuItem_checkUpdate);

    menuItem_logFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/log.png"))); // NOI18N
    menuItem_logFile.setText("Αρχείο γεγονότων");
    menuItem_logFile.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItem_logFileActionPerformed(evt);
      }
    });
    help.add(menuItem_logFile);

    menuBar.add(help);

    setJMenuBar(menuBar);

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void menuItem_addReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_addReceiptActionPerformed
      glassPane.activate(null);
      AddReceipt a = new AddReceipt();
      if (!a.cancel) {
        int type_id = a.type_id;
        if (a.type_id == 0) {
          try {
            Type type = new Type(0, a.type, 1, a.multiplier);
            if (!type.exists()) {
              type.save();
              type_id = Type.getIdByField(Type.TABLE, Type.COLUMN_DESCRIPTION, Type.COLUMN_TYPE_ID, a.type);
            } else {
              type_id = type.getType_id();
            }
          } catch (SQLException ex) {
            Helper.message(ErrorMessages.SQL_EXCEPTION, "SQL Σφάλμα", JOptionPane.ERROR_MESSAGE);
            log(Level.SEVERE, ErrorMessages.SQL_EXCEPTION, ex);
          }
        }
        try {
          Receipt r = new Receipt(0, a.afm, Double.parseDouble(a.amount), Helper.convertStringToDate(a.date), type_id, a.comments, true);
          r.save();
          updateReceiptPanel();
          updateTotalsPanel();
          //Open window again
          menuItem_addReceiptActionPerformed(evt);
        } catch (SQLException ex) {
          Helper.message(ErrorMessages.SQL_EXCEPTION, "SQL Σφάλμα", JOptionPane.ERROR_MESSAGE);
          Main.log(Level.SEVERE, ErrorMessages.SQL_EXCEPTION, ex);
        } catch (NumberFormatException ex) {
          Helper.message("Λάθος φορμάτ ποσού", ErrorMessages.AMOUNT_FORMAT, JOptionPane.ERROR_MESSAGE);
        }
      }
    }//GEN-LAST:event_menuItem_addReceiptActionPerformed

    private void menuItem_addTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_addTypeActionPerformed
      glassPane.activate(null);
      String[] fieldNames = {"Είδος", "Ποσοστό απαλλαγής"};
      SValidator[] validators = {new RequiredValidator(), new PositiveNumberValidator("", false, false)};
      InputField addType = new InputField("Εισαγωγή Είδους", fieldNames, validators);
      if (!addType.cancel) {
        Double d = Double.parseDouble(addType.fields[1].getText());
        Type type = new Type(0, addType.fields[0].getText().trim(), 1, d / 100);
        try {
          type.save();
          updateTypesPanel();
        } catch (SQLException ex) {
          Helper.message(ErrorMessages.SQL_EXCEPTION, "SQL Σφάλμα", JOptionPane.ERROR_MESSAGE);
          log(Level.SEVERE, ErrorMessages.SQL_EXCEPTION, ex);
        }
      }
    }//GEN-LAST:event_menuItem_addTypeActionPerformed

    private void menuItem_editTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_editTypeActionPerformed
      updateTypesPanel();
    }//GEN-LAST:event_menuItem_editTypeActionPerformed

  public void updateTypesPanel() {
    TypesTablePanel tPanel = new TypesTablePanel(this);
    panel_main.removeAll();
    panel_main.add(tPanel);
    panel_main.validate();
  }

    private void menuItem_addAfmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_addAfmActionPerformed
      glassPane.activate(null);
      String[] fieldNames = {"Α.Φ.Μ.", "Εταιρεία"};
      SValidator[] validators = {new PositiveNumberValidator("", false, false),
        new RequiredValidator(Main.tmpCompany)};
      InputField addAfm = new InputField("Εισαγωγή Α.Φ.Μ.", fieldNames, validators);
      if (!addAfm.cancel) {
        try {
          if (Helper.isValidAfm(addAfm.fields[0].getText())) {
            Afm afm = new Afm(0, addAfm.fields[0].getText(), addAfm.fields[1].getText());
            afm.save();
            updateAfmPanel();
            Main.tmpCompany = "";
          } else {
            Helper.message("Ο Α.Φ.Μ. δεν είναι σωστός", "Εΐσαγωγή νέου Α.Φ.Μ", JOptionPane.ERROR_MESSAGE);
            Main.tmpCompany = addAfm.fields[1].getText();
            menuItem_addAfmActionPerformed(evt);

          }
        } catch (SQLException ex) {
          Helper.message(ErrorMessages.SQL_EXCEPTION, "SQL Σφάλμα", JOptionPane.ERROR_MESSAGE);
          log(Level.SEVERE, ErrorMessages.SQL_EXCEPTION, ex);
        }
      } else {
        Main.tmpCompany = "";
      }
    }//GEN-LAST:event_menuItem_addAfmActionPerformed

    private void menuItem_editAfmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_editAfmActionPerformed
      updateAfmPanel();
    }//GEN-LAST:event_menuItem_editAfmActionPerformed

    private void menuItem_receiptListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_receiptListActionPerformed
      updateReceiptPanel();
    }//GEN-LAST:event_menuItem_receiptListActionPerformed

    private void toolbar_button_addReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_button_addReceiptActionPerformed
      menuItem_addReceiptActionPerformed(evt);
    }//GEN-LAST:event_toolbar_button_addReceiptActionPerformed

    private void toolbar_button_listReceiptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_button_listReceiptsActionPerformed
      menuItem_receiptListActionPerformed(evt);
    }//GEN-LAST:event_toolbar_button_listReceiptsActionPerformed

    private void toolbar_button_addTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_button_addTypeActionPerformed
      menuItem_addTypeActionPerformed(evt);
    }//GEN-LAST:event_toolbar_button_addTypeActionPerformed

    private void toolbar_button_typeListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_button_typeListActionPerformed
      menuItem_editTypeActionPerformed(evt);
    }//GEN-LAST:event_toolbar_button_typeListActionPerformed

    private void toolbar_button_addAfmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_button_addAfmActionPerformed
      menuItem_addAfmActionPerformed(evt);
    }//GEN-LAST:event_toolbar_button_addAfmActionPerformed

    private void toolbar_button_listAfmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_button_listAfmActionPerformed
      menuItem_editAfmActionPerformed(evt);
    }//GEN-LAST:event_toolbar_button_listAfmActionPerformed

    private void menuItem_monthlyStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_monthlyStatsActionPerformed
      updateMonthlyPanel();
    }//GEN-LAST:event_menuItem_monthlyStatsActionPerformed

    private void toolbar_button_monthlyStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_button_monthlyStatsActionPerformed
      updateMonthlyPanel();
    }//GEN-LAST:event_toolbar_button_monthlyStatsActionPerformed

    private void menuItem_kindStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_kindStatsActionPerformed
      updateKindPanel();
    }//GEN-LAST:event_menuItem_kindStatsActionPerformed

    private void toolbar_button_kindStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_button_kindStatsActionPerformed
      updateKindPanel();
    }//GEN-LAST:event_toolbar_button_kindStatsActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//      try {
//        backUpDb();
//      } catch (FileNotFoundException ex) {
//        logger.log(Level.SEVERE, ErrorMessages.DB_FILE_NOT_FOUND, ex);
//      } catch (IOException ex) {
//        logger.log(Level.SEVERE, ErrorMessages.DB_IO_ERROR, ex);
//      }
    }//GEN-LAST:event_formWindowClosing

    private void menuItem_csvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_csvActionPerformed
      CsvExport exp = new CsvExport();
      exp.setFile();
    }//GEN-LAST:event_menuItem_csvActionPerformed

    private void menuItem_excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_excelActionPerformed
      ExcelExport exp = new ExcelExport();
      exp.setFile();
    }//GEN-LAST:event_menuItem_excelActionPerformed

    private void menuItem_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_pdfActionPerformed
      logger.log(Level.INFO, "Starting pdf export");
      PdfExport exp = new PdfExport();
      Main.logger.log(Level.INFO, "Setting the export file");
      exp.setFile();
    }//GEN-LAST:event_menuItem_pdfActionPerformed

    private void button_excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_excelActionPerformed
      menuItem_excelActionPerformed(evt);
    }//GEN-LAST:event_button_excelActionPerformed

    private void button_csvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_csvActionPerformed
      menuItem_csvActionPerformed(evt);
    }//GEN-LAST:event_button_csvActionPerformed

    private void button_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_pdfActionPerformed
      menuItem_pdfActionPerformed(evt);
    }//GEN-LAST:event_button_pdfActionPerformed

    private void menuItem_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_exitActionPerformed
      System.exit(0);
    }//GEN-LAST:event_menuItem_exitActionPerformed

    private void menuItem_toolbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_toolbarActionPerformed
      toolbar.setVisible(menuItem_toolbar.isSelected());
    }//GEN-LAST:event_menuItem_toolbarActionPerformed

    private void menuItem_loadDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_loadDatabaseActionPerformed
      if (Database.getDatabases().length > 1) {
        Database.createConnection(true);
        setAppTitle();
        updateReceiptPanel();
        updateTotalsPanel();
      } else {
        Helper.message(ErrorMessages.ONLY_ONE_DB,
            "Επιλογή βάσης", JOptionPane.INFORMATION_MESSAGE);
      }
    }//GEN-LAST:event_menuItem_loadDatabaseActionPerformed

    private void toolbar_button_addDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_button_addDatabaseActionPerformed
      menuItem_addDatabaseActionPerformed(evt);
    }//GEN-LAST:event_toolbar_button_addDatabaseActionPerformed

    private void toolbar_button_loadDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_button_loadDatabaseActionPerformed
      menuItem_loadDatabaseActionPerformed(evt);
    }//GEN-LAST:event_toolbar_button_loadDatabaseActionPerformed

    private void menuItem_selectYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_selectYearActionPerformed
      try {
        ArrayList<String> years = new ArrayList<String>();
        ResultSet rs = Database.stmt.executeQuery("SELECT DISTINCT  strftime('%Y', " + Receipt.COLUMN_BUY_DATE + ")"
            + " AS year FROM " + Receipt.TABLE);
        while (rs.next()) {
          years.add(rs.getString("year"));
        }
        if (!years.isEmpty()) {
          if (years.size() == 1) {
            Helper.message("Υπάρχει μόνο ένα έτος στην βάση", "Επιλογή έτους", JOptionPane.INFORMATION_MESSAGE);
            Options.YEAR = years.get(0);
          } else {
            String year = Helper.ask("Επιλογή Έτους", "Επιλέξτε το έτος που θέλετε", years.toArray());
            Options.YEAR = year;
          }
          setAppTitle();
          updateReceiptPanel();
          updateTotalsPanel();
        } else {
          Helper.message(ErrorMessages.EMPTY_DATABASE, "Επιλογή έτους", JOptionPane.ERROR_MESSAGE);
        }
      } catch (SQLException ex) {
        log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_menuItem_selectYearActionPerformed

    private void toolbar_button_selectYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_button_selectYearActionPerformed
      menuItem_selectYearActionPerformed(evt);
    }//GEN-LAST:event_toolbar_button_selectYearActionPerformed

    private void menuItem_deleteDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_deleteDatabaseActionPerformed
      String[] dbs = Database.getDatabases();
      if (dbs.length < 2) {
        Helper.message(ErrorMessages.NO_DB_TO_DELETE, "Διαγραφή βάσης", JOptionPane.ERROR_MESSAGE);
        return;
      }
      String db = Helper.ask("Διαγραφή Βάσης", "Επιλέξτε τη βάση που θέλετε να διαγράψετε", dbs);
      db = db.replaceAll(".db$", "");
      if (!db.equals("")) {
        if (db.equals(Options.toString(Options.DATABASE))) {
          Helper.message(ErrorMessages.DELETE_ACTIVE_DB, "Διαγραφή βάσης", JOptionPane.ERROR_MESSAGE);
          return;
        }
        deleteDb(db);
      }

    }//GEN-LAST:event_menuItem_deleteDatabaseActionPerformed

    private void toolbar_button_deleteDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_button_deleteDatabaseActionPerformed
      menuItem_deleteDatabaseActionPerformed(evt);
    }//GEN-LAST:event_toolbar_button_deleteDatabaseActionPerformed

    private void menuItem_importAsciiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_importAsciiActionPerformed
      ImportAscii imAscii = new ImportAscii();
      imAscii.start();
      setAppTitle();
    }//GEN-LAST:event_menuItem_importAsciiActionPerformed

    private void menuItem_addDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_addDatabaseActionPerformed
      try {
        int res = Database.createDb();
        if (res == Database.OK) {
          Helper.message("Η βάση δημιουργήθηκε", "Δημιουργία Βάσης", JOptionPane.INFORMATION_MESSAGE);
          setAppTitle();
          updateReceiptPanel();
          updateTotalsPanel();
        } else if (res == Database.ERROR) {
          Helper.message(ErrorMessages.CREATE_DB_ERROR, "Δημιουργία βάσης", JOptionPane.ERROR_MESSAGE);
        } else {
          Helper.message(ErrorMessages.CANCEL_DATABASE, "Δημιουργία βάσης", JOptionPane.ERROR_MESSAGE);
        }
      } catch (ClassNotFoundException ex) {
        Helper.message(ErrorMessages.CREATE_DB_ERROR, "Δημιουργία βάσης", JOptionPane.ERROR_MESSAGE);
        log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_menuItem_addDatabaseActionPerformed

    private void menuItem_importXlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_importXlsActionPerformed
      ImportXls imXls = new ImportXls();
      imXls.start();
      setAppTitle();
    }//GEN-LAST:event_menuItem_importXlsActionPerformed

    private void menuItem_importMdbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_importMdbActionPerformed
      ImportMdb imMdb = new ImportMdb();
      imMdb.start();
      setAppTitle();
    }//GEN-LAST:event_menuItem_importMdbActionPerformed

    private void menuItem_importOdsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_importOdsActionPerformed
      ImportOds imOds = new ImportOds();
      imOds.start();
      setAppTitle();
    }//GEN-LAST:event_menuItem_importOdsActionPerformed

    private void toolbar_button_restoreBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_button_restoreBackupActionPerformed
      menuItem_restoreBackupActionPerformed(evt);
    }//GEN-LAST:event_toolbar_button_restoreBackupActionPerformed

    private void menuItem_restoreBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_restoreBackupActionPerformed
      String[] dbs = Database.getBackUpDatabases();
      String dbName = Helper.ask("Άνοιγμα backup βάσης", "Επιλέξτε την βάση που θέλετε να ανοίξετε", dbs);
      if (!dbName.equals("")) {
        String newDb = dbName.replaceAll(".bak", ".db");
        File source = new File(Options.USER_DIR + Options.BACKUP_PATH + dbName);
        File target = new File(Options.USER_DIR + Options.DB_PATH + newDb);
        if (target.exists()) {
          if (Helper.confirm("Επαναφορά βάσης", "Αν επαναφέρετε το backup η αρχική βάση θα διαγραφεί\n"
              + "Είστε σίγουροι;") != JOptionPane.YES_OPTION) {
            return;
          }
        }
        if (Helper.copyFile(source, target)) {
          //source.delete();
          Database.connectToDb(newDb.replaceAll(".db", ""));
          setAppTitle();
          updateReceiptPanel();
          updateTotalsPanel();
          Helper.message("Η βάση δημιουργήθηκε", "Δημιουργία βάσης από backup", JOptionPane.INFORMATION_MESSAGE);
        } else {
          Helper.message(ErrorMessages.CREATE_DB_ERROR, "Δημιουργία βάσης από backup", JOptionPane.ERROR_MESSAGE);
        }
      }
    }//GEN-LAST:event_menuItem_restoreBackupActionPerformed

    private void menuItem_calcTaxesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_calcTaxesActionPerformed
      EarnForm ef = new EarnForm();
      if (!ef.cancel) {
        CalcTaxes ct = new CalcTaxes(ef.owner, ef.married);
      }
    }//GEN-LAST:event_menuItem_calcTaxesActionPerformed

    private void bt_calcTaxesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_calcTaxesActionPerformed
      menuItem_calcTaxesActionPerformed(evt);
    }//GEN-LAST:event_bt_calcTaxesActionPerformed

    private void menuItem_helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_helpActionPerformed
      File helpHtml = new File(Options.DOCS_PATH + "index.html");
      try {
        boolean browse = Helper.browse(helpHtml.toURI());
      } catch (UnsupportedOperationException ex) {
        Helper.message("Το λειτουργικό σύστημα που χρησιμοποιείτε δεν επιτρέπει "
            + "το άνοιγμα αρχείων\n"
            + "Για να δείτε την βοήθεια ανοίξτε τον υποφάκελλο "
            + "/docs/ και το αρχείο index.html", "Βοήθεια", JOptionPane.WARNING_MESSAGE);
        Main.log(Level.WARNING, ex.getMessage(), ex);
      } catch (IOException ex) {
        Helper.message(ex.getMessage(), "Βοήθεια", JOptionPane.WARNING_MESSAGE);
        Main.log(Level.WARNING, ex.getMessage(), ex);
      }
    }//GEN-LAST:event_menuItem_helpActionPerformed

    private void menuItem_websiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_websiteActionPerformed
      try {
        URI uri = new URI(Options.WEBSITE);
        try {
          Helper.browse(uri);
        } catch (UnsupportedOperationException ex) {
          Main.log(Level.WARNING, ex.getMessage(), ex);
        } catch (IOException ex) {
          Main.log(Level.WARNING, ex.getMessage(), ex);
        }
      } catch (URISyntaxException ex) {
        Main.log(Level.WARNING, ex.getMessage(), ex);
      }
    }//GEN-LAST:event_menuItem_websiteActionPerformed

    private void menuItem_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_infoActionPerformed
      new About();
    }//GEN-LAST:event_menuItem_infoActionPerformed

    private void menuItem_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_contactActionPerformed
      try {
        String subject = ("?subject=" + TITLE + " " + version).replaceAll("\\s", "%20");
        URI email = new URI("mailto:" + Options.EMAIL + subject);
        Helper.mail(email);
      } catch (IOException ex) {
        log(Level.SEVERE, null, ex);
      } catch (URISyntaxException ex) {
        log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_menuItem_contactActionPerformed

    private void MenuItem_checkUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItem_checkUpdateActionPerformed
      CheckUpdate cu = new CheckUpdate(false);
    }//GEN-LAST:event_MenuItem_checkUpdateActionPerformed

    private void menuItem_optionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_optionsActionPerformed
      OptionsForm op = new OptionsForm(this);
    }//GEN-LAST:event_menuItem_optionsActionPerformed

    private void toolbal_button_settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbal_button_settingsActionPerformed
      menuItem_optionsActionPerformed(evt);
    }//GEN-LAST:event_toolbal_button_settingsActionPerformed

    private void toolbar_button_deletedReceiptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_button_deletedReceiptsActionPerformed
      menuItem_deletedReceiptsActionPerformed(evt);
    }//GEN-LAST:event_toolbar_button_deletedReceiptsActionPerformed

    private void menuItem_deletedReceiptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_deletedReceiptsActionPerformed
      updateDeletedReceiptsPanel();
    }//GEN-LAST:event_menuItem_deletedReceiptsActionPerformed

    private void menuItem_renameDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_renameDatabaseActionPerformed
      renameDatabase();
    }//GEN-LAST:event_menuItem_renameDatabaseActionPerformed

    private void toolbal_button_renameDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbal_button_renameDatabaseActionPerformed
      menuItem_renameDatabaseActionPerformed(evt);
    }//GEN-LAST:event_toolbal_button_renameDatabaseActionPerformed

    private void menuItem_logFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_logFileActionPerformed
      String path = "";
      try {
        path = new File(Options.USER_DIR).getCanonicalPath();
      } catch (IOException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      }
      File log = new File(path + "/" + Options.LOG_PATH + "Receipts.html");
      Helper.openFile(log);
    }//GEN-LAST:event_menuItem_logFileActionPerformed

  public void updateDeletedReceiptsPanel() {
    ReceiptsTablePanel a = new ReceiptsTablePanel(this, false);
    panel_main.removeAll();
    panel_main.add(a);
    panel_main.validate();
  }

  public void updateKindPanel() {
    KindTablePanel aPanel = new KindTablePanel(this);
    panel_main.removeAll();
    panel_main.add(aPanel);
    panel_main.validate();
  }

  public void updateMonthlyPanel() {
    MonthlyTablePanel aPanel = new MonthlyTablePanel(this);
    panel_main.removeAll();
    panel_main.add(aPanel);
    panel_main.validate();
  }

  public void updateAfmPanel() {
    AfmsTablePanel aPanel = new AfmsTablePanel(this);
    panel_main.removeAll();
    panel_main.add(aPanel);
    panel_main.validate();
  }

  public void updateReceiptPanel() {
    _updateReceiptPanel();
  }

  private void _updateReceiptPanel() {
    ReceiptsTablePanel a = new ReceiptsTablePanel(this, true);
    panel_main.removeAll();
    panel_main.add(a);
    panel_main.validate();
  }

  public void updateTotalsPanel() {
    _updateTotalsPanel();
  }

  private void _updateTotalsPanel() {
    totalsPanel a = new totalsPanel();
    panel_leftTop.removeAll();
    panel_leftTop.add(a);
    panel_leftTop.validate();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        try {
          new Main();
        } catch (FileNotFoundException ex) {
          log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
          log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
          log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
          log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
          log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
          log(Level.SEVERE, null, ex);
        }
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenuItem MenuItem_checkUpdate;
  private javax.swing.JButton bt_calcTaxes;
  private javax.swing.JButton button_csv;
  private javax.swing.JButton button_excel;
  private javax.swing.JButton button_pdf;
  private javax.swing.JMenu databases;
  private javax.swing.JMenu help;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JToolBar.Separator jSeparator1;
  private javax.swing.JPopupMenu.Separator jSeparator11;
  private javax.swing.JToolBar.Separator jSeparator2;
  private javax.swing.JToolBar.Separator jSeparator3;
  private javax.swing.JToolBar.Separator jSeparator4;
  private javax.swing.JPopupMenu.Separator jSeparator5;
  private javax.swing.JSeparator jSeparator6;
  private javax.swing.JSeparator jSeparator7;
  private javax.swing.JPopupMenu.Separator jSeparator8;
  private javax.swing.JToolBar.Separator jSeparator9;
  private javax.swing.JMenuBar menuBar;
  private javax.swing.JMenuItem menuItem_addAfm;
  private javax.swing.JMenuItem menuItem_addDatabase;
  private javax.swing.JMenuItem menuItem_addReceipt;
  private javax.swing.JMenuItem menuItem_addType;
  private javax.swing.JMenuItem menuItem_calcTaxes;
  private javax.swing.JMenuItem menuItem_contact;
  private javax.swing.JMenuItem menuItem_csv;
  private javax.swing.JMenuItem menuItem_deleteDatabase;
  private javax.swing.JMenuItem menuItem_deletedReceipts;
  private javax.swing.JMenuItem menuItem_editAfm;
  private javax.swing.JMenuItem menuItem_editType;
  private javax.swing.JMenuItem menuItem_excel;
  private javax.swing.JMenuItem menuItem_exit;
  private javax.swing.JMenuItem menuItem_help;
  private javax.swing.JMenuItem menuItem_importAscii;
  private javax.swing.JMenuItem menuItem_importMdb;
  private javax.swing.JMenuItem menuItem_importOds;
  private javax.swing.JMenuItem menuItem_importXls;
  private javax.swing.JMenuItem menuItem_info;
  private javax.swing.JMenuItem menuItem_kindStats;
  private javax.swing.JMenuItem menuItem_loadDatabase;
  private javax.swing.JMenuItem menuItem_logFile;
  private javax.swing.JMenuItem menuItem_monthlyStats;
  private javax.swing.JMenuItem menuItem_options;
  private javax.swing.JMenuItem menuItem_pdf;
  private javax.swing.JMenuItem menuItem_receiptList;
  private javax.swing.JMenuItem menuItem_renameDatabase;
  private javax.swing.JMenuItem menuItem_restoreBackup;
  private javax.swing.JMenuItem menuItem_selectYear;
  private javax.swing.JCheckBoxMenuItem menuItem_toolbar;
  private javax.swing.JMenuItem menuItem_website;
  private javax.swing.JMenu menu_edit;
  private javax.swing.JMenu menu_importDatabase;
  private javax.swing.JPanel panel_body;
  private javax.swing.JPanel panel_leftTop;
  public javax.swing.JPanel panel_main;
  private javax.swing.JMenu receipts;
  private javax.swing.JSplitPane splitPane;
  private javax.swing.JMenu stats;
  private javax.swing.JButton toolbal_button_renameDatabase;
  private javax.swing.JButton toolbal_button_settings;
  private javax.swing.JToolBar toolbar;
  private javax.swing.JButton toolbar_button_addAfm;
  private javax.swing.JButton toolbar_button_addDatabase;
  private javax.swing.JButton toolbar_button_addReceipt;
  private javax.swing.JButton toolbar_button_addType;
  private javax.swing.JButton toolbar_button_deleteDatabase;
  private javax.swing.JButton toolbar_button_deletedReceipts;
  private javax.swing.JButton toolbar_button_kindStats;
  private javax.swing.JButton toolbar_button_listAfm;
  private javax.swing.JButton toolbar_button_listReceipts;
  private javax.swing.JButton toolbar_button_loadDatabase;
  private javax.swing.JButton toolbar_button_monthlyStats;
  private javax.swing.JButton toolbar_button_restoreBackup;
  private javax.swing.JButton toolbar_button_selectYear;
  private javax.swing.JButton toolbar_button_typeList;
  private javax.swing.JMenu types;
  // End of variables declaration//GEN-END:variables

  private void backUpDb() throws FileNotFoundException, IOException {
    backUpDb(Options.toString(Options.DATABASE));
  }

  private void backUpDb(String db) throws FileNotFoundException, IOException {
    log(Level.INFO, "Δημιουργία backup βάσης", null);
    File sourceFile = new File(Options.USER_DIR + "/" + Options.DB_PATH + "/" + db + ".db");
    if (sourceFile.isFile()) {
      File targetFile = new File(Options.USER_DIR + "/" + Options.BACKUP_PATH + "/" + Options.toString(Options.DATABASE) + ".bak");
      if (Helper.copyFile(sourceFile, targetFile)) {
        log(Level.FINE, "Το backup της βάσης δημιουργήθηκε", null);
      } else {
        log(Level.WARNING, ErrorMessages.CREATE_DB_BACKUP_ERROR, null);
      }
    }
  }

  private void createDirs() {
    new File(Options.USER_DIR + "/" + Options.LOG_PATH).mkdir();
    new File(Options.USER_DIR + "/" + Options.LAFS_PATH).mkdir();
    new File(Options.USER_DIR + "/" + Options.DB_PATH).mkdir();
    new File(Options.USER_DIR + "/" + Options.BACKUP_PATH).mkdir();
    try {
      //move backup files
      moveBackupFiles();
    } catch (IOException ex) {
      // log(Level.SEVERE, null, ex);
    }
    new File(Options.USER_DIR + "/" + Options.EXPORTS_PATH).mkdir();
    new File(Options.USER_DIR + "/" + Options.DOCS_PATH).mkdir();
    new File(Options.USER_DIR + "/" + Options.FONTS_PATH).mkdir();
  }

  private void moveBackupFiles() throws IOException {
    File dbpath = new File(Options.USER_DIR + "/" + Options.DB_PATH);
    File bu = new File(Options.USER_DIR + "/" + Options.BACKUP_PATH);
    File[] files = dbpath.listFiles(new FilenameFilter() {

      public boolean accept(File dir, String name) {
        if (name.endsWith(".bak")) {
          return true;
        }
        return false;
      }
    });
    for (int i = 0; i < files.length; i++) {
      File source = files[i];
      File target = new File(bu.getCanonicalPath() + source.getName());
      if (Helper.copyFile(source, target)) {
        source.delete();
        log(Level.INFO, "Το αρχείο " + source + " μεταφέρθηκε στον backup φάκελο", null);
      }
    }
  }

  private boolean deleteDb(String db) {
    try {
      log(Level.INFO, "Διαγραφή βάσης", null);
      backUpDb(db);
      Helper.message("Ένα αντίγραφο της βάσης δημιουργήθηκε:\n" + new File(Options.USER_DIR).getCanonicalPath() + "/" + Options.BACKUP_PATH + db + ".bak", "Διαγραφή βάσης", JOptionPane.INFORMATION_MESSAGE);
      if (new File(Options.USER_DIR + "/" + Options.DB_PATH + "/" + db + ".db").delete()) {
        log(Level.FINE, "Η βαση διεγράφη", null);
        Helper.message("Η βάση διεγράφη", "Διαγραφή βάσης", JOptionPane.INFORMATION_MESSAGE);
        return true;
      } else {
        return false;
      }
    } catch (FileNotFoundException ex) {
      logger.log(Level.SEVERE, ErrorMessages.DB_FILE_NOT_FOUND, ex);
      Helper.message(ErrorMessages.DB_FILE_NOT_FOUND, "Διαγραφή βάσης", JOptionPane.INFORMATION_MESSAGE);
      return false;
    } catch (IOException ex) {
      logger.log(Level.SEVERE, ErrorMessages.DB_IO_ERROR, ex);
      Helper.message(ErrorMessages.DB_IO_ERROR, "Διαγραφή βάσης", JOptionPane.INFORMATION_MESSAGE);
      return false;
    }
  }

  private void setAppTitle() {
    setTitle("Receipts " + version + " - Βάση: " + Options.toString(Options.DATABASE) + " - Έτος: " + Options.YEAR);
  }

  private void setYear() {
    try {
      ArrayList<String> years = new ArrayList<String>();
      ResultSet rs = Database.stmt.executeQuery("SELECT DISTINCT  strftime('%Y', " + Receipt.COLUMN_BUY_DATE + ") AS year FROM " + Receipt.TABLE + " ORDER BY year DESC LIMIT 1");
      while (rs.next()) {
        Options.YEAR = rs.getString("year");
      }
    } catch (SQLException ex) {
      log(Level.WARNING, ErrorMessages.SQL_EXCEPTION, ex);
    }

  }

  private void renameDatabase() {
    String[] dbs = Database.getDatabases();
    String oldName = Helper.ask("Μετονομασία βάσης", "Διαλέξτε τη βάση που θέλετε να μετονομάσετε", dbs);
    if (oldName.equals(Options.toString(Options.DATABASE) + ".db")) {
      Helper.message("Δεν μπορείτε να μετονομάσετε την βάση που χρησιμοποιείτε", "Μετονομασία βάσης", JOptionPane.ERROR_MESSAGE);
      return;
    }
    if (oldName.equals("")) {
      Helper.message(ErrorMessages.CANCEL_RENAME, "Μετονομασία βάσης", JOptionPane.ERROR_MESSAGE);
      return;
    }
    String newName = Helper.ask("Μετονομασία βάσης", "Δώστε το νέο όνομα");
    if (newName.equals("")) {
      Helper.message(ErrorMessages.CANCEL_RENAME, "Μετονομασία βάσης", JOptionPane.ERROR_MESSAGE);
      return;
    }
    newName = newName.endsWith(".db") ? newName : newName + ".db";
    if (oldName.toLowerCase().equals(newName.toLowerCase())) {
      Helper.message("Το παλιό και το νέο όνομα είναι ίδια", "Μετονομασία βάσης", JOptionPane.ERROR_MESSAGE);
      return;
    }
    if (Helper.isInArray(dbs, newName)) {
      Helper.message("Η βάση υπάρχει ήδη, δεν μπορεί να γίνει μετονομασία", "Μετονομασία βάσης", JOptionPane.ERROR_MESSAGE);
      //if (Helper.confirm("Μετονομασία βάσης", "Η βάση υπάρχει.Θέλετε να γίνει οverwrite;") != JOptionPane.OK_OPTION) {
      return;
      //}
    }
    File oldFile = new File(Options.USER_DIR + Options.DB_PATH + oldName);
    File newFile = new File(Options.USER_DIR + Options.DB_PATH + newName);
    if (oldFile.renameTo(newFile)) {
      Helper.message("Η μετονομασία έγινε", "Μετονομασία βάσης", JOptionPane.INFORMATION_MESSAGE);
    } else {
      Helper.message("Κάποιο σφάλμα προέκυψε στην μετονομασία", "Μετονομασία βάσης", JOptionPane.ERROR_MESSAGE);
    }
  }
}

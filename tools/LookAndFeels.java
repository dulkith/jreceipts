/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import receipts.Main;
import tools.options.Options;

/**
 * Looks and Feels
 * @author lordovol
 */
public class LookAndFeels {

  public static Map<String, LookAndFeelInfo> lafMap = new HashMap<String, LookAndFeelInfo>();

  public static void setInstalledLookAndFeels() {
    UIManager.setInstalledLookAndFeels(LookAndFeels.getLookAndFeels());
  }

  public static String getRandomLaf() {
    int lafs = lafMap.size();
    Random r = new Random();
    int random = r.nextInt(lafs-1);
    Set<String> keys = lafMap.keySet();
    int i =0;
    for (Iterator<String> it = keys.iterator(); it.hasNext();) {
      String key = it.next();
      if(i==random){
        Main.logger.log(Level.INFO, "Got random laf {0}",key);
        return key;
      }
      i++;
    }
    Main.logger.log(Level.WARNING, "Could not get a random laf");
    return "";
  }

  public LookAndFeels() {
    getDefaultLookAndFeels();
    addExternalLafs();
  }

  /**
   * Gets the supported look and feels info
   * @return a n array of LookAndFeels info
   */
  public static LookAndFeelInfo[] getLookAndFeels() {
    Main.logger.log(Level.INFO, "Getting look and feels");
    LookAndFeelInfo[] info = new LookAndFeelInfo[lafMap.size()];
    Set<String> keys = lafMap.keySet();
    int i = 0;
    for (Iterator<String> it = keys.iterator(); it.hasNext();) {
      String key = it.next();
      info[i++] = lafMap.get(key);
    }
    return info;
  }

  public static String getClassName(String laf) {
    Main.logger.log(Level.INFO, "Get class name for {0}", laf);
    Set<String> keys = lafMap.keySet();
    int i = 0;
    for (Iterator<String> it = keys.iterator(); it.hasNext();) {
      String key = it.next();
      if (key.equals(laf)) {
        return lafMap.get(key).getClassName();
      }
    }
    Main.logger.log(Level.WARNING, "Class name not found");
    return null;
  }

  public static void addExternalLafs() {
    File[] extLafs = getListOfExtLafs();
    for (int i = 0; i < extLafs.length; i++) {
      File dir = extLafs[i];
      String name = dir.getName();
      String[] jar = getListOfExtJars(dir);
      for (int j = 0 ; j < jar.length ; j++) {
        try {
          File jarFile = new File(Options.LAFS_PATH + name + "/" + jar[j]);
          JarFileLoader.addFile(jarFile);
          String[] lafClass = getLafClass(jarFile);
          if (lafClass.length == 1) {
            lafMap.put(name, new LookAndFeelInfo(name, lafClass[0]));
          } else if (lafClass.length > 1) {
            for (int k = 0; k < lafClass.length; k++) {
              String c = lafClass[k];
              String[] packages = c.split("\\.");
              lafMap.put(packages[packages.length - 1], new LookAndFeelInfo(packages[packages.length - 1], lafClass[k]));
            }
          } else {
            Main.logger.log(Level.SEVERE, "LAF Class not found");
          }
        } catch (IOException ex) {
          Main.logger.log(Level.SEVERE, "IO Exception on loading external laf", ex);
        }
      } 
    }
  }

  private static String[] getLafClass(File jar) {
    ArrayList<String> classes = new ArrayList<String>();
    try {
      JarInputStream jarFile = new JarInputStream(new FileInputStream(jar));
      JarEntry jarEntry;

      while (true) {
        jarEntry = jarFile.getNextJarEntry();
        if (jarEntry == null) {
          break;
        }
        if (!jarEntry.getName().startsWith("Abstract") && jarEntry.getName().endsWith("LookAndFeel.class")) {
          classes.add(jarEntry.toString().replace(".class", "").replaceAll("/", "."));
        }
      }
    } catch (Exception e) {
      Main.logger.log(Level.WARNING, "Did not find look and feel class");
      return null;
    }
    return classes.toArray(new String[classes.size()]);
  }

  private static String[] getListOfExtJars(File dir) {
    return dir.list(new FilenameFilter() {

      @Override
      public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(".jar");
      }
    });
  }

  private static File[] getListOfExtLafs() {
    return new File(Options.USER_DIR + Options.LAFS_PATH).listFiles(new FileFilter() {

      @Override
      public boolean accept(File pathname) {
        return pathname.isDirectory();
      }
    });
  }

  public static DefaultComboBoxModel getComboBoxModel() {
    Set<String> keys = lafMap.keySet();
    String[] lafNames = new String[keys.size()];
    int i = 0;
    for (Iterator<String> it = keys.iterator(); it.hasNext();) {
      Object key = it.next();
      LookAndFeelInfo info = lafMap.get(key);
      lafNames[i] = info.getName();
      Main.logger.log(Level.INFO, "Adding laf {0}", lafNames[i]);
      i++;
    }
    Arrays.sort(lafNames);
    return new DefaultComboBoxModel(lafNames);
  }

  private void getDefaultLookAndFeels() {
    UIManager.LookAndFeelInfo[] lookAndFeelInfos = UIManager.getInstalledLookAndFeels();
    LookAndFeelInfo laf[] = new LookAndFeelInfo[lookAndFeelInfos.length];
    for (int i = 0; i < lookAndFeelInfos.length; i++) {
      UIManager.LookAndFeelInfo lookAndFeelInfo = lookAndFeelInfos[i];
      lafMap.put(lookAndFeelInfo.getName(), lookAndFeelInfo);
    }
  }

  /**
   * Sets the look and feel for the application form
   * @param m The application form
   * @param strLaf The lookAndFeel
   */
  public static void setLookAndFeel(String laf) throws Exception {
    if (!laf.equals("")) {
      String className = LookAndFeels.getClassName(laf);
      if (className != null) {
        try {
          UIManager.setLookAndFeel(className);

        } catch (ClassNotFoundException ex) {
          throw new Exception("Look and feel class not found");
        }

      } else {
        throw new Exception("Look and feel classname not found");
      }
    } else {
      throw new Exception("Look and feel is not provided");
    }
  }
}

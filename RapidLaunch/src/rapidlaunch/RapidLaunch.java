/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rapidlaunch;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

/**
 *
 * @author Dehibernate
 */
public class RapidLaunch {

    MultiValueMap<String, String> mm = new MultiValueMap<>();

    public class Folder {

        public String name, path;

        public Folder(String n, String p) {
            name = n;
            path = p;
        }

        @Override
        public String toString() {
            return name + " = " + path;
        }
    }

    
    
    public RapidLaunch() {

        //store("sadness", "b:\\s");

      
        //System.out.println(mm.entrySet());
        listf(new File("C:\\Intel"));

       // System.out.println(mm.get("te"));
        System.out.println(mm.keySet());
        //Opens a folder or file
//        try {
//            Desktop desktop = Desktop.getDesktop();
//            desktop.open(new File("D:\\all"));
//        } catch (IOException ex) {
//            Logger.getLogger(RapidLaunch.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
    }

    public void listf(File f) {
        if (f.isDirectory() && f != null) {
            //Do Stuff Here
           String path = f.getAbsolutePath();
           String name = path.substring(path.lastIndexOf("\\")+1, path.length());
           store(name.toLowerCase(),path);
           System.out.println(path.substring(path.lastIndexOf("\\")+1, path.length())+" ==== "+f.getAbsolutePath());
            
            if (f.listFiles() != null) {
                for (File f1 : f.listFiles()) {
                    listf(f1);
                }
            }
        }
    }

    public void store(String name, String path) {
        name.replace("\\", "");
        for (int i = 0; i <= name.length(); i++) {
mm.put(name.substring(0, i), path);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RapidLaunch rapidLaunch = new RapidLaunch();
    }
}

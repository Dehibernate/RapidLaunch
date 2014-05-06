/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rapidlaunch;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Dehibernate
 */
public class TrieNode implements Serializable {

    public ArrayList<TrieNode> a = new ArrayList<>();
    public String value = "";

    public TrieNode(String s) {
        value = s;
        
    }

    public TrieNode() {
    }

    public String add(String path) {
        String test = (path.contains("\\")) ? (path.substring(0, path.indexOf("\\"))) : path;
        if (value != null && !value.equals(test)) {
            //return null;
        } else {
           // value = test;
        }
        int p = 0;
  
         boolean found = false;
                
                //If there is already a subnode for that folder use that.
                String subvalue = (path.contains("\\")) ? (path.substring(0, path.indexOf("\\"))) : path;
                for (TrieNode t : a) {
                    if (t.value.equals(subvalue) && path.contains("\\")) {
                        found = true;
                        int index = a.indexOf(t);
                        
                        //Concatenate the index of the object where the folder is stored
                        return "" + index + " " + t.add1(path);
                    }
                }
                
                //If there are no nodes that match that particular folder, then create a new one.
                if (!found && path != "") {
                    //Create a new node
                    TrieNode nt = new TrieNode();
                    a.add(nt);

                    int index = a.indexOf(nt);

                    //Concatenate the index of the new object where the folder is stored
                    return "" + index + " " + nt.add1(path);
                }
  
        if (path.substring(1, path.length()).equals(":\\")) {
            p++;
        }
        path = path.substring(0, path.length() - p);
        return add1(path);
    }

    private String add1(String path) {
        //Only add folder if there is a folder to add. (i.e. path is not empty)
        if (path.trim().length() > 0) {
            //Only do processing if the path is not a final folder
            if (!path.contains("\\")) {
                value = path;
            } else {
                value = path.substring(0, path.indexOf("\\"));
                path = path.substring(path.indexOf("\\") + 1, path.length());
                boolean found = false;
                
                //If there is already a subnode for that folder use that.
                String subvalue = (path.contains("\\")) ? (path.substring(0, path.indexOf("\\"))) : path;
                for (TrieNode t : a) {
                    if (t.value.equals(subvalue) && path.contains("\\")) {
                        found = true;
                        int index = a.indexOf(t);
                        
                        //Concatenate the index of the object where the folder is stored
                        return "" + index + " " + t.add1(path);
                    }
                }
                
                //If there are no nodes that match that particular folder, then create a new one.
                if (!found && path != "") {
                    //Create a new node
                    TrieNode nt = new TrieNode();
                    a.add(nt);

                    int index = a.indexOf(nt);

                    //Concatenate the index of the new object where the folder is stored
                    return "" + index + " " + nt.add1(path);
                }

            }
        }
        return "";
    }

    public String getPath(String code) {
        if (code == null) {
            return "";
        } else {
            if (code.trim().length() == 0) {
                return value;
            } else {
                int i = Integer.parseInt(code.substring(0, code.indexOf(" ")));
                code = code.substring(("" + i).length(), code.length()).trim();
                String delimiter = (value.length()==0) ? "" : "\\";
                return value + delimiter + a.get(i).getPath(code + " ");
            }
        }
    }

    public static void main(String[] args) {
        TrieNode t = new TrieNode();
        String path = t.add("c:\\d\\c\\q");
        String path1 = t.add("c:\\b");
        String path2 = t.add("d:\\b");
        System.out.println(path);
        System.out.println(t.getPath(path));
        System.out.println(t.getPath(path1));
        System.out.println(t.getPath(path2));
    }
}

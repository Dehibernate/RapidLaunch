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
public class Trie implements Serializable {
    public ArrayList<String> indices = new ArrayList<>();
    private TrieNode root = new TrieNode();

   
    
    public String add(String path) {
       return root.add(path);
    }

    public String getPath(String code) {
       return root.getPath(code);
    }
}

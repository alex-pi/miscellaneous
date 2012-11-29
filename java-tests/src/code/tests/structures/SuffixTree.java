/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.tests.structures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author Alejandro Pimentel
 */
public class SuffixTree {
    
    private Node root;
    
    public static SuffixTree build(String input){
        SuffixTree tree = new SuffixTree();
        String[] str = input.split("(?!^)");
        LinkedList<String> listSuff = new LinkedList();
        for(int i = str.length-1; i >= 0 ; i--){
            listSuff.push(str[i]);
            tree.place(listSuff.toArray(new String[listSuff.size()]), i, tree.root);
        }
        
        return tree;
    }
    
    private void place(String[] suff, Integer idx, Node current){
        Node base = current.findBase(suff);
        if(current.isLeaf() || base == null) {
            current.add(suff, idx);
            return;
        }
        String common = "";
        for(int i = 0; i < base.suffix.length && i < suff.length; i++ ){
            if(!suff[i].equals(base.suffix[i]))
                break;
            common += suff[i];
        }
        if(common.length() < base.suffix.length){
            String[] opt = new String[base.suffix.length-common.length()];
            for(int i = common.length(), j = 0 ; i < base.suffix.length ; i++, j++)
                opt[j] = base.suffix[i];
            base.add(opt, base.index);
            base.changeSuffix(common);
        }
        if(common.length() < suff.length){
            String[] opt = new String[suff.length-common.length()];
            for(int i = common.length(), j = 0 ; i < suff.length ; i++, j++)
                opt[j] = suff[i];
            place(opt, idx, base);
        }
    }
    
    private SuffixTree(){
        root = new Node("[root]", -1);
    }
    
    private void levelStr(StringBuilder accu, Node p){
        for (Node node : p.subs.values()) {
            accu.append(node).append("|||");
        }
        accu.append("\n");
        for (Node node : p.subs.values()) {
            levelStr(accu, node);
        }
    }
    
    @Override
    public String toString(){
        StringBuilder accu = new StringBuilder();
        accu.append(root).append("\n");
        
        levelStr(accu, root);
        return accu.toString();
    }
    
    protected class Node {
        private String[] suffix;
        private Map<String, Node> subs = new HashMap();
        private Integer index;
        
        protected Node(String suffix, Integer index){
            this.subs = new HashMap();
            this.index = index;
            this.suffix = suffix.split("(?!^)");
        }
        
        protected Node(String[] suffix, Integer index){
            this.subs = new HashMap();
            this.index = index;
            this.suffix = suffix;
        }
        
        public Boolean isLeaf(){
            return subs.isEmpty();
        }
        
        public void changeSuffix(String newSuf){
            this.suffix = newSuf.split("(?!^)");
        }
        
        public void add(String[] suff, Integer idx){
            if(suff == null || suff.length == 0) 
                throw new IllegalArgumentException("Empty suffix?, Are you serious?");
            Node n = new Node(suff, idx);
            this.subs.put(suff[0],n);
        }
        
        public Node findBase(String[] suff){
            String key = suff[0];
            return subs.get(key);
        }
        
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            for (String s : suffix) {
                sb.append(s);
            }
            sb.append(" index -> ").append(index);
            return sb.toString();
        }
    }
}

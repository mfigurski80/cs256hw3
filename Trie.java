import java.util.*;
import java.io.File;

public class Trie {
    public static class TrieNode {
        //each child of a TrieNode corresponds to a certain letter
        private HashMap<Character, TrieNode> charMap = new HashMap<>();

        public void insert(String s) {
            // exit condition
            if (s.length() <= 0) {
                charMap.put('\0', null);
                return;
            }

            char c = s.charAt(0);
            TrieNode child = charMap.get(c);
            if (child == null) { // actually need to insert
                child = new TrieNode();
                charMap.put(c, child); // save
            }
            child.insert(s.substring(1, s.length()));
        }

        public boolean contains(String s) {
            if (s.length() <= 0 && charMap.containsKey('\0'))
                return true;
            if (s.length() <= 0)
                return false;
            if (charMap.containsKey(s.charAt(0)))
                return charMap.get(s.charAt(0)).contains(s.substring(1, s.length()));
            return false;
        }

        public String toString() {
            String ret = "(";
            for (char key : charMap.keySet()) {
                if (key == '\0') {
                    ret += '.';
                } else {
                    ret += key;
                    ret += charMap.get(key).toString();
                }
            }
            ret += ")";
            return ret;
       }
    }

    public TrieNode root = new TrieNode();
    public void insert(String s){
        root.insert(s.toLowerCase());
    }
    public boolean contains(String s){
        return root.contains(s.toLowerCase());
    }

    //given a file with one word per line, insert all the words in the
    //file into the trie
    public void insertDictionary(String filename) throws Exception {
        File f = new File(filename);
        Scanner sc = new Scanner(f);

        while (sc.hasNext()) {
            root.insert(sc.next());
        }

    }

    public String toString() {
        return root.toString();
    }


    public static void main(String[] args) throws Exception {
        System.out.println("> Trie.java");
        Trie t = new Trie();
        t.insertDictionary("./words.txt");

        // t.insert("hello");
        // t.insert("hellor");
        // t.insert("hell");
        // t.insert("helapenos");
        // System.out.println(t.contains("hello"));
        // System.out.println(t.contains("hell"));
        // System.out.println(t.contains("hahah"));

        System.out.println(t);
    }

}

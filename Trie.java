import java.util.*;
public class Trie {
    public static class TrieNode {
        //each child of a TrieNode corresponds to a certain letter
        private HashMap<Character, TrieNode> charMap = new HashMap<>();
        /*
            There is more than one way to implement the trie. A 
            recursive approach might have the outer Trie.insert and 
            Trie.contains methods call the following recursive methods:
            
            public void insert(String s){
            }
            public boolean contains(String s){
            }
        */
    }
    public TrieNode root = new TrieNode();
    public void insert(String s){
        // your implementation goes here
    }
    public boolean contains(String s){
        // your implementation goes here
        
        // warning: tries normally need the list of words to be 
        //          prefix-free
        return true;
    }
    
    //given a file with one word per line, insert all the words in the
    //file into the trie
    public void insertDictionary(String filename){
        // your implementation goes here
    }
}

import java.util.HashSet;

public class WordSplitter {
    public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            throw new Exception("Args formatted incorrectly. Please use `WordSplitter [dictionary file] [string]`");
        }

        Trie t = new Trie();
        t.insertDictionary(args[0]);



    }
}

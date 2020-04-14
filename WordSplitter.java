import java.util.HashSet;

public class WordSplitter {
    public static Trie dict = new Trie();

    public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            throw new Exception("Args formatted incorrectly. Please use `WordSplitter [dictionary file] [string]`. Please");
        }

        dict.insertDictionary(args[0]);

        System.out.println(splitWord( args[1].toLowerCase() ));
    }

    public static String splitWord(String s) {
        if (s.length() <= 0) { // might be called with empty string. Important to not return "No Split"
            return "";
        }

        String curWord = "";

        while (true) {
            if (s.length() <= 0) { // have we eaten all the letter by accident?
                return "No Split";
            }
            curWord += s.charAt(0); // move next char over to curword
            s = s.substring(1, s.length());
            // System.out.println(curWord); // debug

            // have we found it?? Are we done?? Please?
            if (dict.contains(curWord)) {         // if you have passed the if statement, you have found a word
                String next = splitWord(s);       // now go repeat the problem on remaining string
                if (next != "No Split") {         // if that resolves to no split, continue adding letters
                    return curWord + " " + next;  // otherwise, you really are done now
                }
            }
        }

    }
}

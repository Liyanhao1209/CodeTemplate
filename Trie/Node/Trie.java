package Trie.Node;

public class Trie {
    static class TrieNode{
        boolean end; // this node is the end of some inserted string?
        TrieNode[] tns = new TrieNode[26]; // the successor node has 26 choices since the character set of a string has only 26 elements
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if(p.tns[c]==null) p.tns[c] = new TrieNode();
            p = p.tns[c];
        }
        p.end = true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if(p.tns[c]==null) return false;
            p = p.tns[c];
        }
        return p.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if(p.tns[c]==null) return false;
            p = p.tns[c];
        }
        return true;
    }
}

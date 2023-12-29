package Trie.Array;

public class Trie {
    int size;
    int index;
    int[][] trie;
    int[] count;
    public Trie(int size) {
        this.size = size;
        index = 0;
        trie = new int[size][26];
        count = new int[size];
    }

    public void insert(String word) {
        int p = 0;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if(trie[p][c]==0) trie[p][c] = ++index;
            p = trie[p][c];
        }
        count[p]++;
    }

    public boolean search(String word) {
        int p = 0;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if(trie[p][c]==0) return false;
            p = trie[p][c];
        }
        return count[p]>0;
    }

    public boolean startsWith(String prefix) {
        int p = 0;
        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if(trie[p][c]==0) return false;
            p = trie[p][c];
        }
        return true;
    }
}

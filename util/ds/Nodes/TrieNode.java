package util.ds.Nodes;

import java.util.HashMap;
import java.util.Map;

class TrieNode<T> {
    public int cnt = 0;
    public Map<T,TrieNode<T>> son = new HashMap<>();
}

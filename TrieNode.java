import java.util.HashMap;
import java.util.Map;

class TrieNode<T> {
    int cnt = 0;
    Map<T,TrieNode<T>> son = new HashMap<>();
}

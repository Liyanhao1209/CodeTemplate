package util.Interface;

public interface Stack<T> {
    boolean isEmpty();

    T pop();

    void push(T ele);

    T peek();

    int search(T target); // start from index 0,the first ele matches

    int size();
}

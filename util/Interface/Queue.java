package util.Interface;

public interface Queue<T> {
    public void push(T ele);

    public T pop();

    public T peek();

    public boolean empty();

}

package util.ds.Collections.Queue;

import util.Interface.Expander;
import util.Interface.Queue;

public class ArrayQueue<T> implements Queue<T>, Expander<T> {
    private T[] arr;
    private int front; // 头部元素
    private int rear; // 尾部元素的后一个位置
    private final int expandSpeed;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int expS){
        this.expandSpeed = expS;
        arr = (T[])new Object[0];

        front = 0;
        rear = 0;
    }

    @Override
    public void push(T ele) {
        // arr满，动态扩容
        if(front==0&&rear==arr.length){
            arr = this.dynamicDilatation(arr,expandSpeed*(arr.length+1));
        }else if(rear==arr.length){ // 仅仅是到尾了，但前面还有可用空间
            for(int i=front;i<rear;i++){
                arr[i-front] = arr[i];
            }
            front = 0;
            rear = rear-front+1;
        }

        arr[rear++] = ele;
    }

    @Override
    public T pop() {
        if(empty()){
            return null;
        }

        return arr[front++];
    }

    @Override
    public T peek() {
        if(empty()){
            return null;
        }

        return arr[front];
    }

    @Override
    public boolean empty() {
        return front==rear;
    }

    public int size(){
        return rear-front;
    }
}

package util.ds.Collections.Stack;

import java.lang.reflect.Array;

class ArrayQueue<T>  {
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

    public T pop() {
        if(empty()){
            return null;
        }

        return arr[front++];
    }

    public T peek() {
        if(empty()){
            return null;
        }

        return arr[front];
    }

    public int size(){
        return rear-front;
    }

    public boolean empty() {
        return front==rear;
    }

    @SuppressWarnings("unchecked")
    private T[] dynamicDilatation(T[] src, int newLen){
        if(src.length>=newLen){
            return src;
        }

        T[] res = (T[]) Array.newInstance(src.getClass().getComponentType(),newLen);

        System.arraycopy(src,0,res,0,src.length);

        return res;
    }
}

class MyStack {

    ArrayQueue<Integer> q1;
    ArrayQueue<Integer> q2;

    public MyStack() {
        q1 = new ArrayQueue<>(10);
        q2 = new ArrayQueue<>(10);
    }

    public void push(int x) {
        if(!q1.empty()){
            q2.push(q1.pop());
        }

        q1.push(x);
    }

    public int pop() {
        Integer res = q1.pop();

        while(q2.size()>1){
            q1.push(q2.pop());
        }

        ArrayQueue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;

        return res;
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.empty() && q2.empty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
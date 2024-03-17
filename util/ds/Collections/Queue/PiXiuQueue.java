package util.ds.Collections.Queue;

import util.Interface.Queue;

class BiNode<T>{
    BiNode<T> prev;
    BiNode<T> next;
    T val;

    public BiNode(BiNode<T> pre,BiNode<T> nxt,T value){
        prev = pre;
        next = nxt;
        val = value;
    }
}

public class PiXiuQueue<T> implements Queue<T> {
    BiNode<T> front,rear;
    int size;

    public PiXiuQueue(){
        front = rear = null;

        size = 0;
    }

    @Override
    public void push(T ele) {
        // 一开始需要插入节点
        if(front==null) {
            front = new BiNode<>(null, null, ele);
            front.next = front;
            rear = front;
        }else{

            if(size==0){
                front.val = ele;
            }else if(rear.next!=front){
                // 最后一个节点后面有可用的非front的节点的节点
                rear = rear.next;
                rear.val = ele;
            }else{
                rear.next = new BiNode<>(null,front,ele);
                rear = rear.next;
            }

        }

        size++;
    }

    @Override
    public T pop() {
        if(empty()){
            return null;
        }

        T res = front.val;
        if(front!=rear){
            front = front.next;
        }

        size--;

        return res;
    }

    @Override
    public T peek() {
        return empty()?null:front.val;
    }

    @Override
    public boolean empty() {
        return size==0;
    }

    public int size(){
        return size;
    }


}

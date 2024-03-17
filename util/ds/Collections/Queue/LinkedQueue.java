package util.ds.Collections.Queue;

import util.Interface.Queue;

class Node<T>{
    Node<T> next;
    T val;

    Node(T value,Node<T> nxt){
        this.next = nxt;
        this.val = value;
    }
}

public class LinkedQueue<T> implements Queue<T> {
    Node<T> head,front,rear;
    int size;

    public LinkedQueue(){
        front = rear = null;
        head = new Node(null,null);

        size = 0;
    }

    @Override
    public void push(T ele) {
        Node<T> tmp = new Node(ele, null);
        if(size==0){
            front = rear = tmp;
            head.next = tmp;
        }

        rear.next = tmp;
        rear = rear.next;

        size++;
    }

    @Override
    public T pop() {
        if(size==0){
            return null;
        }

        T res = front.val;
        head.next = front.next;
        front = front.next;
        size--;
        if(size==0){
            front = rear = null;
        }

        return res;
    }

    @Override
    public T peek() {
        return size==0?null:front.val;
    }

    @Override
    public boolean empty() {
        return size==0;
    }

    public int size(){
        return size;
    }
}

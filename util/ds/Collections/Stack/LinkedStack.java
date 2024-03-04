package util.ds.Collections.Stack;

import util.Interface.Stack;

class Node<T>{
    T val;
    Node<T> next;
    Node<T> prev;

    public Node(T val,Node<T> next,Node<T> prev){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<T> cur = this;
        while(cur.next!=null){
            sb.append(cur.val.toString()).append("->");
            cur = cur.next;
        }
        sb.append(cur.val.toString());
        return sb.toString();
    }
}

public class LinkedStack <T> implements Stack<T> {
    private final Node<T> head; // dummy head
    private Node<T> tail;
    private int len;

    public LinkedStack(){
        this.head = new Node<>(null, null,null);
        this.tail = head;
        this.len = 0;
    }
    @Override
    public boolean isEmpty() {
        return head.next==null;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            return null;
        }

        Node<T> tmp = tail;
        tail = tail.prev;
        tail.next = null;
        tmp.prev = null;
        len--;

        return tmp.val;
    }

    @Override
    public void push(T ele) {
        Node<T> nT = new Node<>(ele, null, tail);
        tail.next = nT;
        tail = nT;
        len++;
    }

    @Override
    public T peek() {
        return isEmpty()?null:tail.val;
    }

    @Override
    public int search(T target) {
        Node<T> cur = head.next;
        int index = 0;
        while(cur!=null){
            if(cur.val.equals(target)){
                break;
            }
            index++;
            cur = cur.next;
        }
        return index;
    }

    @Override
    public int size() {
        return len;
    }

    @Override
    public String toString(){
        String prefix = "from left to right correspond from bottom to top:\t[ ";
        String suffix = " ]";
        return isEmpty()?prefix+suffix:prefix+head+suffix;
    }
}

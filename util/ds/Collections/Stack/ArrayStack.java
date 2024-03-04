package util.ds.Collections.Stack;

import util.Interface.Expander;
import util.Interface.Stack;

public class ArrayStack<T> implements Expander<T>, Stack<T> {
    private final static int ILLEGAL_TOP_POINTER = -1;
    T[] arr;
    int top; // pointer to the top of the stk
    int expandSpeed;

    // you can optionally use the ExpandSpeed to assign the velocity of dynamic dilatation
    @SuppressWarnings("unchecked")
    public ArrayStack(int ExpandSpeed){
        arr = (T[])new Object[0];
        top = ILLEGAL_TOP_POINTER; // there's no element
        this.expandSpeed = ExpandSpeed;
    }

    @Override
    public boolean isEmpty() {
        return top==ILLEGAL_TOP_POINTER;
    }

    @Override
    public T pop() {
        return isEmpty()?null:arr[top--];
    }

    @Override
    public void push(T ele) {
        top++;
        if(arr.length<=top){
            arr = this.dynamicDilatation(arr,expandSpeed*(top+1));
        }
        arr[top] = ele;
    }

    @Override
    public T peek() {
        return isEmpty()?null:arr[top];
    }

    @Override
    public int search(T target) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(target)){
                return i;
            }
        }

        return ILLEGAL_TOP_POINTER;
    }

    @Override
    public int size() {
        return top+1;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("from left to right correspond from bottom to top:\t[ ");
        for (int i = 0; i < top; i++) {
            sb.append(arr[i].toString()).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}

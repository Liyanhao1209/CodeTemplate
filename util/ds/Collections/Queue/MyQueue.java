package util.ds.Collections.Queue;

import util.Interface.Queue;
import util.ds.Collections.Stack.ArrayStack;

public class MyQueue<T> implements Queue<T> {

    ArrayStack<T> stk1;
    ArrayStack<T> stk2;

    public MyQueue() {
        stk1 = new ArrayStack<>(10);
        stk2 = new ArrayStack<>(10);
    }

    @Override
    public void push(T ele) {
        if(stk1.isEmpty()){
            stk1.push(ele);
            return;
        }

        int size = stk2.size();
        for (int i = 0; i < size; i++) {
            stk1.push(stk2.pop());
        }

        stk2.push(ele);
        for (int i = 0; i < size; i++) {
            stk2.push(stk1.pop());
        }
    }

    @Override
    public T pop() {
        if(stk1.isEmpty()&&stk2.isEmpty()){
            return null;
        }

        T res = stk1.pop();
        if(!stk2.isEmpty()){
            stk1.push(stk2.pop());
        }

        return res;
    }

    @Override
    public T peek() {
        return stk1.peek();
    }

    @Override
    public boolean empty() {
        return stk1.isEmpty()&&stk2.isEmpty();
    }
}

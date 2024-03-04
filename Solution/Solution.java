package Solution;

import util.ds.Collections.Stack.ArrayStack;

public class Solution{
    public ArrayStack<Integer> solve(int[][] values){
        return showMySTK(values[0]);
    }

    public ArrayStack<Integer> showMySTK(int[] values){
        ArrayStack<Integer> stk = new ArrayStack<>(10);

        System.out.println(stk.isEmpty());
        for (int value : values) {
            stk.push(value);
        }
        System.out.println(stk.isEmpty());
        System.out.println(stk.search(3));
        while(!stk.isEmpty()){
            System.out.println(stk.pop());
        }
        System.out.println(stk.peek());

        return stk;
    }
}
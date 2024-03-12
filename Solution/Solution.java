package Solution;

import util.ds.Collections.Stack.ArrayStack;

public class Solution{
    public int[] reverseQueue(int[] q){
        int[] ans = new int[q.length];

        ArrayStack<Integer> stk = new ArrayStack<Integer>(10);
        for (int j : q) {
            stk.push(j);
        }

        int i=0;
        while(!stk.isEmpty()){
            ans[i++] = stk.pop();
        }

        return ans;
    }
}
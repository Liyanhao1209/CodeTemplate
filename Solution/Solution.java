package Solution;

import util.ds.Collections.Stack.LinkedStack;
import util.ds.Collections.Stack.OppositeStack;
import util.ds.Nodes.ListNode;

import static util.function.NodeFunction.getLen;

public class Solution{
    public void solve(int[][] values){
        showOppositeStack(values[0]);
    }

    public void showOppositeStack(int[] values){
        OppositeStack<Integer> stk = new OppositeStack<Integer>(10);

        boolean flag = true;
        for (int value : values) {
            if(flag){
                stk.push1(value);
            }else{
                stk.push2(value);
            }
            flag = !flag;
        }

        System.out.println(stk);
        System.out.println(stk.peek2());

        while(!stk.is1Empty()){
            System.out.println(stk.pop1());
        }

        System.out.println(stk);

        System.out.println(stk.size2());

        while(!stk.is2Empty()){
            System.out.println(stk.pop2());
        }

        System.out.println(stk.peek1());
    }
}
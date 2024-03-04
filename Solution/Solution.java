package Solution;

import util.ds.Collections.Stack.LinkedStack;
import util.ds.Nodes.ListNode;

import static util.function.NodeFunction.getLen;

public class Solution{
    public boolean solve(ListNode... nodes){
        return isSymmetric(nodes[0]);
    }

    // 带头结点
    public boolean isSymmetric(ListNode head){
        if(head.next==null||head.next.next==null){
            return true;
        }

        LinkedStack<Integer> stk = new LinkedStack<>();

        ListNode cur = head.next;

        int n = getLen(head);
        int specialIndex = n%2==0?(n+1):(n/2);

        int i = 0;
        while(cur!=null){
            if(i==specialIndex){
                cur = cur.next;
                i++;
                continue;
            }
            int val = cur.val;
            if(i<n/2){
                stk.push(val);
            }else{
                if(stk.pop()!=val){
                    return false;
                }
            }
            cur = cur.next;
            i++;
        }

        return true;
    }
}
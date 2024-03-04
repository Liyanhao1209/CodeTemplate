package util.function;

import util.ds.Nodes.BiListNode;
import util.ds.Nodes.ListNode;

public class NodeFunction {
    private static ListNode last;
    public static synchronized ListNode Reverse(ListNode node){
        if(node==null){
            return null;
        }

        ListNode dfs = dfs(node);
        dfs.next = null;

        return last;

    }

    private static synchronized ListNode dfs(ListNode node){
        if(node.next==null){
            last = node;
            return node;
        }

        ListNode next = dfs(node.next);
        next.next = node;

        return node;
    }

    public static int getLen(ListNode head){
        int len = 0;

        ListNode cur = head.next;
        while(cur!=null){
            len++;
            cur = cur.next;
        }

        return len;
    }

    // 构建双向链表
    public static BiListNode constructBiLinkedListViaArray(int[] values){
        BiListNode head = new BiListNode(null,null,0,0);

        BiListNode cur = head;
        for (int value : values) {
            cur.next = new BiListNode(cur,null,value,0);
            cur = cur.next;
        }

        return head;
    }

    // 创造K个单循环链表
    public static ListNode[] constructKCyclicLinkedListViaArray(int[][] values){
        ListNode[] LinkedLists = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            LinkedLists[i] = constructCyclicLinkedListViaArray(values[i]);
        }

        return LinkedLists;
    }

    // 创造1个单循环链表
    public static ListNode constructCyclicLinkedListViaArray(int[] values){
        ListNode dummy = new ListNode(0, null);

        ListNode cur = dummy;
        for (int value : values) {
            cur.next = new ListNode(value,null);
            cur = cur.next;
        }

        cur.next = dummy;

        return dummy;
    }

    // 根据K个数组生成K个链表
    public static ListNode[] constructKLinkedListViaArray(int[][] values){
        ListNode[] LinkedLists = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            LinkedLists[i] = constructLinkedListViaArray(values[i]);
        }

        return LinkedLists;
    }

    // 根据1个数组生成1个链表
    public static ListNode constructLinkedListViaArray(int[] arr){
        ListNode head  = new ListNode(0,null);
        ListNode cur = head;

        for (int i : arr) {
            cur.next = new ListNode(i,null);
            cur = cur.next;
        }

        return head;
    }
}

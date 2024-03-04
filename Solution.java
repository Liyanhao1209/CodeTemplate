class Solution{

    public void solve(ListNode... nodes){

    }

    // 带头结点
    public void yourMethod(ListNode... nodes){

    }

    private int getLen(ListNode head){
        int len = 0;

        ListNode cur = head.next;
        while(cur!=null){
            len++;
            cur = cur.next;
        }

        return len;
    }

}
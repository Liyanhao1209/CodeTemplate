class Solution{

    public BiListNode solve(int target, BiListNode... nodes){
        return locate(nodes[0],target);
    }

    // 带头结点
    public BiListNode locate(BiListNode head,int x){
        if(head.next==null){
            return head;
        }

        BiListNode cur = head.next;
        while(cur!=null){
            if(cur.val==x){
                cur.freq += 1;
                BiListNode start = cur;
                while(start.pre!=head){
                    if(start.freq>start.pre.freq){
                        exchangeFields(start,start.pre);
                    }else if(start.freq==start.pre.freq){
                        if(start.pre.val!=x){
                            exchangeFields(start,start.pre);
                        }
                    }else{
                        break;
                    }
                    start = start.pre;
                }
            }
            cur = cur.next;
        }

        return head;
    }

    private void exchangeFields(BiListNode n1,BiListNode n2){
        assert n1!=null && n2!=null;
        int tmp_val,tmp_freq;
        tmp_val = n1.val;
        tmp_freq = n1.freq;

        n1.val = n2.val;
        n1.freq = n2.freq;

        n2.val = tmp_val;
        n2.freq = tmp_freq;
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
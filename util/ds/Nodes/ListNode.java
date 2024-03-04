package util.ds.Nodes;

public class ListNode {
      public int val;
      public ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

       @Override
       public String toString() {
          StringBuilder sb = new StringBuilder();
          ListNode cur = this;
          while(cur!=null){
              sb.append(cur.val).append(" ");
              cur = cur.next;
          }
          return sb.toString().trim();
       }
 }
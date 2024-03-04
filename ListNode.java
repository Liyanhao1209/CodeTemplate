public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

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
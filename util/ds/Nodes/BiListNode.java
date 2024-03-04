package util.ds.Nodes;

public class BiListNode {
    public BiListNode pre;
    public BiListNode next;
    public int val;
    public int freq; // optional,just for some specific practices

    public BiListNode(BiListNode pre,BiListNode next,int val,int freq){
        this.pre = pre;
        this.next = next;
        this.val = val;
        this.freq = freq;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        BiListNode cur = this;
        while(cur!=null){
            sb.append(cur.val).append(" ");
            cur = cur.next;
        }
        return sb.toString().trim();
    }
}

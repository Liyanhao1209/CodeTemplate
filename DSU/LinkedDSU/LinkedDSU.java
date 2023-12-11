package DSU.LinkedDSU;

public class LinkedDSU {
    public static final int illegal_next=-1;
    private static class Node{
        int equiv;
        int next;
        int length;

        Node(int e,int n,int len){
            equiv = e;
            next = n;
            length = len;
        }
    }

    private final Node[] ns;

    public LinkedDSU(int n){
        ns = new Node[n];
        for (int i = 0; i < ns.length; i++) {
            ns[i] = new Node(i,illegal_next,1);
        }
    }

    public void union(int x,int y){
        // same equiv?
        int ex = find(x);
        int ey = find(y);
        if(ex == ey){
            return;
        }
        // merge small to large
        if(ns[ex].length>ns[ey].length){
            int et = ex;
            ex = ey;
            ey = et;
        }
        // change equiv
        int header = ex;
        while(ns[header].next!=illegal_next){
            ns[header].equiv = ey;
            header = ns[header].next;
        }
        ns[header].equiv = ey;
        // linked list insertion
        ns[header].next = ns[ey].next;
        ns[ey].next = ex;
        // update size
        ns[ey].length += ns[ex].length;
    }

    public int find(int x){
        return ns[x].equiv;
    }
}

package DSU.RecursiveDSU;

// LC765 official writeup
public class RecursiveDSU {
    private final int[] f;

    public RecursiveDSU(int n){
        f = new int[n];
        for (int i = 0; i < f.length; i++) {
            f[i] = i;
        }
    }

    public int getf(int x){
        if(f[x]==x){
            return x;
        }
        int newf = getf(f[x]);
        f[x] = newf; // path compression
        return newf;
    }

    public void add(int x,int y){
        int fx = getf(x);
        int fy = getf(y);
        f[fx] = fy;
    }
}

package BinaryIndexedTree;

public class BIT {

    private final int[] nums;

    private final int[] tree;

    // you can construct a BIT via an init arr
    // the class BIT will init the sum of each interval according the elements provided by the "nums" arr
    public BIT(int[] init){
        // O(n)
        int n = init.length;
        this.nums = init;
        this.tree = new int[n+1]; // start from index 1

        for (int i = 1; i <= n; i++) {
            tree[i] += nums[i-1];

            int nxt = i+(i&(-i));
            if(nxt<=n){
                tree[nxt]+=tree[i];
            }
        }
    }

    // you can construct a BIT via just a number n
    // then the elements of the arr are all 0
    // thus the sum of each interval is 0
    public BIT(int n){
        nums = new int[n];
        tree = new int[n+1];
    }

    public void update(int index,int val){
        int diff = val-nums[index];

        nums[index] = val;
        for(int i = index+1;i<tree.length;i += (i&(-i))){ // update the sum of each relevant interval
            tree[i] += diff;
        }
    }

    private int prefixSum(int index){
        int sum = 0;

        for(int i = index;i>0;i-=(i&(-i))){
            sum+=tree[i];
        }

        return sum;
    }

    public int sumRanges(int l,int r){
        return prefixSum(r+1)-prefixSum(l);
    }
}

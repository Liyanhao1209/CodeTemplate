package StringMatch.Z_Function;

public class Z_Function {
    /*
    1. abababzabababab
    2. aabcabxaaaz
    visualization: https://personal.utdallas.edu/~besp/demo/John2010/z-algorithm.htm
     */
    public int[] z_algorithm(String str){
        char[] ch = str.toCharArray();
        int n = ch.length;
        int[] z = new int[n];

        int l,r;
        l = r = 0;

        for(int i=1;i<n;i++){
            if(i<=r){
                z[i] = Math.min(z[i-l],r-i+1);
            }

            while(i+z[i]<n && ch[z[i]] == ch[i+z[i]]){
                l = i;
                r = i+z[i];
                z[i]+=1;
            }
        }

        return z;
    }

    public int LongestSuffixIndex(int[] z){
        for (int i = 1; i < z.length; i++) {
            if(z[i]+i==z.length){
                return i;
            }
        }
        return -1;
    }
}

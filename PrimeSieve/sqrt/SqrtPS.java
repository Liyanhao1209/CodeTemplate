package PrimeSieve.sqrt;

import PrimeSieve.PS;

import java.util.ArrayList;
import java.util.List;

public class SqrtPS implements PS {
    @Override
    public List<Integer> ps(int num) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(num<=1){
            return ans;
        }
        outer:for(int i=2;i<=num;i++){
            int sqrt = (int) Math.sqrt(i);
            for(int j=2;j<=sqrt;j++){
                if(i%j==0){
                    continue outer;
                }
            }
            ans.add(i);
        }
        return ans;
    }
}

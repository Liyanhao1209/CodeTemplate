package PrimeSieve.regular;

import PrimeSieve.PS;

import java.util.ArrayList;
import java.util.List;

public class RegularPS implements PS {
    public List<Integer> ps(int num){
        ArrayList<Integer> ans = new ArrayList<>();
        if(num<=1){
            return ans;
        }
        outer:for(int i=2;i<=num;i++){
            for(int j=2;j<i;j++){
                if(i%j==0){
                    continue outer;
                }
            }
            ans.add(i);
        }
        return ans;
    }
}

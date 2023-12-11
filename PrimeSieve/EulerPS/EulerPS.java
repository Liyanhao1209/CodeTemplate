package PrimeSieve.EulerPS;

import PrimeSieve.PS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * problem: 6 = 2*3,both marked by 2 and 3,redundant happens
 * key: Let each composite number be screened by its smallest prime factor.
 */
public class EulerPS implements PS {
    @Override
    public List<Integer> ps(int num) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(num<=1){
            return ans;
        }
        boolean[] isPrime = new boolean[num+1];
        Arrays.fill(isPrime,false);
        for(int i=2;i<=num;i++){
            if(!isPrime[i]) {
                ans.add(i);
            }
            for (int j = 0; (j < ans.size()) && (ans.get(j) * i <= num); j++) {
                isPrime[ans.get(j) * i] = true;
            }
        }
        return ans;
    }
}

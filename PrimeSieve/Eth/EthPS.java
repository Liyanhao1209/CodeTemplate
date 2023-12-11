package PrimeSieve.Eth;

import PrimeSieve.PS;
import PrimeSieve.sqrt.SqrtPS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// prime sieve alg of Eratosthenes

/**
 * conclusion: if num A is not a prime,then there exists prime P,P<=sqrt(A)
 */
public class EthPS implements PS {
    @Override
    public List<Integer> ps(int num) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(num<=1){
            return ans;
        }
        boolean[] isPrime = new boolean[num+1];
        Arrays.fill(isPrime,false);
        for(int i=2;i<=num;i++){
            // still not marked as a prime
            if(!isPrime[i]){
                ans.add(i);
                // mark k*i,k>=2,k∈N*
                for(int k=2;k*i<=num;k++){
                    isPrime[k*i]=true;
                }
            }
        }
        return ans;
    }
}

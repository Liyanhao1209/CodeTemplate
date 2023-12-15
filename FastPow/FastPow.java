package FastPow;

/**
 * x^n
 * decimal(n) = binary(a0a1a2...ak)
 * x^n = x^(a0*2^0+a1*2^1+...+ak*2^k)
 *     = (x^1)^a0 * (x^2)^a1 * ... * (x^(2^k))^ak
 * when ai==0,this step could be omitted
 * combine with the identical equation of mod computation,we now have withMod()
 */
public class FastPow {
    public double withoutMod(double x,int n){
        if(x==0.0){
            return 0.0;
        }
        double res = 1.0;
        long b = n;
        if(n<0){
            x = 1/x;
            b = -b;
        }
        while(b>0){
            if((b&1)==1){
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public double withMod(double x,int n,int mod){
        if(x==0.0){
            return 0.0;
        }
        double res = 1.0;
        long b = n;
        if(n<0){
            x = 1/x;
            b = -b;
        }
        while(b>0){
            if((b&1)==1){
                res = res * x %mod ;
            }
            x = x*x%mod;
            b >>= 1;
        }
        return res;
    }
}

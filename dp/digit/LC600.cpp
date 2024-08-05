#include <vector> 

using namespace std;

class Solution {
public:
    int findIntegers(int n) {
        int tmp = n;
        vector<int> bits{-1};
        int bit_len = 0;
        while(tmp){
            bits.push_back(tmp&1);
            tmp >>= 1;
            bit_len += 1;
        }

        vector<vector<vector<int>>> dp(bit_len,vector<vector<int>>(2,vector<int>(2)));

        int ans = 1;
        dp[0][1][0] = 1;
        dp[0][1][1] = 1;
        dp[0][0][1] = 1;
        dp[0][0][0] = 1;

        int i;
        for(i=0;i<bit_len;i++){
            if(i==0){
                ans += dp[i][1][0];
            }else{
                dp[i][1][1] = dp[i-1][0][bits[i]==0];
                dp[i][0][1] = dp[i-1][0][bits[i]==0] + (bits[i]?dp[i-1][1][1]:0);
                dp[i][1][0] = dp[i-1][0][0];
                dp[i][0][0] = dp[i-1][1][0] + dp[i-1][0][0];
                if(i<bit_len-1){
                    ans += dp[i][1][0];
                }else{
                    ans += dp[i][1][1];
                }
            }
        }

        return ans;
    }
};
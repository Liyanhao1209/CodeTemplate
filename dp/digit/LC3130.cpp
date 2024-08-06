#include <vector>

using namespace std;

const int MOD = 1e9+7;

class Solution {
public:
    int numberOfStableArrays(int zero, int one, int limit) {
        vector<vector<vector<int>>> 
            dp(zero+1,vector<vector<int>>(one+1,vector<int>(2)));

        int i;
        for(i=0;i<=min(limit,one);i++){
            dp[0][i][1] = 1;
        }
        for(i=0;i<=min(limit,zero);i++){
            dp[i][0][0] = 1;
        }

        int j;
        for(i=1;i<=zero;i++){
            for(j=1;j<=one;j++){
                dp[i][j][0] = ((long long)dp[i-1][j][0] + dp[i-1][j][1] - (i>limit?dp[i-limit-1][j][1]:0) + MOD)%MOD;
                dp[i][j][1] = ((long long)dp[i][j-1][0] + dp[i][j-1][1] - (j>limit?dp[i][j-limit-1][0]:0) + MOD)%MOD;
            }
        }
        return (dp[zero][one][0]+dp[zero][one][1])%MOD;
    }
};
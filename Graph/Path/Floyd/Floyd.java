package Graph.Path.Floyd;

public class Floyd {
    public Integer[][] shortestPath(Integer[][] g){
        int n = g.length;
        Integer[][] ans = g.clone(); // ought to be equal
        Integer[][] dp;
        for(int k=0;k<n;k++){
            dp=ans.clone();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i==j){
                        continue;
                    }
                    if(dp[i][j]==null){
                        if(dp[i][j]==null || dp[i][k]==null || dp[k][j]==null){
                            ans[i][j] = null;
                        }
                        else{
                            ans[i][j] = dp[i][k]+dp[k][j];
                        }
                        continue;
                    }
                    ans[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k][j]); // with direction
                }
            }
        }
        return ans;
    }
}

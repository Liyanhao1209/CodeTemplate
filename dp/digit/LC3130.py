from functools import cache

mod = 10**9+7

class Solution:
    def numberOfStableArrays(self, zero: int, one: int, limit: int) -> int:
        
        @cache
        def dfs(i:int,j:int,k:int)->int:
            if i==0:
                return 1 if j<=limit and k==1 else 0
            if j==0:
                return 1 if i<=limit and k==0 else 0
            if k==0:
                return (dfs(i-1,j,0) + dfs(i-1,j,1) - (dfs(i-limit-1,j,1) if i>limit else 0) )%mod
            else:
                return (dfs(i,j-1,0) + dfs(i,j-1,1) - (dfs(i,j-limit-1,0) if j>limit else 0) )%mod
        
        ans = (dfs(zero,one,0)+dfs(zero,one,1))%mod
        dfs.cache_clear()  # 清空缓存防止爆内存
        return ans

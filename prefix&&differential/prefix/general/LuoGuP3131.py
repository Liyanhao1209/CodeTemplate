# 我用dp做了
n = int(input())
nums = [int(input()) for _ in range(n)]

# dp = [[-1 for _ in range(7)] for _ in range(n)]
tr = [[0 for _ in range(7)] for _ in range(n)]
# dp[n-1][nums[n-1]%7] = nums[n-1]
tr[n-1][nums[n-1]%7] = 1

ans = 0
for i in range(n-2,-1,-1):
    # dp[i][nums[i]%7] = nums[i]
    tr[i][nums[i]%7] = 1
    for j,x in enumerate(tr[i+1]):
        rest = (j+nums[i])%7
        if x:
            tr[i][rest] = max(tr[i][rest],1+tr[i+1][j])
        # if x!=-1:
            # dp[i][rest] = max(dp[i][rest],x+nums[i]) 
            
    ans = max(ans,tr[i][0])

print(ans)
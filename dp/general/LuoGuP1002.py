n,m,x,y = tuple(map(int,input().split()))

dp = [[0 for _ in range(m+1)] for _ in range(n+1)]
dp[0][0] = 1

diff = [
    (2,1),(1,2),(-1,2),(-2,1),(-2,-1),(-1,-2),(1,-2),(2,-1),(0,0)
]

for i in range(n+1):
    for j in range(m+1):
        if (i-x,j-y) in diff or i==j==0:
            continue
        dp[i][j] = (dp[i-1][j] if i>0 else 0) + (dp[i][j-1] if j>0 else 0)

print(dp[n][m])
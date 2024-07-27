m,n = tuple(map(int,input().split()))

mat = []
for _ in range(m):
    mat.append(list(map(int,input().split())))

prefix = [[0 for _ in range(n+1)]  for _ in range(m+1)]
for i in range(m):
    for j in range(n):
        prefix[i+1][j+1] = prefix[i][j+1] + prefix[i+1][j] - prefix[i][j] + mat[i][j]

def sub_mat_sum(x1:int,y1:int,x2:int,y2:int)->int:
    return prefix[x2][y2] - prefix[x1-1][y2] - prefix[x2][y1-1] + prefix[x1-1][y1-1]

ans = 0
for i in range(1,m+1):
    for j in range(1,n+1):
        for k in range(1,min(m-i+1,n-j+1)+1):
            if k*k == sub_mat_sum(i,j,i+k-1,j+k-1):
                ans = max(ans,k)

print(ans)
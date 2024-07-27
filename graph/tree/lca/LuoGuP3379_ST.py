import math

N,M,S = tuple(map(int,input().split()))

g = [[] for _ in range(N+1)]
pows = int(math.ceil(math.log2(N)))

dep = [0 for _ in range(N+1)]
fa = [[0 for _ in range(pows+1)] for _ in range(N+1)]

for _ in range(N-1):
    x,y = tuple(map(int,input().split()))
    g[x].append(y)
    g[y].append(x)

# 倍增预处理ST表
def dfs(x:int,father:int):
    dep[x] = dep[father]+1
    
    fa[x][0] = father
    for i in range(1,pows+1):
        fa[x][i] = fa[fa[x][i-1]][i-1]
    
    for c in g[x]:
        if c!=father:
            dfs(c,x)

# LCA
def lca(s:int,t:int)->int:
    if dep[s]<dep[t]:
        s,t = t,s
    
    # 先跳到同一层
    for i in range(pows,-1,-1):
        if dep[fa[s][i]] >= dep[t]:
            s = fa[s][i]
    
    if s==t:
        return s
    
    # 再一起跳到lca的下一层
    for i in range(pows,-1,-1):
        if fa[s][i]!=fa[t][i]:
            s,t = fa[s][i],fa[t][i]
    
    return fa[s][0]

dfs(S,0)
for _ in range(M):
    s,t = tuple(map(int,input().split()))
    print(lca(s,t))
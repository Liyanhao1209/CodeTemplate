N,K = tuple(map(int,input().split()))

g = [[] for _ in range(N+1)]
for _ in range(N-1):
    x,y = tuple(map(int,input().split()))
    g[x].append(y)
    g[y].append(x)

import math
pows = int(math.ceil(math.log2(N)))
dep = [0 for _ in range(N+1)]
fa = [[0 for _ in range(pows+1)] for _ in range(N+1)]

def dfs():
    stk = [(1,0)]
    while stk:
        x,father = stk.pop()
        
        dep[x] = dep[father]+1
        fa[x][0] = father

        for i in range(1,pows+1):
            fa[x][i] = fa[fa[x][i-1]][i-1]
        
        for c in g[x]:
            if c!=father:
                stk.append((c,x))


def lca(s:int,t:int)->int:
    if dep[s]<dep[t]:
        s,t = t,s
    
    for i in range(pows,-1,-1):
        if dep[fa[s][i]]>=dep[t]:
            s = fa[s][i]
    
    if s==t:
        return s

    for i in range(pows,-1,-1):
        if fa[s][i]!=fa[t][i]:
            s,t = fa[s][i],fa[t][i]
    
    return fa[s][0]

dfs()
diff = [0 for _ in range(N+1)]
for _ in range(K):
    s,t = tuple(map(int,input().split()))
    l = lca(s,t)
    diff[s] += 1
    diff[l] -= 1
    diff[t] += 1
    diff[fa[l][0]] -= 1

pressure = 0

def traverse()->int:
    stk,order = [(1,0)],[]
    while stk:
        x,father = stk.pop()
        order.append((x,father))
        for c in g[x]:
            if c!=father:
                stk.append((c,x))
    
    for x,father in reversed(order):
        for c in g[x]:
            if c!=father:
                diff[x]+=diff[c]
    return max(diff)

pressure = traverse()
print(pressure)
from typing import List

grid = []

m,n = 5,6

for _ in range(m):
    grid.append(list(map(int,input().split())))

# 仅枚举第一行，检查剩余行 操作从全0到全1
f_ops = [x for x in range(64)]

directions = [
    (0,0),(-1,0),(0,1),(1,0),(0,-1)
]

def mat_clone(g:List[List[int]])->List[List[int]]:
    r,c = len(g),len(g[0])
    ans = [[0 for _ in range(c)] for _ in range(r)]
    for i in range(r):
        for j in range(c):
            ans[i][j] = g[i][j]
    return ans

def all_down(g:List[List[int]])->bool:
    return sum([sum(g[i]) for i in range(len(grid))])==0

def is_valid(x:int,y:int)->bool:
    return 0<=x<m and 0<=y<n

def flip(x:int,y:int,puz:List[List[int]]):
    for direction in directions:
        nx,ny = x+direction[0],y+direction[1]
        if is_valid(nx,ny):
            puz[nx][ny] = 1-puz[nx][ny]

def check(fop:int)->bool:
    ops = [[0 for _ in range(n)] for _ in range(m)]
    for i in range(n-1,-1,-1):
        ops[0][i] = fop&1
        fop >>= 1
    puz = mat_clone(grid)
    for i,op in enumerate(ops[0]):
        if op==1:
            flip(0,i,puz)
    
    for i in range(1,m):
        for j in range(n):
            if puz[i-1][j]==1:
                ops[i][j] = 1
                flip(i,j,puz)
    if all_down(puz):
        for row in ops:
            print(' '.join(list(map(str,row))))
        return True
    return False

for f_op in f_ops:
    if check(f_op):
        break
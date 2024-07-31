from typing import List

# 带懒标记
class node:
    def __init__(self,l:int,r:int,sum:int,add:int) -> None:
        self.l = l
        self.r = r
        self.sum = sum
        self.add = add

# 下标从1开始
class SegTree:

    def lc(self,p:int)->int:
        return p<<1
    
    def rc(self,p:int)->int:
        return (p<<1)|1

    # 懒标记向下传递
    def pushdown(self,curr:int):
        if self.tr[curr].add:
            self.tr[self.lc(curr)].sum += (self.tr[self.lc(curr)].r-self.tr[self.lc(curr)].l+1)*self.tr[curr].add
            self.tr[self.rc(curr)].sum += (self.tr[self.rc(curr)].r-self.tr[self.rc(curr)].l+1)*self.tr[curr].add
            self.tr[self.lc(curr)].add += self.tr[curr].add
            self.tr[self.rc(curr)].add += self.tr[curr].add
            self.tr[curr].add= 0

    # 懒标记回溯
    def pushup(self,curr:int):
        self.tr[curr].sum = self.tr[self.lc(curr)].sum + self.tr[self.rc(curr)].sum
    

    def __init__(self,w:List[int]) -> None:
        w = [0]+w
        n = len(w)

        self.tr = [node(-1,-1,-1,-1) for _ in range(4*n)]

        def build(curr:int,l:int,r:int):
            self.tr[curr] = node(l,r,w[l],0)
            if l==r:
                return
            mid = (l+r)>>1
            build(self.lc(curr),l,mid)
            build(self.rc(curr),mid+1,r)
            self.tr[curr].sum = self.tr[self.lc(curr)].sum + self.tr[self.rc(curr)].sum
        
        build(1,1,n-1)

    def update_pt(self,curr:int,x:int,diff:int):
        if self.tr[curr].l == self.tr[curr].r == x:
            self.tr[curr].sum += diff
            return
        
        mid = (self.tr[curr].l+self.tr[curr].r)>>1

        if x<=mid:
            self.update_pt(self.lc(curr),x,diff)
        else:
            self.update_pt(self.rc(curr),x,diff)
        self.pushup(curr)

    def update(self,curr:int,x:int,y:int,diff:int):
        if x<=self.tr[curr].l and self.tr[curr].r<=y:
            self.tr[curr].sum += (self.tr[curr].r-self.tr[curr].l+1)*diff
            self.tr[curr].add += diff
            return
        mid = (self.tr[curr].l + self.tr[curr].r)>>1
        
        self.pushdown(curr)

        if x<=mid:
            self.update(self.lc(curr),x,y,diff)
        if y>mid:
            self.update(self.rc(curr),x,y,diff)

        self.pushup(curr)
    
    def query(self,curr:int,x:int,y:int)->int:
        if x<=self.tr[curr].l and self.tr[curr].r<=y:
            return self.tr[curr].sum
        
        mid = (self.tr[curr].l+self.tr[curr].r)>>1
        self.pushdown(curr)
        res = 0
        if x<=mid:
            res += self.query(self.lc(curr),x,max(x,min(y,mid)))
        if y>mid:
            res += self.query(self.rc(curr),min(y,max(mid+1,x)),y)
        return res

n,m = tuple(map(int,input().split()))

arr = list(map(int,input().split()))
seg_t = SegTree(arr)

for _ in range(m):
    ops = list(map(int,input().split()))
    if ops[0]==1:
        seg_t.update(1,ops[1],ops[2],ops[3])
    else:
        print(seg_t.query(1,ops[1],ops[2]))

class Node:
    def __init__(self,left,right,l:int,r:int,sum:int,add:int) -> None:
        self.left = left
        self.right = right
        self.l = l
        self.r = r
        self.sum = sum
        self.add = add
    
    def __str__(self)->str:
        return f'range:[{self.l},{self.r}],sum:{self.sum}'
        

class DynamicSegTree:
    def __init__(self,lx:int,ry:int) -> None:
        self.root = Node(None,None,lx,ry,0,0)
    
    def pushdown(self,node:Node):
        mid = (node.l+node.r)>>1
        if node.left is None:
            node.left = Node(None,None,node.l,mid,0,0)
        if node.right is None:
            node.right = Node(None,None,mid+1,node.r,0,0)
        if node.add:
            node.left.sum += (node.left.r-node.left.l+1)*node.add
            node.right.sum += (node.right.r-node.right.l+1)*node.add
            node.left.add += node.add
            node.right.add += node.add
            node.add = 0
    
    def pushup(self,node:Node):
        node.sum = node.left.sum + node.right.sum
    
    def update(self,l:int,r:int,diff:int,node:Node):
        if l<=node.l and node.r<=r:
            node.sum += (node.r-node.l+1)*diff
            node.add += diff
            return
        
        self.pushdown(node)
        mid = (node.l+node.r)>>1
        if l<=mid:
            self.update(l,r,diff,node.left)
        if r>mid:
            self.update(l,r,diff,node.right)
        self.pushup(node)

    def query(self,l:int,r:int,node:Node)->int:
        if l<=node.l and node.r<=r:
            return node.sum
        
        self.pushdown(node)
        
        res = 0
        mid = (node.l+node.r)>>1
        if l<=mid:
            res += self.query(l,r,node.left)
        if r>mid:
            res += self.query(l,r,node.right)
        return res
    

n,m = tuple(map(int,input().split()))

arr = list(map(int,input().split()))
seg_t = DynamicSegTree(1,n+1)
for i,x in enumerate(arr):
    seg_t.update(i+1,i+1,x,seg_t.root)

for _ in range(m):
    ops = list(map(int,input().split()))
    if ops[0]==1:
        seg_t.update(ops[1],ops[2],ops[3],seg_t.root)
    else:
        print(seg_t.query(ops[1],ops[2],seg_t.root))
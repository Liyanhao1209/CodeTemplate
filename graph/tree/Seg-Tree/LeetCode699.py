from typing import List

class Node:
    def __init__(self,left,right,l:int,r:int,sum:int,add:int) -> None:
        self.left = left
        self.right = right
        self.l = l
        self.r = r
        self.sum = sum
        self.add = add
        

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
            node.left.sum = node.add
            node.right.sum = node.add
            node.left.add = node.right.add = node.add
            node.add = 0
    
    def pushup(self,node:Node):
        node.sum = max(node.left.sum,node.right.sum)
    
    def update(self,l:int,r:int,diff:int,node:Node):
        if l<=node.l and node.r<=r:
            node.sum = diff
            node.add = diff
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
            res = max(res,self.query(l,r,node.left))
        if r>mid:
            res = max(res,self.query(l,r,node.right))
        return res

class Solution:
    def fallingSquares(self, positions: List[List[int]]) -> List[int]:
        mx = max(l+s for l,s in positions)+1
        st = DynamicSegTree(1,mx)

        ans = []
        tmp = 0
        for l,s in positions:
            r = l+s-1
            h = st.query(l,r,st.root)+s
            tmp = max(h,tmp)
            ans.append(tmp)
            st.update(l,r,h,st.root)
        return ans
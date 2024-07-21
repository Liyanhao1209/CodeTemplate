from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# version 1
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        ans = 0

        def check(d:dict,tmp:dict,curr:int):
            nonlocal ans
            for k,v in d.items():
                if k+curr == targetSum:
                    ans += v
                if k+curr in tmp:
                    tmp[k+curr] += v
                else:
                    tmp[k+curr] = v

        def dfs(node:TreeNode)->dict:
            if node is None:
                return {}
            
            nonlocal ans
            ld = dfs(node.left)
            rd = dfs(node.right)

            if node.val == targetSum:
                ans += 1
            res = {}
            res[node.val] = 1
            check(ld,res,node.val)
            check(rd,res,node.val)
            return res
        
        dfs(root)
        return ans

# version 2
from collections import defaultdict
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        m = defaultdict(int)
        m[0] = 1
        

        def dfs(node:TreeNode,prefix:int)->int:
            if node is None:
                return 0
            cnt = 0

            prefix += node.val
            if prefix - targetSum in m:
                cnt += m[prefix-targetSum]
            m[prefix] += 1

            cnt += dfs(node.left,prefix)
            cnt += dfs(node.right,prefix)

            m[prefix]-=1

            return cnt

        return dfs(root,0)
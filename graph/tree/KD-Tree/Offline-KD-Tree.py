# In-mem-KD树，仅支持离线

from typing import List,Callable
import math

class Node:
    def __init__(self,data:List[float],split_index:int) -> None:
        self.data = data
        self.split_index = split_index
        self.lc = None
        self.rc = None
    
    def __str__(self) -> str:
        return f'数据域:{self.data},分割维度:{self.split_index}'


class KDT:

    def ruled_sort(self,points:List[List[float]],sort_key:int)->List[List[float]]:
        return sorted(points,key=lambda l:l[sort_key])
    
    # O(n * log^2(n))
    def __init__(self,points:List[List[float]]) -> None:
        
        def divide(pts:List[List[float]],si:int)->Node:
            if len(pts)==0:
                return None
            pts = self.ruled_sort(pts,si)
            mid = len(pts)//2

            subRoot = Node(pts[mid],si)
            subRoot.lc = divide(pts[0:mid],(si+1)%len(pts[0]))
            subRoot.rc = divide(pts[mid+1:len(pts)],(si+1)%len(pts[0]))

            return subRoot
        
        self.root = divide(points,0)
        

    def query(self,point:List[float],dis_cal:Callable[[List[float],List[float]],float])->Node:
        NN = None
        dis = math.inf

        def NNS(q:List[float],curr:Node):
            nonlocal NN,dis
            if curr is None:
                return
            new_dis = dis_cal(q,curr.data)
            if dis > new_dis:
                NN = curr
                dis = new_dis
            
            if q[curr.split_index] <= curr.data[curr.split_index]:
                NNS(q,curr.lc)
                if q[curr.split_index] + dis > curr.data[curr.split_index]:
                    NNS(q,curr.rc)
            else:
                NNS(q,curr.rc)
                if q[curr.split_index] - dis <= curr.data[curr.split_index]:
                    NNS(q,curr.lc)
        
        NNS(point,self.root)
        return NN
    
    def __str__(self) -> str:

        def height(root:Node)->int:
            if root is None:
                return 0
            return 1+max(height(root.rc),height(root.lc))
        
        h = height(self.root)

        result = []
        if self.root is None:
            return "KD树为空"
        
        skip = 8
        queue = [(self.root, (h-1)*skip)]  # (节点, 缩进级别)
        pre = self.root.split_index
        while queue:
            node, indent = queue.pop(0)
            indent_spaces = ' ' * indent
            if node:
                if pre!=node.split_index:
                    result.append('\n\n')
                pre = node.split_index
                result.append(f"{indent_spaces}{node}")
                queue.append((node.lc, indent-skip))
                queue.append((node.rc, indent-skip//2))
        return ''.join(result)

if __name__=="__main__":
    l = [
            [7,2],[8,1],[4,7],[5,4],[9,6],[2,3]
        ]
    kdt = KDT(
        l
    )
    print(f'以{l}构建KD树:\n{kdt}\n')

    def euclidean_dis(pt1:List[float],pt2:List[float])->float:
        s_sum = 0.0
        for num1,num2 in zip(pt1,pt2):
            s_sum += pow(num1-num2,2)
        return math.sqrt(s_sum)

    q = [2.1,3.1]
    print(f'以欧式距离查询距离{q}的最近邻的点:{kdt.query(q,euclidean_dis)}')
        


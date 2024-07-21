n = int(input())

a,b = tuple(map(int,input().split()))

from functools import total_ordering

@total_ordering
class nh:
    def __init__(self,tup:tuple) -> None:
        self.l = tup[0]
        self.r = tup[1]

    def  __lt__(self,x)->bool:
        if isinstance(x,nh):
            return max(x.r,self.l*self.r) < max(self.r,x.l*x.r)

lrh = [] 
for _ in range(n):
    lrh.append(
        nh(tuple(map(int,input().split())))
    )

lrh = sorted(lrh)

mx = 0
base = a

for nho in lrh:
   mx = max(mx,base//nho.r)
   base *= nho.l

print(mx) 
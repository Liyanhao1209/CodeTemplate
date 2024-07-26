from functools import total_ordering

n = int(input())

@total_ordering
class nh:

    def __init__(self,l:int,r:int) -> None:
        self.l = l
        self.r = r
    
    def __lt__(self,x)->bool:
        if isinstance(x,nh):
            return min(self.l,x.r) < min(x.l,self.r)


def solve():
    m = int(input())
    nhs = []
    for _ in range(m):
        l,r = tuple(map(int,input().split()))
        nhs.append(nh(l,r))
    nhs = sorted(nhs)

    prec = nhs[0].l+nhs[0].r
    pres = nhs[0].l

    for i in range(1,m):
        pres += nhs[i].l
        prec = max(prec,pres)+nhs[i].r
    print(prec)

while n:
    solve()
    n-=1
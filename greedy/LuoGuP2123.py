from functools import total_ordering

n = int(input())

@total_ordering
class nh:

    def __init__(self,l:int,r:int,d:int) -> None:
        self.l = l
        self.r = r
        self.d = d
    
    def __lt__(self,x)->bool:
        if isinstance(x,nh):
            if self.d!=x.d:
                return self.d<x.d
            if self.d<=0:
                return self.l<x.l
            return self.r>x.r


def solve():
    m = int(input())
    nhs = []
    for _ in range(m):
        l,r = tuple(map(int,input().split()))
        nhs.append(nh(l,r,
                      1 if l>r else (
                        -1 if l<r else 0
                      )))
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
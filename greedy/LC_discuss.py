# https://leetcode.cn/circle/discuss/8gAKsy/
n = int(input())
m = int(input())

arr = [tuple(map(int,input().split())) for _ in range(m)]
arr = sorted(arr,key=lambda tup:(tup[0],-tup[1]))

l,r,ans = 1,m+1,-1
while l<r:
    mid = (l+r)>>1

    def check(mid:int)->bool:
        left = 1
        aid = []

        for cl,cr in arr:
            if cl>left:
                return False
            if not aid:
                aid.append((cl,cr))
                left = cr+1
            else:
                pl,pr = aid[-1]
                if pl<=cl<=cr<=pr:
                    continue
                while aid and cl<=aid[-1][0]<=aid[-1][1]<=cr:
                    aid.pop()
                if aid:
                    aid.append((max(aid[-1][1],cl)+1,cr))
                else:
                    aid.append((cl,cr))
                left = cr+1
        return left>n and len(aid)<=mid
    
    if check(mid):
        ans = mid
        r = mid
    else:
        l = mid+1
    
print(ans)
import heapq

n = int(input())

works = []
q = []
for _ in range(n):
    w = tuple(map(int,input().split()))
    works.append(w)

works = sorted(works,key=lambda tup:(tup[0],tup[1]))

ans = 0
for i,(d,p) in enumerate(works):
    if len(q)<d:
        ans += p
    else:
        pre_p = heapq.heappop(q)
        ans += p - pre_p
    heapq.heappush(q,p)

print(ans)
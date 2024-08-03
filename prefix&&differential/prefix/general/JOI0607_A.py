n,k = tuple(map(int,input().split()))

mx = 0
tmp = 0
ln = []

for i in range(k):
    a = int(input())
    ln.append(a)
    tmp += a

mx = tmp
for _ in range(n-k):
    a = int(input())
    tmp += a-ln.pop(0)
    mx = max(mx,tmp)
    ln.append(a)

print(mx)
    
n = int(input())

nums = list(map(int,input().split()))

m = int(input())
prefix = [0]
tmp = 0

for x in nums:
    tmp += x
    prefix.append(tmp)

for _ in range(m):
    a,b = tuple(map(int,input().split()))
    print(prefix[b]-prefix[a-1])
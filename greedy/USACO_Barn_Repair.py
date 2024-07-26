m,s,c = tuple(map(int,input().split()))
indexes = []

for _ in range(c):
    indexes.append(int(input()))
indexes = sorted(indexes)

diff = []
for i in range(1,len(indexes)):
    diff.append(indexes[i]-indexes[i-1])
diff = sorted(diff,reverse=True)

if m>=c:
    print(c)
else:
    rest = max(indexes)-min(indexes)+1
    for i in range(m-1):
        rest -= diff[i]-1

    print(rest)
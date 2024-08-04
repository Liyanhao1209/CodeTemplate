N = int(input())

indexes = sorted([int(input()) for _ in range(N)])
ans = 0

diff = [0]

for i in range(1,N):
    diff.append((indexes[i]-indexes[i-1])*i+diff[-1])
    ans += diff[-1]

print(ans*2)
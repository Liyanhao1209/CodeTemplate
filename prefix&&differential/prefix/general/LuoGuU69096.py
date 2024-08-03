n = int(input())

nums = list(map(int,input().split()))

print(nums[0],end=" ")
for i in range(0,len(nums)-1):
    print(nums[i+1]-nums[i],end=" ")
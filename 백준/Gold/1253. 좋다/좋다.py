import sys
input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split()))
arr.sort()

result = 0
for i, num in enumerate(arr):
    temp = arr[:i]+arr[i+1:]
    left, right = 0, len(temp)-1
    while left < right:
        if temp[left]+temp[right] > num:
            right -= 1
        elif temp[left]+temp[right] < num:
            left += 1
        else:
            result += 1
            break

print(result)
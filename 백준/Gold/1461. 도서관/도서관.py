import sys
input = sys.stdin.readline

def add_to_distance(distance, arr, m):
    for i in range(len(arr) // m):
        distance.append(abs(arr[i * m]))
    
    if len(arr) % m > 0:
        distance.append(abs(arr[(len(arr) // m) * m]))
    

n, m = map(int, input().split())
books = list(map(int, input().split()))

right = [x for x in books if x > 0]
left = [x for x in books if x < 0]

left.sort()
right.sort(reverse=True)
distance = []
add_to_distance(distance, left, m)
add_to_distance(distance, right, m)

print(sum(distance) * 2 - max(distance))
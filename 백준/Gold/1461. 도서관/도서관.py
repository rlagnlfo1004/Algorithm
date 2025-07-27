#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 1416                              :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/1416                           #+#        #+#      #+#     #
#    Solved: 2025/07/27 21:59:49 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #
import sys
input = sys.stdin.readline

def add_to_distance(distance, arr, m):
    for i in range(len(arr) // m):
        distance.append(arr[i * m])
    
    if len(arr) % m > 0:
        distance.append(arr[(len(arr) // m) * m])
    

n, m = map(int, input().split())
left = []
right = []
distance = []
numbers = list(map(int, input().split()))

for i in numbers:
    if i > 0:
        left.append(abs(i))
    else:
        right.append(abs(i))

left.sort(reverse=True)
right.sort(reverse=True)
add_to_distance(distance, left, m)
add_to_distance(distance, right, m)

distance.sort()
result = distance.pop()
result += sum(distance) * 2
print(result)


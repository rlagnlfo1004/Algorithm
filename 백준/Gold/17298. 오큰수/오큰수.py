#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 17298                             :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/17298                          #+#        #+#      #+#     #
#    Solved: 2025/08/18 03:37:01 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #
import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
result = [0] * N
stack = []

for i in range(N):
    while stack and A[stack[-1]] < A[i]:
        result[stack.pop()] = A[i]
    
    stack.append(i)
    
while stack:
    result[stack.pop()] = -1

for i in result:
    print(i, end=' ')
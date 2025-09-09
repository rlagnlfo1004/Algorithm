#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 1377                              :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/1377                           #+#        #+#      #+#     #
#    Solved: 2025/09/09 23:04:33 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #
import sys
input = sys.stdin.readline

N  = int(input())
A = []
for i in range(N):
    A.append((int(input()), i))

A.sort()
max = 0
for i in range(N):
    temp = A[i][1] - i
    if max < temp:
        max = temp

print(max + 1)

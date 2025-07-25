#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 10986                             :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/10986                          #+#        #+#      #+#     #
#    Solved: 2025/07/26 02:01:28 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
A = list(map(int, input().split()))

S = [0] * n
S[0] = A[0]

R = [0] * m
R[S[0] % m] += 1

for i in range(1, n):
    temp = S[i - 1] + A[i]
    S[i] = temp
    R[temp % m] += 1

count = 0
for i in range(m):
    if R[i] > 1:
        count += R[i] * (R[i] - 1) // 2

print(count + R[0])
#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 11660                             :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/11660                          #+#        #+#      #+#     #
#    Solved: 2025/07/26 01:38:36 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
A = [[0] * (n + 1)]
D = [[0] * (n + 1) for i in range(n + 1)]

for i in range(n):
    A_row = [0] + list(map(int, input().split()))
    A.append(A_row)

for i in range(1, n + 1):
    for j in range(1, n + 1):
        D[i][j] = D[i - 1][j] + D[i][j - 1] - D[i - 1][j - 1] + A[i][j]
        
for i in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    print(D[x2][y2] - D[x2][y1 - 1] - D[x1 - 1][y2] + D[x1 - 1][y1 - 1])
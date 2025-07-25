#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 11659                             :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/11659                          #+#        #+#      #+#     #
#    Solved: 2025/07/26 00:14:57 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
numbers = list(map(int, input().split()))
sum = [0]
temp = 0

for x in numbers:
    temp = temp + x
    sum.append(temp)

for x in range(M):
    i, j = map(int, input().split())
    print(sum[j] - sum[i - 1])
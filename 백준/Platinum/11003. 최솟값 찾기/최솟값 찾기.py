#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 11003                             :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/11003                          #+#        #+#      #+#     #
#    Solved: 2025/08/17 03:58:30 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #
import sys
from collections import deque
input = sys.stdin.readline

n, l = map(int, input().split())
d = deque()
num_list = list(map(int, input().split()))

for i in range(n):
    while d and d[-1][1] >= num_list[i]:
        d.pop()
    d.append((i, num_list[i]))
    
    if i - l >=  d[0][0]:
        d.popleft()
    
    print(d[0][1], end=' ')
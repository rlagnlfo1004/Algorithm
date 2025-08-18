#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 11286                             :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/11286                          #+#        #+#      #+#     #
#    Solved: 2025/08/19 02:14:51 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #
from queue import PriorityQueue
import sys
print = sys.stdout.write
input = sys.stdin.readline

N = int(input())
pq = PriorityQueue()

for i in range(N):
    x = int(input())
    if x == 0:
        if pq.empty():
            print('0\n')
        else:
            print(str(pq.get()[1]) + '\n')
    if x != 0:
        pq.put((abs(x), x))
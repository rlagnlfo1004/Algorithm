#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 2164                              :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/2164                           #+#        #+#      #+#     #
#    Solved: 2025/08/18 04:07:34 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #
from collections import deque

N = int(input())
dq = deque([i for i in range(1, N+1)])

while len(dq) > 1:
    dq.popleft()
    dq.append(dq.popleft())

print(dq[0])
#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 1697                              :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/1697                           #+#        #+#      #+#     #
#    Solved: 2025/08/10 16:25:30 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #
from collections import deque
N, K = map(int, input().split())
visited = [False] * 100001

def bfs(v):
    q = deque([(v, 0)]) # 시작점과 시간 0
    visited[v] = True
    
    while q:
        current, count = q.popleft()
        
        if current == K:
            return count
        
        # 인접 노드 탐색
        for next_pos in (current - 1, current + 1, current * 2):
            if 0 <= next_pos <= 100000 and not visited[next_pos]:
                visited[next_pos] = True
                q.append((next_pos, count + 1))

print(bfs(N))
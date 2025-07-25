#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 1546                              :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/1546                           #+#        #+#      #+#     #
#    Solved: 2025/07/25 18:46:50 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #
n = int(input())
scores = list(map(int, input().split()))
max_score = max(scores)
total_score = sum(scores)
print(total_score / max_score / n * 100)
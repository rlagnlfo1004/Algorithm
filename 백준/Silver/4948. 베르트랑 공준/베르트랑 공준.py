#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 4948                              :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/4948                           #+#        #+#      #+#     #
#    Solved: 2025/07/30 15:04:02 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #

# 에라토스테네스의 체 알고리즘

import math

arr = [True] * (123456 * 2 + 1)
arr[0] = False
arr[1] = False

for i in range(2, int(math.sqrt(123456 * 2)) + 1):
    if arr[i] == True:
        j = 2

        while i * j <= 123456 * 2 :
            arr[i * j] = False
            j += 1
    
    
while True:
    n = int(input())
    if n == 0:
        break
    
    print(arr[n + 1 : 2 * n+1].count(True))
#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 11399                             :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/11399                          #+#        #+#      #+#     #
#    Solved: 2025/07/15 09:31:08 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #
import sys
input = sys.stdin.readline

n = int(input())
num_arr = list(map(int, input().split()))
num_arr.sort()

sum = 0 
for num in num_arr:
    sum += num * n
    n -= 1
    
print(sum)
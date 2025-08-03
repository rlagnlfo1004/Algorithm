#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 2018                              :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/2018                           #+#        #+#      #+#     #
#    Solved: 2025/08/04 01:06:32 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #
n = int(input())
sum, count, start, end = 1, 1, 1, 1
while end != n:
    if sum > n:
        sum -= start
        start += 1
    elif sum == n:
        count += 1
        end += 1
        sum += end
    else:
        end += 1
        sum += end
        
print(count)
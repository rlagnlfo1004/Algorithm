#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 2750                              :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/2750                           #+#        #+#      #+#     #
#    Solved: 2025/09/09 22:49:18 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #
N = int(input())
arr = [0]*N
for i in range(N):
    arr[i] = int(input())

for i in range(1, N):
    for j in range(N - i):
        if arr[j] > arr[j + 1]:
            arr[j], arr[j + 1] = arr[j + 1], arr[j]

for i in range(N):
    print(arr[i])
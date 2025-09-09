#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 1427                              :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/1427                           #+#        #+#      #+#     #
#    Solved: 2025/09/09 23:37:55 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #
A = list(input())
len_A = len(A)

for i in range(len_A - 1):
    max = i
    for j in range(i + 1, len_A):
        if A[max] < A[j]:
            max = j
    A[i], A[max] = A[max], A[i]

for i in range(len_A):
    print(A[i], end='')
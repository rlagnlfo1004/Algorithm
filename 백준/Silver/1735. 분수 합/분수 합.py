#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 1735                              :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/1735                           #+#        #+#      #+#     #
#    Solved: 2025/07/26 23:14:59 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #
def GCD(x, y):
    while y:
        x, y = y, x % y
    return x

import sys
input = sys.stdin.readline

a1, b1 = map(int, input().split())
a2, b2 = map(int, input().split())

A = a1 * b2 + a2 * b1
B = b1 * b2
C = GCD(A, B)
print(A // C, B // C)
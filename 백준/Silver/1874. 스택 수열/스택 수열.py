#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 1874                              :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/1874                           #+#        #+#      #+#     #
#    Solved: 2025/08/18 02:44:47 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #
n = int(input())
A = [int(input()) for i in range(n)]

stack = []
num = 1
result = True
answer = ''

for i in range(0, n):
    
    while A[i] >= num:
        stack.append(num)
        num += 1
        answer += '+\n'
    
    if A[i] == stack[-1]:
        stack.pop()
        answer += '-\n'
        continue
        
    if A[i] < stack[-1]:
        result = False
        print('NO')
        break

if result:
    print(answer)
#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 11004                             :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/11004                          #+#        #+#      #+#     #
#    Solved: 2025/09/15 02:03:05 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #
import sys
input=sys.stdin.readline
N, K = map(int, input().split())
A = list(map(int, input().split()))

def quick_sort(S, E):
    global K
    pivot = partitions(S, E)
    if pivot == K:
        return A[pivot]
    elif pivot > K:
        return quick_sort(S, pivot-1)
    else:
        return quick_sort(pivot+1, E)

def partitions(S, E):
    global A
    
    if S+1 == E:
        if A[S] > A[E]:
            A[S], A[E] = A[E], A[S]
        return E
    
    M = (S+E)//2
    pivot = A[M]
    i, j = S+1, E
    
    A[M], A[S] = A[S], A[M]
    
    while i <= j:
        while pivot < A[j] and j > 0:
            j -= 1
        while pivot > A[i] and i <= E:
            i += 1
        if i <= j:
            A[i], A[j] = A[j], A[i]
            i += 1
            j -= 1
    
    A[S], A[j] = A[j], A[S]
    return j
        

K -= 1
print(quick_sort(0, N-1))
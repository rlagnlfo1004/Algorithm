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

def merge_sort(s,e):
    if s < e:
        m = (s+e) // 2
        merge_sort(s, m)
        merge_sort(m+1, e)
    
        return merge(s, e)

def merge(s, e):
    global arr
    
    m = (s+e) // 2
    temp_arr = []
    l_index, r_index = s, m+1
    
    while l_index <= m and r_index <= e:
        if arr[l_index] < arr[r_index]:
            temp_arr.append(arr[l_index])
            l_index += 1
        else:
            temp_arr.append(arr[r_index])
            r_index += 1
    
    while l_index <= m:
        temp_arr.append(arr[l_index])
        l_index += 1
    
    while r_index <= e:
        temp_arr.append(arr[r_index])
        r_index += 1
    
    arr[s:e+1] = temp_arr


merge_sort(0, N-1)
for i in range(N):
    print(arr[i])
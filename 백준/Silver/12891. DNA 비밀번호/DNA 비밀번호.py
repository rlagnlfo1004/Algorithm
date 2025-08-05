#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 12891                             :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/12891                          #+#        #+#      #+#     #
#    Solved: 2025/08/06 03:08:42 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #
import sys
input = sys.stdin.readline

def dna_to_num(dna):
    if dna == 'A':
        return 0
    elif dna == 'C':
        return 1
    elif dna == 'G':
        return 2
    elif dna == 'T':
        return 3

# global value
counter = 0
check_count = [0] * 4
my_count = [0] * 4

def my_add(dna):
    global counter, check_count, my_count
    
    c = dna_to_num(dna)
    my_count[c] += 1
    if my_count[c] == check_count[c]:
        counter += 1
        
        
def my_remove(dna):
    global counter, check_count, my_count
    
    c = dna_to_num(dna)
    if my_count[c] == check_count[c]:
        counter -= 1
        
    my_count[c] -= 1

len_s, len_p = map(int, input().split())
s = input()
check_count = list(map(int, input().split()))
result = 0

for i in check_count:
    if i == 0:
        counter += 1

for i in range(len_p):
    my_add(s[i])

if counter == 4:
    result += 1

for i in range(0, len_s - len_p):
    j = i + len_p
    my_remove(s[i])
    my_add(s[j])
    
    if counter == 4:
        result += 1

print(result)
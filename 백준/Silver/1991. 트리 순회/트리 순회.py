#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 1991                              :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/1991                           #+#        #+#      #+#     #
#    Solved: 2025/08/10 16:31:25 by hrkim2001     ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #
n = int(input())

tree = {}

for _ in range(n):
    node, left, right = map(str, input().split())
    tree[node] = [left, right]

def preorder(root):
    if root != '.':
        print(root, end='')      # root
        preorder(tree[root][0])  # left
        preorder(tree[root][1])  # right

def inorder(root):
    if root != '.':
        inorder(tree[root][0])   # left
        print(root, end='')      # root
        inorder(tree[root][1])   # right

def postorder(root):
    if root != '.':
        postorder(tree[root][0]) # left
        postorder(tree[root][1]) # right
        print(root, end='')      # root

preorder('A')
print()        # 줄바꿈 용도
inorder('A')
print()        # 줄바꿈 용도
postorder('A')
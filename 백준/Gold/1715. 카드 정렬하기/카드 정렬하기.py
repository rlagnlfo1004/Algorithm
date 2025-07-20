import sys, heapq

N = int(sys.stdin.readline())
cards = [int(sys.stdin.readline()) for i in range(N)]
heapq.heapify(cards)
cnt = 0

while len(cards) > 1:
    tmp = heapq.heappop(cards) + heapq.heappop(cards)
    heapq.heappush(cards, tmp)
    cnt += tmp
    
print(cnt)
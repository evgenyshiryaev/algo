import heapq

q = []

heapq.heappush(q, (0, 1))
heapq.heappush(q, (1, 2))
heapq.heappush(q, (0, 0))
print(len(q))

while q:
    print(heapq.heappop(q))

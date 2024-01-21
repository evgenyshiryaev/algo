from sortedcontainers import SortedList

sl = SortedList([5, 1, 6, 3, 1, 6, 7, 4, 5])
print(sl, len(sl))

print(sl.__contains__(1), sl.__contains__(2))

sl.remove(5)
print(sl)

print(sl.pop(0))
print(sl)

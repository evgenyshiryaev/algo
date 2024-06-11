from sortedcontainers import SortedDict

sd = SortedDict()
print(sd, len(sd))

sd[5] = 'abc'
sd[2] = 'cde'
print(sd, len(sd))

key0 = sd.keys()[0]
print(sd.pop(key0))
print(sd, len(sd))

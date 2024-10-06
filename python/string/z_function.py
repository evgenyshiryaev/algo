# http://e-maxx.ru/algo/z_function

# O(n) / O(n)
def z_function(s):
    z, l, r = [0] * len(s), 0, 0
    for i in range(1, len(s)):
        if i <= r:
            z[i] = min(r - i + 1, z[i - l])
        while i + z[i] < len(s) and s[z[i]] == s[i + z[i]]:
            z[i] += 1
        if i + z[i] - 1 > r:
            l = i
            r = i + z[i] - 1
    return z


# O(s + t) / O(s + t)
def find(s, t):
    if len(t) == 0:
        return []
    z, r = z_function(t + '#' + s), []
    for i in range(len(t) + 1, len(z) - len(t) + 1):
        if z[i] == len(t):
            r.append(i - len(t) - 1)
    return r


if __name__ == '__main__':
    assert [] == z_function('')
    assert [0] == z_function('a')
    assert [0, 0] == z_function('ab')
    assert [0, 1] == z_function('aa')
    assert [0, 4, 3, 2, 1] == z_function('aaaaa')
    assert [0, 0, 0, 3, 0, 0, 0] == z_function('abcabcd')
    assert [0, 1, 0, 2, 3, 1, 0] == z_function('aabaaab')

    assert [] == find('dummy', '')
    assert [0] == find('dummy', 'dum')
    assert [1] == find('dummy', 'um')
    assert [] == find('dummy', 'umy')
    assert [3] == find('dummy', 'my')
    assert [2, 3] == find('dummy', 'm')
    assert [3] == find('SuperLongString', 'erLo')
    assert [6] == find('SuperLongString', 'ong')
    assert [] == find('SuperLongString', 'long')
    assert [1, 7, 12] == find('aabcabdabcbcabcc', 'abc')

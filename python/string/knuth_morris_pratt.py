# http://e-maxx.ru/algo/prefix_function


# O(n) / O(n)
def prefix_function(s):
    r = [0] * len(s)
    for i in range(1, len(s)):
        j = r[i - 1]
        while j and s[i] != s[j]:
            j = r[j - 1]
        j += s[i] == s[j]
        r[i] = j
    return r


# O(s + t) / O(s + t)
def find(s, t):
    if len(t) == 0:
        return []
    p, r = prefix_function(t + '#' + s), []
    for i in range(len(s) - len(t) + 1):
        j = i + 2 * len(t)
        if p[j] == len(t):
            r.append(i)
    return r


if __name__ == '__main__':
    assert [] == prefix_function('')
    assert [0] == prefix_function('a')
    assert [0, 0] == prefix_function('ab')
    assert [0, 1] == prefix_function('aa')
    assert [0, 0, 0, 1, 2, 3, 0] == prefix_function('abcabcd')
    assert [0, 1, 0, 1, 2, 2, 3] == prefix_function('aabaaab')

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

def right_gt(a):
    A = len(a)
    r, s, si = [None] * A, [None] * A, 0
    for i in range(A):  # range(A - 1, -1, -1) if left
        while si and a[i] > a[s[si - 1]]:  # >= if ge, < if lt
            si -= 1
            r[s[si]] = i
        s[si] = i
        si += 1
    return r


if __name__ == '__main__':
    _a = [10, 1, 6, 2, 4, 1, 4, 9]
    assert [None, 2, 7, 4, 7, 6, 7, None] == right_gt(_a)

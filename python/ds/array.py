# use list(zip(*reversed(a)))
def rotate_right(a0):
    Y0, X0 = len(a0), len(a0[0])
    Y1, X1 = X0, Y0
    a1 = [[0] * X1 for _ in range(Y1)]
    for y0 in range(Y0):
        for x0 in range(X0):
            a1[x0][X1 - 1 - y0] = a0[y0][x0]
    return a1


def prefix_sum_1d(a):
    X = len(a)
    ps = [0] * (X + 1)
    for x in range(X):
        ps[x + 1] = ps[x] + a[x]
    return ps


def prefix_sum_2d_hor(a):
    Y, X = len(a), len(a[0])
    ps = [[0] * (X + 1) for _ in range(Y)]
    for y in range(Y):
        for x in range(X):
            ps[y][x + 1] = ps[y][x] + a[y][x]
    return ps


def prefix_sum_2d_ver(a):
    Y, X = len(a), len(a[0])
    ps = [[0] * X for _ in range(Y + 1)]
    for y in range(Y):
        for x in range(X):
            ps[y + 1][x] = ps[y][x] + a[y][x]
    return ps


# 0 0 0 0
# a b c 0
# d e f 0
def prefix_sum_2d_diag_up_0(a):
    Y, X = len(a), len(a[0])
    ps = [[0] * (X + 1) for _ in range(Y + 1)]
    for y in range(Y):
        for x in range(X):
            ps[y + 1][x] = ps[y][x + 1] + a[y][x]
    return ps


# i = y + x
# prefer Y < X
def prefix_sum_2d_diag_up_1(a):
    Y, X = len(a), len(a[0])
    ps = [[0] * (Y + 1) for _ in range(Y + X - 1)]
    for y in range(Y):
        for x in range(X):
            i = y + x
            ps[i][y + 1] = ps[i][y] + a[y][x]
    return ps


if __name__ == '__main__':
    _a = [[0, 1, 2],
          [3, 4, 5]]

    assert [[3, 0],
            [4, 1],
            [5, 2]] == rotate_right(_a)
    assert [(3, 0),
            (4, 1),
            (5, 2)] == list(zip(*reversed(_a)))

    assert [0, 0, 1, 3] == prefix_sum_1d(_a[0])
    assert [[0, 0, 1, 3],
            [0, 3, 7, 12]] == prefix_sum_2d_hor(_a)
    assert [[0, 0, 0],
            [0, 1, 2],
            [3, 5, 7]] == prefix_sum_2d_ver(_a)

    assert [[0, 0, 0, 0],
            [0, 1, 2, 0],
            [4, 6, 5, 0]] == prefix_sum_2d_diag_up_0(_a)
    assert [[0, 0, 0],
            [0, 1, 4],
            [0, 2, 6],
            [0, 0, 5]] == prefix_sum_2d_diag_up_1(_a)

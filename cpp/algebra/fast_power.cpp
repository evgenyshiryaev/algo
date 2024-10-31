int fast_power(long long a, int b, int div) {
    long long r = 1;
    while (b) {
        if (b & 1) r = (r * a) % div;
        a = (a * a) % div;
        b >>= 1;
    }
    return (int)r;
}

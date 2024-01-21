package algo.utils;

import java.util.Objects;

public class IntTriple {

    public int a;
    public int b;
    public int c;

    public IntTriple(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    @Override
    public boolean equals(Object other) {
        return other != null && (other instanceof IntTriple)
                && (a == ((IntTriple)other).a) && (b == ((IntTriple)other).b) && (c == ((IntTriple)other).c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d,%d)", a, b, c);
    }

}

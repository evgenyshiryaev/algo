package algo.utils;

import java.util.Objects;

public class IntPair {

    public int a;
    public int b;

    public IntPair(int a, int b) {
        this.a = a;
        this.b = b;
    }


    @Override
    public boolean equals(Object other) {
        return other != null && (other instanceof IntPair)
                && (a == ((IntPair)other).a) && (b == ((IntPair)other).b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", a, b);
    }

}

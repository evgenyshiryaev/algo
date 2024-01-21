package algo.utils;

import java.util.Objects;


/**
 * Generic pair.
 * @param <A> first value type
 * @param <B> second value type
 */
public class Pair<A, B> {

    public A a;
    public B b;


    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }


    @Override
    public boolean equals(Object other) {
        return other != null && (other instanceof Pair)
                && a.equals(((Pair<?, ?>)other).a) && b.equals(((Pair<?, ?>)other).b);
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

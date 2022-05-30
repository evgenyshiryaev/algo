package algo.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DisjointSetTest {

    @Test
    public void test() {
        DisjointSet set = new DisjointSet(5);

        for (int i = 0; i < 5; ++ i) {
            Assertions.assertEquals(i, set.find(i));
        }

        set.union(1, 3);
        set.union(2, 4);

        Assertions.assertTrue(set.connected(1, 3));
        Assertions.assertTrue(set.connected(2, 4));
        Assertions.assertFalse(set.connected(1, 2));
        Assertions.assertFalse(set.connected(0, 1));
        Assertions.assertFalse(set.connected(0, 2));

        set.union(0, 3);

        Assertions.assertTrue(set.connected(1, 3));
        Assertions.assertTrue(set.connected(2, 4));
        Assertions.assertFalse(set.connected(1, 2));
        Assertions.assertTrue(set.connected(0, 1));
        Assertions.assertFalse(set.connected(0, 2));

        set.union(1, 2);

        Assertions.assertTrue(set.connected(0, 1));
        Assertions.assertTrue(set.connected(1, 2));
        Assertions.assertTrue(set.connected(2, 3));
        Assertions.assertTrue(set.connected(3, 4));
        Assertions.assertTrue(set.connected(4, 0));
    }

}

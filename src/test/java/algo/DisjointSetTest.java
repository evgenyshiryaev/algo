package algo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DisjointSetTest {

    @Test
    public void test() {
        DisjointSet set = new DisjointSet(5);

        for (int i = 1; i <= 5; ++ i) {
            Assertions.assertEquals(i, set.find(i));
            Assertions.assertEquals(1, set.getSize(i));
        }

        set.union(1, 3);
        set.union(2, 4);

        Assertions.assertTrue(set.find(1) == set.find(3));
        Assertions.assertTrue(set.find(2) == set.find(4));
        Assertions.assertFalse(set.find(1) == set.find(2));
        Assertions.assertFalse(set.find(1) == set.find(5));
        Assertions.assertFalse(set.find(2) == set.find(5));
        Assertions.assertEquals(2, set.getSize(1));
        Assertions.assertEquals(2, set.getSize(2));
        Assertions.assertEquals(2, set.getSize(3));
        Assertions.assertEquals(2, set.getSize(4));
        Assertions.assertEquals(1, set.getSize(5));

        set.union(3, 5);

        Assertions.assertTrue(set.find(1) == set.find(3));
        Assertions.assertTrue(set.find(2) == set.find(4));
        Assertions.assertFalse(set.find(1) == set.find(2));
        Assertions.assertTrue(set.find(1) == set.find(5));
        Assertions.assertFalse(set.find(2) == set.find(5));
        Assertions.assertEquals(3, set.getSize(1));
        Assertions.assertEquals(2, set.getSize(2));
        Assertions.assertEquals(3, set.getSize(3));
        Assertions.assertEquals(2, set.getSize(4));
        Assertions.assertEquals(3, set.getSize(5));

        set.union(1, 2);

        Assertions.assertTrue(set.find(1) == set.find(2));
        Assertions.assertTrue(set.find(2) == set.find(3));
        Assertions.assertTrue(set.find(3) == set.find(4));
        Assertions.assertTrue(set.find(4) == set.find(5));
        Assertions.assertEquals(5, set.getSize(1));
        Assertions.assertEquals(5, set.getSize(2));
        Assertions.assertEquals(5, set.getSize(3));
        Assertions.assertEquals(5, set.getSize(4));
        Assertions.assertEquals(5, set.getSize(5));
    }

}

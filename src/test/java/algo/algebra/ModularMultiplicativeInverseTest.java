package algo.algebra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModularMultiplicativeInverseTest {

    @Test
    public void euclidMMITest() {
        Assertions.assertEquals(2, ModularMultiplicativeInverse.euclidMMI(5, 9));
        Assertions.assertEquals(5, ModularMultiplicativeInverse.euclidMMI(7, 17));
    }


    @Test
    public void divideModTest() {
        Assertions.assertEquals(14, ModularMultiplicativeInverse.euclidMMI(5, 23));
        Assertions.assertEquals(2, ModularMultiplicativeInverse.divideMod(10, 5, 23));
        Assertions.assertEquals(5, ModularMultiplicativeInverse.divideMod(20, 4, 23));
    }

}

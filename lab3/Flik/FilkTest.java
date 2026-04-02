import static org.junit.Assert.*;

import org.junit.Test;

public class FilkTest {

    @Test
    public void testBoundary(){
        assertTrue(Flik.isSameNumber(0,0));
        assertTrue(Flik.isSameNumber(499, 499));
        assertTrue(Flik.isSameNumber(500, 500));
    }

    @Test
    public void testMiddle() {
        assertTrue(Flik.isSameNumber(127, 127));
        assertTrue(Flik.isSameNumber(128, 128));
    }
}

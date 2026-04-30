import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    @Test
    public void testEqualChars() {

        OffByN offBy5 = new OffByN(5);
        assertTrue(offBy5.equalChars('a', 'f'));  // true
        assertTrue(offBy5.equalChars('f', 'a'));
        assertFalse(offBy5.equalChars('f', 'h'));

        OffByN offBy1 = new OffByN(1);
        assertTrue(offBy1.equalChars('a', 'b'));
        assertTrue(offBy1.equalChars('&', '%'));
        assertFalse(offBy1.equalChars('a', 'c'));
        assertFalse(offBy1.equalChars('c', 'a'));

        OffByN offByNegative = new OffByN(-1);
        assertTrue(offByNegative.equalChars('a', 'b'));

        OffByN offBy0 = new OffByN(0);
        assertTrue(offBy0.equalChars('a', 'a'));
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests of MathUtils.average
 * 
 * @author Tessa Ter
 * @author Jay Unit
 */
class AverageTest {

  @Test
  void testBasic() {
    assertEquals(11, MathUtils.average(new long[] {10,11,12}));
  }
  
  @Test
  void testSimpleOverflow() {
    long val = (Long.MAX_VALUE / 2) + 3;
    assertEquals(val, MathUtils.average(new long[] { val, val }));
    assertEquals(val, MathUtils.average(new long[] { val, val, val }));
  }

} // class AverageTest

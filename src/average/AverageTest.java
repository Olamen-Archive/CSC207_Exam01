package average;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigInteger;
import java.util.Random;
import org.junit.jupiter.api.Test;

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
  
  @Test
  void testSimpleUnderflow() {
    long val = (Long.MIN_VALUE / 2) - 3;
    assertEquals(val, MathUtils.average(new long[] { val, val, val}));
    assertEquals(val, MathUtils.average(new long[] { val, val, val}));
  }
  
  @Test
  void testAllZero() {
    for (int i = 1; i < 100; i++) {
      long[] arr = new long[i];
      /* Initialize array */
      for (int j = 0; j < arr.length; j++) {
        arr[j] = 0;
      }
      assertEquals(0, MathUtils.average(arr)); //test
    }
  }
  
  @Test
  void testRandomArr() {
    Random rand = new Random();
    for (int i = 1; i < 100; i++) {
      long[] arr = new long[i];
      /* Initialize array */
      for (int j = 0; j < arr.length; j++) {
        arr[j] = rand.nextLong();
      }
      assertEquals(bigAverage(arr), MathUtils.average(arr));
    }
  }
  
  private static long bigAverage(long[] values) {
    if (values.length == 0) return 0;
    BigInteger sum = BigInteger.valueOf(0);
    for (long val : values) {
      sum = sum.add(BigInteger.valueOf(val));
    }
    BigInteger average = sum.divide(BigInteger.valueOf(values.length));
    System.out.println(average.toString());
    return average.longValue();
  }
} // class AverageTest
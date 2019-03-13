package average;

import java.math.BigInteger;

/**
 * A simple set of utilities.
 * 
 * @author Ava Ridge
 * @author Your Name
 */
public class MathUtils {
  /**
   * Compute the average of an array of long values.
   */
  public static long average(long[] values) {
    long sum = 0;
    for (long val :values) {
      sum += val;
    } // for
    return sum/values.length;
  } // average(long[])

  public static long bigAverage(long[] values) {
    BigInteger sum = BigInteger.valueOf(0);
    for (long val : values) {
      sum.add(BigInteger.valueOf(val));
    }
    BigInteger average = sum.divide(BigInteger.valueOf(values.length));
    return average.longValue();
  }
} // class MathUtils

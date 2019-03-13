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
} // class MathUtils

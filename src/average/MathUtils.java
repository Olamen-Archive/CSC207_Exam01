package average;

import java.math.BigInteger;

/**
 * A simple set of utilities.
 * 
 * @author Ava Ridge
 * @author Zixuan Guo
 */
public class MathUtils {
  public static long average(long[] arr) {
    if (arr.length == 0) return 0;
    long divideSum = 0;
    long modSum = 0;
    final long size = arr.length;
    
    for (int i = 0; i < arr.length; i++) {
      divideSum += arr[i] / size;
      modSum += arr[i] % size;
    }

    return divideSum - (size - 1) + (modSum + size * (size - 1)) / size;
  }
}

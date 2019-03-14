package average;

import java.math.BigInteger;

/**
 * A simple set of utilities.
 * 
 * @author Ava Ridge
 * @author Your Name
 */
public class MathUtils {
//  public static long average(long[] array) {
//    long average = 0;
//    int t = 1;
//    for (long num : array) {
//      average += (num - average) / t + (num % t - average % t) / t;
//      t += 1;
//    }
//    return average;
//  }
  
  public static long average(long[] arr) {
    if (arr.length == 0) return 0;
    long divideSum = 0;
    long modSum = 0;
    final long size = arr.length;
    
    for (int i = 0; i < arr.length; i++) {
      divideSum += arr[i] / size;
      modSum += arr[i] % size;
    }
    
    long average = divideSum + (modSum + (size - 1) * size) / size - (size - 1);
    return average;
  }
}

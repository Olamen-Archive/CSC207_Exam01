package average;

import java.math.BigInteger;

public class AverageBak {
  public static long getAverage(long[] array) {
    long sum = 0;
    for (long num : array) {
      sum += num;
    }
    
    return sum / array.length;
  }
  
  public static long absoluteAverage(long[] array) {
    BigInteger sum = new BigInteger("0");
    for (long num : array) {
      System.out.println(BigInteger.valueOf(num).toString());
      sum.add(BigInteger.valueOf(num));
    }
    System.out.println(sum.toString());
    return sum.divide(BigInteger.valueOf(array.length)).longValue();
  }

  public static long myAverage(long[] array) {
    long average = 0;
    int  t = 1;
    for (long num : array) {
      average += (num - average) / t;
      t += 1;
    }

    return average;
  }
  
  public static String printArray(long[] array) {
    StringBuilder str = new StringBuilder();
    str.append("[");
    for (int i = 0; i < array.length; i++) {
      str.append(array[i]);
      if (i < array.length - 1) {
        str.append(", ");
      }
    }
    str.append("]");
    return str.toString();
  }
}

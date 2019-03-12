//package average;
//
//public class AverageTest {
//
//  @Test
//  void overflow() {
//    for (int i = 1; i < 10; i++) {
//      long[] numArray = new long[i]; // creating array with i numebers;
//      for (int j = 0; j < numArray.length; j++) {
//        numArray[j] = Long.MAX_VALUE;
//      }
//      assertEquals(Long.MAX_VALUE, Average.absoluteAverage(numArray),
//          Average.printArray(numArray) + " fails the test");
//    }
//  }
//
//  @Test
//  void underflow() {
//    for (int i = 1; i < 10; i++) {
//      long[] numArray = new long[i]; // creating array with i numebers;
//      for (int j = 0; j < numArray.length; j++) {
//        numArray[j] = Long.MIN_VALUE;
//      }
//      assertEquals(Long.MIN_VALUE, Average.absoluteAverage(numArray),
//          Average.printArray(numArray) + " fails the test");
//    }
//  }
//
//}

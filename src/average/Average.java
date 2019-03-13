import java.io.PrintWriter;
import java.util.Arrays;

/**
 * A simple command-line program to average long values.
 */
public class Average {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    long[] values = new long[args.length];
    for (int i = 0; i < args.length; i++) {
      values[i] = Long.parseLong(args[i]);
    } // for
    pen.println("average(" + Arrays.toString(values) + ") = " +
        MathUtils.average(values));
  } // main(String[])
} // Average

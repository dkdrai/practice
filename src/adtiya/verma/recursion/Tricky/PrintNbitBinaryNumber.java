package adtiya.verma.recursion.Tricky;

/*Given a positive integer n, print all n-bit binary numbers having more 1’s than 0’s for any prefix of the number.

    Examples:

    Input : n = 2
    Output : 11 10

    Input : n = 4
    Output : 1111 1110 1101 1100 1011 1010*/
public class PrintNbitBinaryNumber {

  public static void main(String ar[]) {
    printNumber("", 0, 4);
    System.out.println("other approach");
    printBinary("", 0, 0, 4);
  }

  private static void printNumber(String s, int ones, int n) {
    if (n == 0) {
      System.out.println(s);
      return;
    }
    printNumber(s.concat("1"), ones + 1, n - 1);
    if (ones > 0) {
      printNumber(s.concat("0"), ones - 1, n - 1);
    }
  }

  private static void printBinary(String s, int ones, int zeros, int n) {
    if (n == 0) {
      System.out.println(s);
      return;
    }
    printBinary(s.concat("1"), ones + 1, zeros, n - 1);
    if (ones > zeros) {
      printBinary(s.concat("0"), ones, zeros + 1, n - 1);
    }
  }
}

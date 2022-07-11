package neetcode.subsets;

public class AllSubsetOfString {

  public static void main(String ar[]) {
    allSubset("", "abc", 0);
  }

  public static void allSubset(String output, String input, int n) {
    if (n == input.length()) {
      System.out.println(output);
      return;
    }
    allSubset(output, input, n + 1);
    allSubset(output + "" + (input.substring(n, n + 1)), input, n + 1);
  }
}

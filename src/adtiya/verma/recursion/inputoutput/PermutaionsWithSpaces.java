package adtiya.verma.recursion.inputoutput;

public class PermutaionsWithSpaces {

  public static void main(String ar[]) {
    String input = "abc";
    String outPut = "" + input.charAt(0);
    input = input.substring(1);
    permutations(outPut, input);
  }

  private static void permutations(String output, String input) {
    if (input.length() == 0) {
      System.out.println(output);
      return;
    }
    permutations(output + "" + (input.charAt(0)), input.substring(1));
    permutations(output + " " + (input.charAt(0)), input.substring(1));
  }
}

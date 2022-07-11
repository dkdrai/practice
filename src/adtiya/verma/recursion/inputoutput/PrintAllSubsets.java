package adtiya.verma.recursion.inputoutput;


public class PrintAllSubsets {

  public static void main(String[] args) {
    printSubset("aab", "");
  }

  public static void printSubset(String input, String output) {
    if (input.length() == 0) {
      System.out.println(output);
      return;
    }
    String output1 = output.concat(String.valueOf(input.charAt(0)));
    input = input.substring(1);
    printSubset(input, output);
    printSubset(input, output1);
  }



}

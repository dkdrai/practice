package adtiya.verma.recursion.inputoutput;

import java.util.HashMap;

public class PrintAllUniqueSubsets {

  public static void main(String[] args) {
    printSubset("aab", " ", new HashMap<>());
  }

  public static void printSubset(String input, String output, HashMap<String, String> map) {
    if (input.length() == 0) {
      if(!map.containsKey(output)){
        map.put(output, output);
        System.out.println(output);
      }
      return;
    }
    String output1 = output.concat(String.valueOf(input.charAt(0)));
    input = input.substring(1);
    printSubset(input, output, map);
    printSubset(input, output1, map);
  }

}

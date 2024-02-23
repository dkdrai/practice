package educative.solution.grokkingcodinginterviewpatterns.slidingwindow;

import java.util.*;

public class FindRepeatedSequences{

   public static void main(String[] args) {
      String s  = "AGCTGAAAGCTTAGCTG";
      int k = 3;
      System.out.println(findRepeatedSequences(s, k));
   }
   public static Set<String> findRepeatedSequences(String s, int k) {
   if(k > s.length())
   return new HashSet<>();
    Set<String> set = new HashSet<>();
    Set<String> result = new HashSet<>();
   int left = 0;
   int right = k-1;
   while(right < s.length()){
      String current = s.substring(left, right+1);
      if(set.contains(current)){
         result.add(current);
      }else{
         set.add(current);
      }
      left ++;
      right ++;
   }
    
    return result;
   }
}
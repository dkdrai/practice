package educative.solution.grokkingdp.longestcommonsubstring.recursion;

import java.util.*;
import java.util.stream.*;

class MinEditDistance
{

    // O(3^n)
  public static int minEditDistRecursive(String str1, String str2, int m, int n)
  {
      // If first string is empty, the only option is to
      // insert all characters of second string into first
      if (m == 0)
        return n;

      // If second string is empty, the only option is to
      // remove all characters of first string
      if (n == 0)
        return m;

      // If last characters of two strings are same, nothing
      // much to do. Ignore last characters and get count for
      // remaining strings.
      if (str1.charAt(m - 1) == str2.charAt(n - 1))
        return minEditDistRecursive(str1, str2, m - 1, n - 1);

      // If last characters are not same, consider all three
      // operations on last character of first string, recursively
      // compute minimum cost for all three operations and take
      // minimum of three values.
      return 1 + Math.min(Math.min(minEditDistRecursive(str1, str2, m, n - 1),  // Insert
                    minEditDistRecursive(str1, str2, m - 1, n)),  // Remove
                    minEditDistRecursive(str1, str2, m - 1, n - 1)  // Replace
                    );

  }
  public static int minEditDist(String str1, String str2)
  {
      return minEditDistRecursive(str1, str2, str1.length(), str2.length());
  }

  // Driver code to test the above function
  public static void main(String[] args)
  {

      ArrayList <String> str1List = new ArrayList<String>(){{add("sunday"); add("sam"); add("110011010110001"); add("cat"); add("ball");}};
      ArrayList <String> str2List = new ArrayList<String>(){{add("saturday"); add("samson"); add("1100101111110010"); add("cut"); add("baller");}};
      
      // You can uncomment the lines below and check how this recursive solution causes a time-out 
      
      // str1List.add("iaetnxijfofxwnzfitssulvepiengehcaibfaorvraugndnurjfgixjljuibiaetnxijfofxwnzfitssulvepiengehcaibfaorvraugndnurjfgixjljuib");
      // str2List.add("raetnsijfoyxwnzcitssolveppengeqcaibnaorveaugnvnurjmgixjljuibabcdraetnsijfoyxwnzcitssolveppengeqcaibnaorveaugnvnurjmgixjljuib");

      for(int i = 0; i < str1List.size(); i++)
      {
          System.out.println(i+1 + ".\tstr1: " + str1List.get(i));
          System.out.println("\tstr2: " + str2List.get(i));
          System.out.println("\n\tMinimum Edit Distance: " + minEditDist(str1List.get(i), str2List.get(i)));
          Stream.generate(() -> "-").limit(100).forEach(System.out::print);
          System.out.println();
      }
    
  }
}
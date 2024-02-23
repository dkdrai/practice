package educative.solution.grokkingdp.longestcommonsubstring.dp;

import java.util.*;
import java.util.stream.*;

class MinNumDelIns

{
    // O(n^2)
    // function to find the maximum number of matching characters subsequence
    public static int findMaxMatchingSubseq(String str1, String str2, int i, int j, int [][] lookupTable)
    { 

        // base case
        if (i == str1.length() || j == str2.length()) 
            return 0;

        // if the subproblem has been computed before, return the value stored in lookupTable
        else if (lookupTable[i][j] != -1) 
            return lookupTable[i][j];

        // if current characters match, increment by 1
        else if (str1.charAt(i) == str2.charAt(j))
        {  
            lookupTable[i][j] = 1 + findMaxMatchingSubseq(str1, str2, i + 1, j + 1, lookupTable);
            return lookupTable[i][j];
        }

        // else take max of either of two possibilities
        lookupTable[i][j] = Math.max(findMaxMatchingSubseq(str1, str2, i + 1, j, lookupTable), findMaxMatchingSubseq(str1, str2, i, j + 1, lookupTable));
        return lookupTable[i][j];
    }
    public static int[] minDelIns(String str1, String str2)
    {
        // Declare a lookupTable array which stores the answer to recursive calls  
        int [][]lookupTable=new int[str1.length()][str2.length()];
            for (int i = 0; i < str1.length(); i++)
                Arrays.fill(lookupTable[i], -1);

        int n = findMaxMatchingSubseq(str1, str2,0,0,lookupTable);
        // calculating number of deletions required from str1 to transform it into str2
        int deletions = str1.length() - n;
        // calculating number of insertions required in str1 to transform it into str2
        int insertions = str2.length() - n;
        
        return new int[]{deletions, insertions};
    }

   // Driver code to test the above function
    public static void main(String[] args)
    {
        List<String> str1List = new ArrayList<String>(Arrays.asList("pqr", "heap", "passport", "baller", "sam", "bed"));

        List <String> str2List = new ArrayList<String>(Arrays.asList("tqr", "pea", "ppsspt", "ball", "samson", "read"));
      
        // Let's uncomment this and check the effect of dynamic programming using memoization
        // str1List.add("sjcneiurutvmpdkapbrcapjru");
        // str2List.add("oidhfwepkxwebyurtunvidqlscmjbg");

        for(int i = 0; i < str1List.size(); i++)
        {
            System.out.println(i + 1 + ".\tstr1: " + str1List.get(i));
            System.out.println("\tstr2: " + str2List.get(i));
            int[] output = minDelIns(str1List.get(i), str2List.get(i));
            System.out.println("\n\tMinimum deletions required:  " + output[0]);
            System.out.println("\tMinimum insertions required: " + output[1]);
            Stream.generate(() -> "-").limit(100).forEach(System.out::print);
            System.out.println();
        }

    } 
} 
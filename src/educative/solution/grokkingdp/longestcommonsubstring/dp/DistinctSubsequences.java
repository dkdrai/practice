package educative.solution.grokkingdp.longestcommonsubstring.dp;

import java.util.*;
import java.util.stream.*;

class DistinctSubsequences {
    // helper recursive function
    public static long numberOfSubsequencesRec(String str1, String str2, int m, int n, int i1, int i2, long[][] lookupTable) {
        // if we have reached the end of str1, return 1
        if (i2 == n) {
            return 1;
        }

        // if we have reached the end of str2, return 0
        if (i1 == m) {
            return 0;
        }

        // if the result is not present in the lookup table
        if (lookupTable[i1][i2] == -1) {
            // if both the characters are same
            if (str1.charAt(i1) == str2.charAt(i2)) {
                lookupTable[i1][i2] = numberOfSubsequencesRec(str1, str2, m, n, i1 + 1, i2 + 1, lookupTable);
                lookupTable[i1][i2] += numberOfSubsequencesRec(str1, str2, m, n, i1 + 1, i2, lookupTable);    // ignoring this match
            } else {
                // if both the characters are different
                lookupTable[i1][i2] = numberOfSubsequencesRec(str1, str2, m, n, i1 + 1, i2, lookupTable);
            }
        }

        // return the result stored in the lookup table
        return lookupTable[i1][i2];
    }

    public static long numberOfSubsequences(String str1, String str2) {
        // initializing variables
        int m = str1.length();
        int n = str2.length();
        
        // initializing lookup table to store the results of recursive calls
        long[][] lookupTable = new long[str1.length()][str2.length()];
        for(long[] row: lookupTable){
            Arrays.fill(row, -1);
        }
        
        // calling the helper recursive function
        long numSubsequences = numberOfSubsequencesRec(str1, str2, m, n, 0, 0, lookupTable);

        // returning the resuls
        return numSubsequences;
    }

    // driver code
    public static void main(String[] arg) {
        String[] input1Strings = {"bbagbag", "dawawg", "programming", "googlegoogle", "wowowl"};
        String[] input2Strings = {"bag", "aw", "ram", "gogl", "owl"};

        // let's uncomment this and check the effect of dynamic programming using memoization
        
        // String newArr[] = Arrays.copyOf(input1Strings, input1Strings.length + 1);
        // newArr[input1Strings.length] = "ababababababababababababababababababababababababababababababababababababababababababab";
        // input1Strings = newArr;
        // newArr = Arrays.copyOf(input2Strings, input2Strings.length + 1);
        // newArr[input2Strings.length] = "abababababababababababababababab";
        // input2Strings = newArr;

        for (int i = 0; i < input1Strings.length; i++) {
            System.out.print(i + 1);
            System.out.println("\tString 1: " + input1Strings[i]);
            System.out.println("\tString 2: " + input2Strings[i]);
            System.out.println("\n\tNumber of distinct subsequences: " + numberOfSubsequences(input1Strings[i], input2Strings[i]));
            Stream.generate(() -> "-").limit(100).forEach(System.out::print);
            System.out.println();
        }
    }
}
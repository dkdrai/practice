package educative.solution.grokkingdp.longestcommonsubstring.recursion;

import java.util.stream.*;

class DistinctSubsequences {
    // helper recursive function
    public static int numberOfSubsequencesRec(String str1, String str2, int m, int n, int i1, int i2) {
        // if we have reached the end of str1, return 1
        if (i2 == n) {
            return 1;
        }

        // if we have reached the end of str2, return 0
        if (i1 == m) {
            return 0;
        }

        // initializing result variable to store the number of subsequences
        int result = 0;

        // if both the characters are same
        if (str1.charAt(i1) == str2.charAt(i2)) {
            result += numberOfSubsequencesRec(str1, str2, m, n, i1 + 1, i2 + 1);
            result += numberOfSubsequencesRec(str1, str2, m, n, i1 + 1, i2);     // ignoring this match
        } else {
            // if both the characters are different
            result += numberOfSubsequencesRec(str1, str2, m, n, i1 + 1, i2);
        }

        // return the number of subsequences
        return result;
    }

    public static int numberOfSubsequences(String str1, String str2) {
        // initializing variables
        int m = str1.length();
        int n = str2.length();

        // calling the helper recursive function
        int numSubsequences = numberOfSubsequencesRec(str1, str2, m, n, 0, 0);

        // returning the resuls
        return numSubsequences;
    }

    // driver code
    public static void main(String[] arg) {
        String[] input1Strings = {"bbagbag", "dawawg", "programming", "googlegoogle", "wowowl"};
        String[] input2Strings = {"bag", "aw", "ram", "gogl", "owl"};

        // you can uncomment the lines below and check how this recursive solution causes a time-out
        
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
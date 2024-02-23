package educative.solution.grokkingdp.longestcommonsubstring.recursion;

import java.util.stream.*;

public class LongestCommonSubstring {

    // O(3 ^ (m+n))
    public static int lcsLengthRec(String s1, String s2, int i, int j, int count) {
        // base case of when either string has been exhausted
        if (i >= s1.length() || j >= s2.length()) {
            return count;
        }
        // if i and j characters match, increment the count and compare the rest of the strings
        if (s1.charAt(i) == s2.charAt(j)) {
            count = lcsLengthRec(s1, s2, i + 1, j + 1, count + 1);
        }
        // compare s1[i:] with s2, s1 with s2[j:], and take max of current count and these two results
        return Math.max(count, Math.max(lcsLengthRec(s1, s2, i + 1, j, 0), lcsLengthRec(s1, s2, i, j + 1, 0)));
    }

    public static int lcsLength(String s1, String s2) {
        return lcsLengthRec(s1, s2, 0, 0, 0);
    }

    // Driver code
    public static void main(String[] args) {
        String[] s1 = {
            "educative",
            "bcdcdcd",
            "arefun",
            "yourocks",
            "abc"
        };
        String[] s2 = {
            "education",
            "aacdcdcd",
            "isfun",
            "youawesome",
            "def"
        };

        // You can uncomment the lines below and check how this recursive solution causes a time-out 
        // String temp1[] = Arrays.copyOf(s1, s1.length + 1); 
        // temp1[s1.length] = "ypzrvyigwdiqrnbglvviozqzruvmwivgvqvrfhqi";
        // s1 = temp1;

        // String temp2[] = Arrays.copyOf(s2, s2.length + 1); 
        // temp2[s2.length] = "wdiqrnbglvviozqzruvmwivgvqvrfhqiypzrvyigwdiqrn";
        // s2 = temp2;

        for (int i = 0; i < s1.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput string 1: \"" + s1[i] + "\"");
            System.out.println("\tInput string 2: \"" + s2[i] + "\"");
            System.out.println("\n\tThe Length of Longest Common Substring is: " + lcsLength(s1[i], s2[i]));
            Stream.generate(() -> "-").limit(100).forEach(System.out::print);
            System.out.println();
        }

    }

}
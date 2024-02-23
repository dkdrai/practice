package educative.solution.grokkingdp.longestcommonsubstring.dp;

import java.util.*;

public class InterleavingStrings {

//O(s×t)
public static boolean isInterleaving(String s1, String s2, String s3) {
        HashMap < String, Boolean > table = new HashMap < String, Boolean > ();
        return findStringsInterleavingRecursive(s1, s2, s3, 0, 0, 0, table);
    }

    public static boolean findStringsInterleavingRecursive(String s1, String s2, String s3, int s1Index, int s2Index, int s3Index, HashMap < String, Boolean > table) {


        // If we have reached the end of all the strings
        if ((s1Index == s1.length()) && (s2Index == s2.length()) && (s3Index == s3.length())) {
            return true;
        }

        // If we have reached the end of 's3' but 's1' or 's2' still has some characters left
        if (s3Index == s3.length()) {
            return false;
        }

        // Setting up the key for this subproblem
        String subProblem = s1Index + "/" + s2Index + "/" + s3Index;

        boolean d1 = true;
        boolean d2 = true;
        // Checking if the sub problem is already solved
        if (!table.containsKey(subProblem)) {

            // The two decisions we can make at every instance are initially set to false
            d1 = false;
            d2 = false;

            // If s1 index and s3 index are pointing to the same character

            if ((s1Index < s1.length()) && (s1.charAt(s1Index) == s3.charAt(s3Index))) {
                d1 = findStringsInterleavingRecursive(s1, s2, s3, s1Index + 1, s2Index, s3Index + 1, table);

            }

            // If s2 index and s3 index are pointing to the same character
            if ((s2Index < s2.length()) && (s2.charAt(s2Index) == s3.charAt(s3Index))) {
                d2 = findStringsInterleavingRecursive(s1, s2, s3, s1Index, s2Index + 1, s3Index + 1, table);
            }
            table.put(subProblem, (d1 || d2));
        }
        // If either of these starting decisions result in us verifying that s3 was indeed a product of
        // interleaving s1 and s2, than we will get True, otherwise False
        return table.get(subProblem);

    }


    // Driver Code

    public static void main(String[] args) {
        ArrayList < String > s1 = new ArrayList < String > (
            Arrays.asList("abd", "abc", "abcdef", "", "xyz", "abcdefghijklmnopqrstuvwxyz"));

        ArrayList < String > s2 = new ArrayList < String > (
            Arrays.asList("cef", "def", "mnop", "", "abc", "abcdefghijklmnopqrstuvwxyz"));

        ArrayList < String > s3 = new ArrayList < String > (
            Arrays.asList("adcbef", "abcccf", "mnaobcdepf", "", "abc", "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));

        // Let's uncomment this and check the effect of dynamic programming using memoization
        // s1.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        // s2.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        // s3.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        for (int i = 0; i < s1.size(); i++) {
            System.out.println("Test Case # " + (i + 1));
            System.out.println("The strings are:");
            System.out.println("s1 = '" + s1.get(i) + "'");
            System.out.println("s2 = '" + s2.get(i) + "'");
            System.out.println("s3 = '" + s3.get(i) + "'");

            String res = "";
            if (isInterleaving(s1.get(i), s2.get(i), s3.get(i)))
                res = "True";
            else
                res = "False";

            System.out.println("Is s3 a product of interleaving s1 and s2?\n" + res);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
}
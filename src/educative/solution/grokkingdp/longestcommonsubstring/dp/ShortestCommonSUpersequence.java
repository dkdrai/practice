package educative.solution.grokkingdp.longestcommonsubstring.dp;

class ShortestCommonSUpersequence
{
    //O(m*n)
    public static int shortestCommonSupersequenceRecursive(int [][] lookupTable, String str1, String str2, int i1, int i2) {
        // if any of the pointers has iterated over all the characters of the string,
        // return the remaining length of the other string 
        if (i1 == str1.length()) {
            return str2.length() - i2;
        }
        if (i2 == str2.length()) {
            return str1.length() - i1;
        }

        // check if the value for the current pointers is already present in the lookup table
        if (lookupTable[i1][i2] == 0) {
            // if both the characters pointed by i1 and i2 are same, increment both pointers
            if (str1.charAt(i1) == str2.charAt(i2)) {
                lookupTable[i1][i2] = 1 + shortestCommonSupersequenceRecursive(lookupTable, str1, str2, i1 + 1, i2 + 1);
            } else {
                // recursively call the function twice by skipping one character from each string
                int length1 = 1 + shortestCommonSupersequenceRecursive(lookupTable, str1, str2, i1, i2 + 1);
                int length2 = 1 + shortestCommonSupersequenceRecursive(lookupTable, str1, str2, i1 + 1, i2);
                lookupTable[i1][i2] = Math.min(length1, length2);
            }
        }

        // return the value stored in the lookup table
        return lookupTable[i1][i2];
    }
    
    public static int shortestCommonSupersequence(String str1, String str2) {
        // lookup table to store the values of recursive calls to prevent redundancy
        int[][] lookupTable;
        lookupTable = new int [str1.length()][];
        for (int i = 0; i < str1.length(); i++) {
            lookupTable[i] = new int[str2.length()];
                for (int j = 0; j < str2.length(); j++) {
                    lookupTable[i][j] = 0;
                }
        }
        return shortestCommonSupersequenceRecursive(lookupTable, str1, str2, 0, 0);
    } 
    
    // driver code
    public static void main(String[] arg) {
        String[] input1Strings = {"abcd", "educativeisfun", "cpprocks", "abcf", "dynamic"};
        String[] input2Strings = {"efgh", "algorithmsarefun", "cppisfun", "bdcf", "programming"};

        // let's uncomment the two lines below and see the effect of dynamic programming on a large test case
        
        // String newArr[] = Arrays.copyOf(input1Strings, input1Strings.length + 1);
        // newArr[input1Strings.length] = "iloveprogrammingbutprogrammingdoesnotloveme";
        // input1Strings = newArr;
        // newArr = Arrays.copyOf(input2Strings, input2Strings.length + 1);
        // newArr[input2Strings.length] = "computersarefastprogrammerskeepthemslow";
        // input2Strings = newArr;

        for (int i = 0; i < input1Strings.length; i++) {
            System.out.print(i + 1);
            System.out.println("\tString 1: " + input1Strings[i]);
            System.out.println("\tString 1: " + input2Strings[i]);
            System.out.println("\tLength of Shortest Common Supersequence: " + shortestCommonSupersequence(input1Strings[i], input2Strings[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
};
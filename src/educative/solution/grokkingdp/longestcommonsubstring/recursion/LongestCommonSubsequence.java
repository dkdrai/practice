package educative.solution.grokkingdp.longestcommonsubstring.recursion;

class LongestCommonSubsequence{

    //O(2^(m+n))
  // Helper function with updated signature: i is current index in str1, j is current index in str2
  public static int longestCommonSubsequenceHelper(String str1, String str2, int i, int j){
      // base case
      if (i == str1.length() || j == str2.length()) 
          return 0;

      // if current characters match, increment 1
      else if (str1.charAt(i) == str2.charAt(j)) 
          return 1 + longestCommonSubsequenceHelper(str1, str2, i+1, j+1);
      
      // else take max of either of two possibilities
      return Math.max(longestCommonSubsequenceHelper(str1, str2, i+1, j), 
                      longestCommonSubsequenceHelper(str1, str2, i, j+1));
  }

  public static int longestCommonSubsequence(String str1, String str2){
    return longestCommonSubsequenceHelper(str1, str2, 0, 0);
  }

  // Driver Code
  public static void main(String[] args){

      String[] firstStrings = {"qstw", "setter", "abcde", "partner", "freedom"};
      String[] secondStrings = {"gofvn", "bat", "apple", "park", "redeem"};

      // You can uncomment the lines below and check how this recursive solution causes a time-out 
      // String temp[] = Arrays.copyOf(firstStrings, firstStrings.length + 1);
      // temp[firstStrings.length] = "sjcneiurutvmpdkapbrcapjru";
      // firstStrings = temp;

      // String temp2[] = Arrays.copyOf(secondStrings, secondStrings.length + 1);
      // temp2[secondStrings.length] = "oidhfwepkxwebyurtunvidqlscmjbg";
      // secondStrings = temp2;

      for (int i = 0; i < firstStrings.length; i++){
          System.out.println(i + 1 + ".\tstr1: " + firstStrings[i] + "\n\tstr2: " + secondStrings[i]
                    + "\n\n\tThe length of the longest common subsequence is: " + longestCommonSubsequence(firstStrings[i], secondStrings[i]));
      }
  }
}
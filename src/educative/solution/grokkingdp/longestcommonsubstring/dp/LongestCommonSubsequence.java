package educative.solution.grokkingdp.longestcommonsubstring.dp;

class LongestCommonSubsequence{

    //O(m*n)
  // Helper function with updated signature: i is current index in str1, j is current index in str2
  public static int longestCommonSubsequenceHelper(String str1, String str2, int i, int j, int[][] dp){
    // base case
    if (i == str1.length() || j == str2.length()) 
        return 0;

    // if the subproblem has been computed before, return the value stored in M
    else if (dp[i][j] != -1) 
		  return dp[i][j];

    // if current characters match, increment 1
    else if (str1.charAt(i) == str2.charAt(j)){
      dp[i][j] = 1 + longestCommonSubsequenceHelper(str1, str2, i + 1, j + 1, dp);
      return dp[i][j];
      }

    // else take max of either of two possibilities
	dp[i][j] = Math.max(longestCommonSubsequenceHelper(str1, str2, i + 1, j, dp),
					   longestCommonSubsequenceHelper(str1, str2, i, j + 1, dp));
    return dp[i][j];
  }
    
  public static int longestCommonSubsequence(String str1, String str2){

    int rows = str1.length();
    int cols = str2.length();

    int[][] dp = new int[rows][cols];

    for (int i = 0; i < rows; i++) { 
      for (int j = 0; j < cols; j++) { 
        dp[i][j] = -1; 
      } 
    }
    return longestCommonSubsequenceHelper(str1, str2, 0, 0, dp);
  }

  // Driver Code
  public static void main(String[] args){

      String[] firstStrings = {"qstw", "setter", "abcde", "partner", "freedom"};
      String[] secondStrings = {"gofvn", "bat", "apple", "park", "redeem"};

      // Let's uncomment this to see the benefit of using dynamic programming with memoization
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
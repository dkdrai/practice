package educative.solution.grokkingdp.palindromicsubsequence.dp;

import java.util.*;
import java.util.stream.*;

public class CountPalindromicSubstring
{
  public static int countPalindromicSubstring(String str1)
  {
    
    // Declare a memo table that stores
    // the answer to recursive calls
    int [][]memo = new int[str1.length()][str1.length()];
    for (int i = 0; i < str1.length(); i++)
            Arrays.fill(memo[i], -1);
    // as every individual character can be a palindromic substring so add the length
    // of the string to the evaluated count of the string
    return str1.length() + CountPalindromicSubstringMemo(str1, 0, str1.length() - 1, memo);
  }
  public static int CountPalindromicSubstringMemo(String str1, int i, int j, int[][] memo)
  {  
    // if i>j then there can be no substring
    // if i=j it means string has single letter so we will count the string itself as a palindromic substring
    // in both the cases we will return the length of the string as count of substring

    if (i >= j)
      return 0; 

    // Declare a bool_memo array which stores
    // the answer to recursive calls of palindromes
    
    boolean[][] boolMemo = new boolean[str1.length()][str1.length()];
    for (int k = 0; k < str1.length(); k++)
            Arrays.fill(boolMemo[k], false);
    // if the recursive call has been called previously, 
    // then return the stored value that was calculated previously
    if(memo[i][j] != -1)
    {
      return memo[i][j];  
    }

    // checking if a substring of the string is a palindrome or not

    if (CheckPalindrome(str1, i, j, boolMemo))
    {
      // if it is a palindrome we will increment the count of the substrings 
      // we will check the other substring from i+1 to j 
      memo[i][j] = 1 + (CountPalindromicSubstringMemo(str1, i+1, j, memo)
      // checking substring from i to j-1
      + CountPalindromicSubstringMemo(str1, i, j-1, memo)
      // remove common palindromic substrings and store the result in memo
      - CountPalindromicSubstringMemo(str1, i+1, j-1, memo));
      return memo[i][j];
    }
    else
    {
      // if it is not a palindrome then we will check the rest of the substrings
      // and store its result in memo 
      memo[i][j] = CountPalindromicSubstringMemo(str1, i+1, j, memo) + CountPalindromicSubstringMemo(str1, i, j-1, memo)  - CountPalindromicSubstringMemo(str1, i+1, j-1, memo);
      return memo[i][j];
    }
  }
  public static boolean CheckPalindrome(String str1, int i, int j, boolean[][] boolMemo)
  {
    // checking if the string is a palindrome or not

    if (i > j)
      return true;
    
    // if the recursive call has been
    // called previously, then return
    // the value that was stored
    // previously
    if (boolMemo[i][j] != false)
      return boolMemo[i][j];

    if (str1.charAt(i) != str1.charAt(j))
    {
      boolMemo[i][j] = false;
      return boolMemo[i][j];
    }
    boolMemo[i][j] = CheckPalindrome(str1, i+1, j-1,boolMemo);
    return boolMemo[i][j]; 
  }
  // Driver code to test the above function
  public static void main(String [] args)
  {

     ArrayList <String> str1List = new ArrayList<String>(){{add("abdbca"); add("cddpd"); add("pqr"); add("abaab"); add("aaa");}};

      // Let's uncomment this and check the effect of dynamic programming using memoization
      // str1List.add("xkjkqlajprjwefilxgpdpebieswu");
      
      for(int i = 0; i < str1List.size(); i++)
      {
          System.out.println(i+1 + ".\tstr1: " + str1List.get(i));
          System.out.println("\n\tCount of palindromic substrings:" + countPalindromicSubstring(str1List.get(i)));
          Stream.generate(() -> "-").limit(100).forEach(System.out::print);
          System.out.println();
      }
  
  }
}
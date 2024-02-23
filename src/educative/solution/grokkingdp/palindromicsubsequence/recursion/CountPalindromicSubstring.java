package educative.solution.grokkingdp.palindromicsubsequence.recursion;

import java.util.*;
import java.util.stream.*;

public class CountPalindromicSubstring
{
  public static int countPalindromicSubstring(String str1)
  {
    return str1.length() + countPalindromicSubstringRecursive(str1, 0, str1.length() - 1);
  }

  public static int countPalindromicSubstringRecursive(String str1, int i, int j)
  {
    // if i>j then there can be no substring
    // if i=j it means string has single letter so we will count the string itself as a palindromic substring
    // in both the cases we will return the length of the string as count of substring  
    if (i >= j)
      return 0; 
    
    // defining a variable for count the palindromic substrings
    int psCount = 0;
    
    // checking if a substring of the string is a palindrome or not
    if (checkPalindrome(str1, i, j))
    {
      // if it is a palindrome we will increment the count of the substrings, will check the other substring from i+1 to j 
      psCount = 1 + (countPalindromicSubstringRecursive(str1, i+1, j) 
      // checking substring from i to j-1
      + countPalindromicSubstringRecursive(str1, i, j-1)
      // remove common palindromic substrings   
      - countPalindromicSubstringRecursive(str1, i+1, j-1));
      return psCount;
    }
    else
    {
      // if it is not a palindrome then we will check the rest of the substrings
      psCount = countPalindromicSubstringRecursive(str1, i+1, j) + countPalindromicSubstringRecursive(str1, i, j-1)  - countPalindromicSubstringRecursive(str1, i+1, j-1);
      return psCount;
    }
  }
  public static boolean checkPalindrome(String str1, int i, int j)
  {
    // checking if a string is palindrome or not
    if (i > j)
      return true;
    if (str1.charAt(i) != str1.charAt(j))
      return false;
    
    return checkPalindrome(str1, i+1, j-1);
  }
  // Driver code to test the above function
  public static void main(String [] args)
  {
      ArrayList <String> str1List = new ArrayList<String>(){{add("abdbca"); add("cddpd"); add("pqr"); add("abaab"); add("aaa");}};

      // You can uncomment the lines below and check how this recursive solution causes a time-out 
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
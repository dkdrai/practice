package educative.solution.grokkingcodinginterviewpatterns.twopointers;

import java.util.*;


public class ValidPalindromeII{

    public static boolean isPalindrome(String input) {
    int i = 0;
    int last = input.length() - 1;
    while (i < last) {
        if (input.charAt(i) != input.charAt(last)) {
         return isSubPalindrome(input, i+1, last) ||
         isSubPalindrome(input, i, last-1);
        }
        i++;
        last--;
    }
    return true; 
    }

    public static boolean isSubPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }
}
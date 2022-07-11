package neetcode.arrayandhashing;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public static void main(String ar[]){
System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }

    public static int longestPalindrome(String s) {
        if(s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            int count = map.getOrDefault(c, 0);
            map.put(c, count+1);
        }
        
        int count = 0;
        int odd = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            count = count + (entry.getValue()/2) * 2;
          }
        return count + odd;
    }
}
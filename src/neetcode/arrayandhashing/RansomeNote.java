package neetcode.arrayandhashing;

import java.util.HashMap;
import java.util.Map;

public class RansomeNote {
    public static void main(String arg[]){
        System.out.println(canConstruct("aa","aab"));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i =0; i<magazine.length(); i++){
            char c = magazine.charAt(i);
            int count = map.getOrDefault(c, 0);
            map.put(c, count+1);
        }
        
        for(int i =0; i<ransomNote.length(); i++){
            char c = ransomNote.charAt(i);
            int count = map.getOrDefault(c, 0);
            if(count == 0){
                return false;
            }
            if(count == 1){
                map.remove(c);
            }else {
                map.put(c, count - 1);
            }
        }
        return true;
    }
}
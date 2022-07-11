package neetcode.arrayandhashing;

public class FualtyKeyboard {

  public static void main(String ar[]) {
    System.out.println(isLongPressedName("ddiinesh", "ddiinneesshh"));
  }


  public static boolean isLongPressedName(String name, String typed) {
    int m = name.length(), n = typed.length();
    int i = 0, j = 0;

    while(i < m && j < n){
      char c1 = name.charAt(i), c2 = typed.charAt(j);
      if(c1 != c2) return false;
      int count1 = 0;
      while(i < m && name.charAt(i) == c1){
        count1++;
        i++;
      }
      int count2 = 0;
      while(j < n && typed.charAt(j) == c2){
        count2++;
        j++;
      }
      if(count2 < count1) return false;
    }
    return i == m && j == n;
  }

}

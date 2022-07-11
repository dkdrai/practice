package neetcode.mathandgeometry;

public class AddBinary {
  public static void main(String arg[]){
    System.out.println(addBinary("11","10"));
  }
    public static String addBinary(String a, String b) {
     return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));   
    }
}
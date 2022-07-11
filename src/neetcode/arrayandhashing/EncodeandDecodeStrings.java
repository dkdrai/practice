package neetcode.arrayandhashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeandDecodeStrings {

  public static void main(String ar[]) {
    List<String> list = new ArrayList<String>(
        List.of("Geeks",
            "for",
            "Geeks", "dinesh", "garima", "tehaan"));
    String encode = encode(list);
    System.out.println(encode);
    List<String> decodeList = decode(encode);
    System.out.println(decodeList);
  }


  public static String encode(List<String> strs) {
    StringBuilder encodedString = new StringBuilder();
    for (String str : strs) {
      int length = str.length();
      encodedString.append(length + "#");
      encodedString.append(str);
    }
    return encodedString.toString();
  }

  public static List<String> decode(String str) {
    List<String> decodedStrings = new ArrayList();
    for (int i = 0; i < str.length(); i++) {
      String length = "";
      while (str.charAt(i) != '#') {
        length += str.charAt(i);
        i++;
      }
      int wordLength = Integer.parseInt(length);
      i++;

      String word = "";
      for (int j = i; j < wordLength + i; j++) {
        word += str.charAt(j);
      }
      decodedStrings.add(word);
      i = i + wordLength - 1;
    }
    return decodedStrings;
  }
}

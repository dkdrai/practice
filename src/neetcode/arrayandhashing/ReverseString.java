package neetcode.arrayandhashing;

public class ReverseString {

    public static void main(String ar[]) {
        System.out.println(reverse("dinesh kumar dewangan"));
    }

    public static String reverse(String str) {
        if (str.isEmpty()) {
            return "";
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
}

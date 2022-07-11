import java.util.Arrays;

public class SortingString {

    public static String sortString(String inputString) {
        char Array1[] = inputString.toCharArray(); // converting input string to char array

        Arrays.sort(Array1);

        return new String(Array1); // return sorted string
    }

    public static void main(String[] args) {
        String inputString = "Edureka";
        String outputString = sortString(inputString);

        System.out.println("Input String : " + inputString);
        System.out.println("Output String : " + outputString);
    }
}
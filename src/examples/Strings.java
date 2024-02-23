package examples;

public class Strings {

    public static void main(String arg[]) {
        String s = "0123456789";
        // indexof() to get the 0 based index of the character if found in string
        //else -f
        System.out.println(s.indexOf("9"));
        //Params:
        //beginIndex – the beginning index, inclusive.
        //endIndex – the ending index, exclusive.
        System.out.println(s.substring(5, 6));

        //String length() is a method which return the size of the string
        System.out.println(s.length());

        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(arr.length);
        int a = 'a', z = 'z', A = 'A', Z = 'Z';
        System.out.println("a=" + a + " z=" + z);
        System.out.println("A=" + A + " Z=" + Z);
        for (int i = 0; i <= 255; i++) {
            // System.out.println(" The ASCII value of " + (char) i + "  =  " + i);
        }
    }
}

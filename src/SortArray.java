import java.util.Arrays;
import java.util.Collections;

public class SortArray {
    public static void main(String[] args) {
        int[] arr = {52, 12, 2, 72, 4}; // array of 5 elements
        Arrays.sort(arr);
        System.out.println("Sorted arr[] = " + Arrays.toString(arr));

        Integer[] intArr = {52, 12, 2, 72, 4};
        Arrays.sort(intArr, Collections.reverseOrder()); // reverseorder() for descending order
        System.out.println("Sorted arr[] =" + Arrays.toString(intArr));

    }
}
package examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingArrayList {

    public static void main(String[] args) {

        Integer[] digits = new Integer[]{12, 56, 89, 27, 22, 4, 88, 65, 36};
        List<Integer> digitsList = Arrays.asList(digits);


        Collections.sort(digitsList); // sorted list

        System.out.println("Sorted String :" + digitsList);

        Collections.sort(digitsList, Collections.reverseOrder()); // sorted list

        System.out.println("Sorted String :" + digitsList);
    }
}
package examples;

import java.util.*;

public class SortSet {
    public static void main(String[] args) {

        //Unsorted list
        HashSet<Integer> numbersSet = new LinkedHashSet<>(
                Arrays.asList(12, 56, 89, 27, 22, 4, 88, 65, 36));

        List<Integer> numbersList = new ArrayList<Integer>(numbersSet); //convert set to list

        //Sort the list
        Collections.sort(numbersList);

        numbersSet = new LinkedHashSet<>(numbersList); //convert list to set

        //Print set to confirm
        System.out.println(numbersSet);
    }

}
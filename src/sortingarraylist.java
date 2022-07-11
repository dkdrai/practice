import java.util.ArrayList;
import java.util.Collections;

public class sortingarraylist {
    public static void main(String args[]) {
        ArrayList<String> list = new ArrayList<String>();

// Populate the ArrayList
        list.add("sorting");
        list.add("java");
        list.add("arraylist");
        list.add("in");
        System.out.println("Unsorted ArrayList: " + list); // printed unsorted arraylist
        Collections.sort(list); // sort method for ascending order


        System.out.println("Sorted ArrayList " + "in Ascending order : " + list); // print sorted arraylist
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Sorted ArrayList " + "in Desscending order : " + list); // print sorted arraylist
    }

    public static void sortArrayListInteger() {
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        arraylist.add(48);
        arraylist.add(2);
        arraylist.add(19);
        arraylist.add(22);
        System.out.println("Before Sorting:"); // before sorting
        for (int counter : arraylist) {
            System.out.println(counter);
        }

        Collections.sort(arraylist); // function to sort in ascending order

        System.out.println("After Sorting:"); // after sorting
        for (int counter : arraylist) {
            System.out.println(counter);
        }
    }
}
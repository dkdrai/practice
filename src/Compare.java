import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Compare {

    public static void main(String arg[]) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        Integer arr1[] = {1, 20, 2, 3, 10, 4, 5, 40};
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(arr1));

        Integer[] dsf = new Integer[list.size()];
        list.toArray(dsf);
        Arrays.stream(dsf).forEach(x -> System.out.print(x + " "));

        Arrays.sort(arr1, comparator);
        System.out.println("array after sorting with comparator:" + arr1);
        Arrays.stream(arr1).forEach(x -> System.out.print(x + " "));

        Collections.sort(list, comparator);
        System.out.println("list after sorting");
        list.stream().forEach(x -> System.out.print(x + " "));

    }
}

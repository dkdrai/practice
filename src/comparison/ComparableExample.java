package comparison;

import java.util.*;

public class ComparableExample implements Comparable<ComparableExample> {

    public int age;

    public int model;

    public ComparableExample(int age, int model) {
        this.age = age;
        this.model = model;
    }

    @Override
    public int compareTo(ComparableExample o) {
        return o.age - age;
    }


    public static void main(String ar[]) {
        ComparableExample c1 = new ComparableExample(50, 2009);
        ComparableExample c2 = new ComparableExample(10, 2010);
        ComparableExample c3 = new ComparableExample(100, 2015);
        ComparableExample c4 = new ComparableExample(20, 2020);
        List<ComparableExample> ComparableExamples = new ArrayList<>();
        ComparableExamples.add(c1);
        ComparableExamples.add(c2);
        ComparableExamples.add(c3);
        ComparableExamples.add(c4);
        Collections.sort(ComparableExamples);
        for (ComparableExample ComparableExample : ComparableExamples) {
            System.out.println(ComparableExample.age);
        }
        System.out.println();
        TreeSet<ComparableExample> set = new TreeSet<>(new Comparator<ComparableExample>() {
            @Override
            public int compare(ComparableExample o1, ComparableExample o2) {
                return o1.compareTo(o2);
            }
        });
        set.add(c1);
        set.add(c2);
        set.add(c3);
        set.add(c4);
        Iterator i = set.iterator();
        while (i.hasNext()) {
            ComparableExample ComparableExample = (ComparableExample) i.next();
            System.out.println(ComparableExample.age);
        }
    }

}

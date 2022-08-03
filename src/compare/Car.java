package compare;

import neetcode.linkedlist.ListNode;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class Car implements Comparable<Car> {

    public int age;

    public Car(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Car o) {
        if (age > o.age)
            return 1;
        else if (age < o.age) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String ar[]) {
        Car c1 = new Car(50);
        Car c2 = new Car(10);
        Car c3 = new Car(100);
        Car c4 = new Car(20);
        TreeSet<Car> set = new TreeSet<>(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                if (o1.age > o2.age)
                    return 1;
                else if (o1.age < o2.age) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        set.add(c1);
        set.add(c2);
        set.add(c3);
        set.add(c4);
        Iterator i = set.iterator();


        while (i.hasNext()) {
            Car car = (Car) i.next();
            System.out.println(car.age);
        }
    }

}

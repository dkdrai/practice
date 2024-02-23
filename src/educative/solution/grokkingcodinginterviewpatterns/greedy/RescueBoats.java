package educative.solution.grokkingcodinginterviewpatterns.greedy;

import java.util.*;

class RescueBoats {

    public static int rescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int left = 0; 
        int right = people.length - 1;

        int boats = 0; 

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;

            boats++;
        }
        return boats;
    }
    // Driver code
    public static void main(String[] args) {
        int[][] people = {{1, 2}, {3, 2, 2, 1}, {3, 5, 3, 4}, {5, 5, 5, 5}, {1, 2, 3, 4}, {1, 2, 3}, {3, 4, 5}};
        int[] limit = {3, 3, 5, 5, 5, 3, 5};

        for (int i = 0; i < people.length; i++) {
            System.out.println((i + 1) + "\tWeights = " + Arrays.toString(people[i]));
            System.out.println("\tWeight Limit = " + limit[i]);
            System.out.println("\tThe minimum number of boats required to save people are "
                    + rescueBoats(people[i], limit[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
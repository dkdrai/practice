package educative.solution.grokkingcodinginterviewpatterns.twoheaps;

import java.util.Arrays;
import java.util.PriorityQueue;

class MaximizeCapital {


    public static int maximumCapital(int c, int k, int[] capitals, int[] profits) {
        int n = capitals.length;
        int currentCapital = c;
        PriorityQueue<int[]> capitalMinHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; ++i) {
            capitalMinHeap.offer(new int[] {capitals[i], i});
        }
        PriorityQueue<Integer> profitsMaxHeap = new PriorityQueue<>((a, b) -> b - a);
        int i = 0;
        while (i < k) {
            while (!capitalMinHeap.isEmpty() && capitalMinHeap.peek()[0] <= currentCapital) {
                int[] j = capitalMinHeap.poll();
                profitsMaxHeap.offer(profits[j[1]]);
            }
            if (profitsMaxHeap.isEmpty()) {
                break;
            }
            int x = profitsMaxHeap.poll();
            currentCapital += x;
            i++;
        }
        return currentCapital;
    }

    public static void main(String[] args) {


        int[] c = {1};
        int[] k = {2};
        int[][] capitals = {

                {1, 2, 2, 3}
        };
        int[][] profits = {
                {2, 4, 6, 8}
        };
        for (int i = 0; i < k.length; i++) {
            System.out.println((i + 1) + ".\tProject capital requirements: " + Arrays.toString(capitals[i]));
            System.out.println("\tProject expected profits: " + Arrays.toString(profits[i]));
            System.out.println("\tNumber of projects: " + k[i]);
            System.out.println("\tStart-up capital: " + c[i]);
            System.out.println("\n\t\tProcessing: ");
            System.out.println("\n\tMaximum Capital earned: " + maximumCapital(c[i], k[i], capitals[i], profits[i]));
        }
    }
}
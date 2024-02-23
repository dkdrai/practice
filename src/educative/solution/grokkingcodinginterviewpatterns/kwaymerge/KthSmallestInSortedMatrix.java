package educative.solution.grokkingcodinginterviewpatterns.kwaymerge;

import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 4;
        System.out.println(kthSmallestElement(mat, k));
    }

    public static int kthSmallestElement(int[][] matrix, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < matrix.length; i++) {
            queue.offer(new int[]{matrix[i][0], i, 0});
        }

        int j = 1;
        while (!queue.isEmpty()) {
            int key[] = queue.poll();
            int row = key[1];
            int column = key[2] + 1;
            if (k == j) {
                return key[0];
            }
            if (column < matrix[0].length) {
                queue.offer(new int[]{matrix[row][column], row, column});
            }
            j++;
        }

        return -1;
    }

}
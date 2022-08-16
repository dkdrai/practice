package matrix;

public class SearchInSortedMatrixRowWise {

    //https://leetcode.com/problems/search-a-2d-matrix/
    //74. Search a 2D Matrix
    public static void main(String args[]) {
        int[][] mat = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}};
        System.out.println(find(mat, 3));
    }

    public static boolean find(int mat[][], int key) {
        int m = mat.length;
        if (m == 0) {
            return false;
        }
        int n = mat[0].length;
        int pivotIndex;
        int pivotValue;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            pivotIndex = (left + right) / 2;
            pivotValue = mat[pivotIndex / n][pivotIndex % n];
            if (key == pivotValue) {
                return true;
            } else if (key < pivotValue) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
        return false;
    }
}

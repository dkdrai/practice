package neetcode.binarysearch;

/*
Given a sorted array arr of distinct integers, return the lowest index i for which arr[i] == i.
Return null if there is no such index.

For example, given the array [-5, -3, 2, 3], return 2 since arr[2] == 2.
Even though arr[3] == 3, we return 2 since it's the lowest index.
 */

public class PivotIndex {

    public static void main(String[] args) {
        int arr[] = {-5, -3, 2, 3};
        System.out.println(indexEqualsValueSearch(arr));
    }

    static int indexEqualsValueSearch(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int md = (lo + hi) / 2;
            if (arr[md] < md) {
                lo = md + 1;
            } else if (arr[md] == md && (md == 0 || arr[md - 1] < (md - 1))) {
                return md;
            } else {
                hi = md - 1;
            }
        }
        return -1;
    }
}

package neetcode.intervals;

public class MinimumNumberofPlatforms {

    public static void main(String[] args) {
        int arr[] = {940, 1500, 900, 1800, 950, 1100};
        int dep[] = {1200, 1900, 910, 2000, 1120, 1130};
        int n = 6;
        System.out.println(
                "Minimum Number of Platforms Required = "
                        + findPlatform(arr, dep, n));
    }

    public static int findPlatform(int arr[], int dep[],
                                   int n) {
        int plat_needed = 1, result = 1;
        for (int i = 0; i < n; i++) {
            plat_needed = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] >= arr[j] && arr[i] <= dep[j])
                    plat_needed++;
                if (arr[j] >= arr[i] && arr[j] <= dep[i])
                    plat_needed++;
            }
            result = Math.max(result, plat_needed);
        }
        return result;
    }

}

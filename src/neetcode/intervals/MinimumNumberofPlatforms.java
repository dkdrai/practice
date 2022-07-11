package neetcode.intervals;

public class MinimumNumberofPlatforms
{

  public static void main(String[] args)
  {
    int arr[] = { 1100,940,900,  950,  1500, 1800 };
    int dep[] = {  1130,1200,910, 1120,  1900, 2000 };
    int n = 6;
    System.out.println(
        "Minimum Number of Platforms Required = "
            + findPlatform(arr, dep, n));
  }
  public static int findPlatform(int arr[], int dep[],
      int n)
  {
    int plat_needed = 1, result = 1;
    int i = 1, j = 0;
    for (i = 0; i < n; i++) {
      plat_needed = 1;
      for (j = i + 1; j < n; j++) {
        if ((arr[i] >= arr[j] && arr[i] <= dep[j])
            || (arr[j] >= arr[i]
            && arr[j] <= dep[i]))
          plat_needed++;
      }
      result = Math.max(result, plat_needed);
    }
    return result;
  }

}

package neetcode.arrayandhashing;

/*
* Minimum Distance Between Words of a String
Difficulty Level : Medium
Last Updated : 24 Dec, 2020
Given a string s and two words w1 and w2 that are present in S. The task is to find the minimum distance between w1 and w2. Here distance is the number of steps or words between the first and the second word.
Examples:


Input : s = “geeks for geeks contribute practice”, w1 = “geeks”, w2 = “practice”
Output : 1
There is only one word between closest occurrences of w1 and w2.
Input : s = “the quick the brown quick brown the frog”, w1 = “quick”, w2 = “frog”
Output : 2
* */

public class MinimumDistanceBetweenWordsofaString {

  public static void main(String ar[]) {
    System.out.println(getDistanceBruteFprce("the quick the brown quick brown the frog", "quick", "frog"));
    String s = "the quick the brown quick brown the frog";
    String[] list = s.split(" ");
    System.out.println(mindiff(list, "brown", "frog"));
  }

  public static int getDistanceBruteFprce(String s, String w1, String w2) {
    if (w1.equals(w2)) {
      return 0;
    }
    String[] list = s.split(" ");
    int minDif = Integer.MAX_VALUE;
    for (int i = 0; i < list.length; i++) {
      if (list[i].equals(w1)) {
        for (int j = 0; j < list.length; j++) {
          if (list[j].equals(w2)) {
            int diff = Math.abs(j - i);
            if (minDif > diff) {
              minDif = diff;
            }
          }
        }
      }
    }
    return minDif - 1;
  }

  static int mindiff(String[] str, String w1, String w2) {
    int p1 = -1;
    int p2 = -1;
    int mindiff = Integer.MAX_VALUE;
    for (int i = 0; i < str.length; i++) {
      if (str[i].equals(w1)) {
        p1 = i;
      }
      if (str[i].equals(w2)) {
        p2 = i;
      }
      if (p1 != -1 && p2 != -1) {
        int diff = Math.abs(p1 - p2);
        mindiff = Math.min(mindiff, diff);
      }
    }

    if (mindiff != Integer.MAX_VALUE) {
      return mindiff - 1;
    } else {
      return -1;
    }
  }
}

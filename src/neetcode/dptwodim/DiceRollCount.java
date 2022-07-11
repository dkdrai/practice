package neetcode.dptwodim;

public class DiceRollCount {


  public static void main(String arp[]) {
    System.out.println(getDiceRollWaysCount(2, 3, 4));
  }

  public static int getDiceRollWaysCount(int d, int f, int target) {
    System.out.println("d " + d + " target " + target + " ");
    if (d == 0) {
      return (target == 0) ? 1 : 0;
    }
    if (target < 0 || target < d || d * f < target) {
      return 0;
    }
    int count = 0;
    for (int i = 1; i <= f; i++) {
      System.out.println(" for " + i + " ");
      count += getDiceRollWaysCount(d - 1, f, target - i);
      System.out.println(" loop " + count + " ");
    }
    System.out.println(" return " + count);
    return count;
  }

}

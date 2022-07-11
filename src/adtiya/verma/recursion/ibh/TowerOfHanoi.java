package adtiya.verma.recursion.ibh;

public class TowerOfHanoi {

  public static void main(String ar[]) {
    tower("source", "dest", "aux", 3);
  }

  public static void tower(String source, String dest, String aux, int n) {
    if (n == 1) {
      System.out.println("moving  " + n + " from " + source + " to " + dest);
      return;
    }
    tower(source, aux, dest, n - 1);
    System.out.println("moving  " + n + " from " + source + " to " + dest);
    tower(aux, dest, source, n - 1);
  }

}

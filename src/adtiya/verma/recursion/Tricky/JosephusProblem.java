package adtiya.verma.recursion.Tricky;

import java.util.ArrayList;
import java.util.List;

/*There are n people standing in a circle waiting to be executed.
The counting out begins at some point in the circle and proceeds around the circle in a fixed direction.
In each step,a certain number of people are skipped and the next person is executed.
The elimination proceeds around the circle(which is becoming smaller and smaller as the executed people are removed),until only the last person remains,who is given freedom.
Given the total number of persons n and a number k which indicates that k-1persons are skipped and kth person is killed in circle.
The task is to choose the place in the initial circle so that you are the last one remaining and so survive.

    For example,if n=5and k=2,then the safe position is 3.
    Firstly,the person at position 2is killed,then person at position 4is killed,then person at position 1is killed.
    Finally,the person at position 5is killed.So the person at position 3survives.
    If n=7and k=3,then the safe position is 4.
    The persons at positions 3,6,2,7,5,1are killed in order,and person at position 4survives.*/


public class JosephusProblem {

  public static void main(String ar[]) {
    int n = 40;
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      list.add(i);
    }
    int k = 7;
    System.out.println(solve(0, list, k - 1));
  }

  private static int solve(int index, List<Integer> list, int k) {
    if (list.size() == 1) {
      return list.get(0);
    }
    index = (index + k) % list.size();
    list.remove(index);
    return solve(index, list, k);
  }

}

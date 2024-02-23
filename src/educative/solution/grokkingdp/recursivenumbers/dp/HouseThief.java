package educative.solution.grokkingdp.recursivenumbers.dp;

import java.util.*;

class HouseThief{

//Wrapper function
public static int houseThief_(int[] memo, int[] money, int ind){
  int stop = money.length;
  //Base case
  if (ind >= stop)
    return 0;
    
  if (memo[ind] == 0){
   //stores the maximum of the following two values at memo[ind]:
   //1. Leaving the current house and starting from the next house
   //2. The maximum robbery if we rob the current house along with the houses starting from the next to
   // the next house
    memo[ind] = Math.max(houseThief_(memo, money, ind+1), money[ind] + houseThief_(memo, money, ind+2));
  }
  return memo[ind];
}

public static int houseThief(int[] money){
  //Stopping criteria
  int stop = money.length;
  //Store values in memo
  int[] memo = new int[stop];
  for(int i=0; i < memo.length; i++)
  {
    memo[i]=0;
  }
  return houseThief_(memo, money, 0);
}

//Driver code
public static void main(String[] args){
    int[][] list = {{2, 7, 9, 31, 33, 4, 99, 1 , 2, 3, 15, 34, 23, 11, 9, 1, 4}, 
    {1, 2, 3, 1}, {4, 6, 3, 9, 3, 8, 3}, {1, 5, 7, 3, 7 , 2, 3}, {2, 7, 9, 3, 1}};
    
    //Let's uncomment this to see the benefit of using dynamic programming with top-down approach
    //int newList[][] = Arrays.copyOf(list, list.length + 1);
    //newList[list.length] = new int[]{2, 7, 9, 31, 33, 56, 78, 59, 85, 7, 3, 74, 6, 3, 9, 3, 8, 30, 
    //1, 2, 5, 10, 30, 50, 4, 99, 202, 150, 33, 65, 79, 2, 3, 1 , 2, 3, 15, 34, 
    //23, 11, 9, 8, 5, 78, 89, 12, 56, 78, 23, 90, 66, 5, 7, 9, 1, 4};
    //list = newList;

    for(int i=0; i<list.length;i++)
    {
      System.out.print("Maximum Theft in example ");
      System.out.print(Arrays.toString(list[i]));
      System.out.println(" is " + (houseThief(list[i])));
      System.out.println(new String(new char[100]).replace('\0', '-'));
    } 
  }
}
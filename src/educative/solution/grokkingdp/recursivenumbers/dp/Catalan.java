package educative.solution.grokkingdp.recursivenumbers.dp;

import java.util.*;
import java.util.stream.*;

class Catalan{
    public static long catalan(int n){
        long[] memo=new long[n+1];
        return catalanMemo(n, memo);
    } 

    public static long catalanMemo(int n, long []memo){
        // base case; C(0) = 1
        if (n == 0)          
            return 1;

        // if n already evaluated, return from memo
        else if (memo[n]!=0)
          return memo[n];
          
        long sum = 0;
        
        // iterate from 1...n to evaluate: C(0)*C(n-1) + C(1)*C(n-2) ... + C(n-1)*C(0)
        for(int i=0; i<n ; i++)
            // C(i)*C(n-1-i)
            sum += (catalanMemo(i,memo) * catalanMemo(n-1-i,memo)); 
          
        // store result in memo
        memo[n]=sum;  
          
        return memo[n];
    }

    // Driver code to test the above function
    public static void main(String[] args){
      ArrayList<Integer> nList = new ArrayList<Integer>(){{add(0); add(1); add(2); add(4); add(6);}};
      
      // Let's uncomment this and check the effect of dynamic programming using memoization
      // nList.add(22);

      for(int i=0; i<nList.size(); i++)
      {
          System.out.println(i+1 + ".\tn: " + nList.get(i));
          System.out.println("\n\tnth catalan number: "+ catalan(nList.get(i)));
          Stream.generate(() -> "-").limit(100).forEach(System.out::print);
          System.out.println();    
      }
    }
}
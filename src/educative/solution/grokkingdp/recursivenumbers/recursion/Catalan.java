package educative.solution.grokkingdp.recursivenumbers.recursion;

import java.util.*;
import java.util.stream.*;

class Catalan{
    public static long catalan(int n){
        // base case; C(0) = 1
        if (n == 0)      
            return 1;
        
        long sum = 0;
        // iterate from 1...n to evaluate: C(0)*C(n-1) + C(1)*C(n-2) ... + C(n-1)*C(0)
        for(int i =0; i<n ; i++)
            // C(i)*C(n-1-i)
            sum += (catalan(i) * catalan(n-1-i)); 

        return sum;
    }

    // Driver code to test the above function
    public static void main(String[] args){
        ArrayList<Integer> nList = new ArrayList<Integer>(){{add(0); add(1); add(2); add(4); add(6);}};
        // You can uncomment the line below and check how this recursive solution causes a time-out
        // nList.add(22);

        for(int i=0; i<nList.size() ; i++){
            System.out.println(i+1 + ".\tn: " + nList.get(i));
            System.out.println("\n\tnth catalan number: "+ catalan(nList.get(i)));
            Stream.generate(() -> "-").limit(100).forEach(System.out::print);
            System.out.println();    
        }
    }
}
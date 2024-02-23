package educative.solution.grokkingcodinginterviewpatterns.greedy;

import java.util.*;
/*
* Statement
There are
�
n
 gas stations along a circular route, where the amount of gas at the
�
�
ℎ
i
th

 station is gas[i].

We have a car with an unlimited gas tank, and it costs cost[i] of gas to travel from the
�
�
ℎ
i
th

 station to the next
(
�
+
1
)
�
ℎ
(i+1)
th

 station. We begin the journey with an empty tank at one of the gas stations.

Find the index of the gas station in the integer array gas such that if we start from that index we may return to the same index by traversing through all the elements, collecting gas[i] and consuming cost[i].

If it is not possible, return -1.

If there exists such index, it is guaranteed to be unique.
* [1, 2, 3, 4, 5] , [3, 4, 5, 1, 2]
* output = 3*/
class GasStations {
    public static int gasStationJourney(int[] gas, int[] cost) {
        
        if (Arrays.stream(cost).sum() > Arrays.stream(gas).sum()) {
            return -1;
        }

        int currentGas = 0;
        int startingIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];

            if (currentGas < 0) {
                currentGas = 0;
                startingIndex = i + 1;
            }
        }

        return startingIndex;
    }
    // Driver code
    public static void main(String[] args) {

        int[][] gas = {
            {1, 2, 3, 4, 5},
            {2, 3, 4},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 10},
            {1, 1, 1, 1, 1},
            {1, 2, 3, 4, 5}
        };
        int[][] cost = {
            {3, 4, 5, 1, 2},
            {3, 4, 5},
            {1, 2, 3, 4, 5},
            {2, 2, 1, 3, 1},
            {1, 0, 1, 2, 3},
            {1, 2, 3, 4, 5}
        };
        for (int i = 0; i < cost.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tGas: " + Arrays.toString(gas[i]));
            System.out.println("\tCost: " + Arrays.toString(cost[i]));
            System.out.println("\tThe index of the gas station we can start our journey from is "+ gasStationJourney(gas[i], cost[i])+ " (If it's -1, then that means no solution exists)");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
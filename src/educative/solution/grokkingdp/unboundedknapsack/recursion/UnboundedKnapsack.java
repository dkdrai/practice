package educative.solution.grokkingdp.unboundedknapsack.recursion;

import java.util.stream.*;

class UnboundedKnapsack {

    // time O(2^n)
    // space O(n)
    public static int unboundedKnapsackRec(int[] weights, int[] values, int n, int capacity){
        // Base case
        if (n == 0)
            return (int) Math.floor(capacity / weights[0]) * values[0];
        
        // Check if the weight of the nth item is less than capacity 
        // If it is, we have two choices
        // 1) Include the item 
        // 2) Don't include the item
        int taken = -1;
        int notTaken = 0;
        if (weights[n] <= capacity){
            taken = values[n] + unboundedKnapsackRec(weights, values, n, capacity - weights[n]);
            notTaken = 0 + unboundedKnapsackRec(weights, values, n - 1, capacity);
            
            // As we want to maximize the profit, we take the maximum of the two values
            return Math.max(taken, notTaken);
        }
        // If weight of the nth item is greater than the capacity
        // Don't include the item
        else
            return unboundedKnapsackRec(weights, values, n - 1, capacity);
    }

    public static int unboundedKnapsack(int[] weights, int[] values, int n, int capacity){
      return unboundedKnapsackRec(weights, values, n - 1, capacity);
    }
    
    // Driver code
    public static void main(String[] args) {
        int[][] weights = {{2, 4, 6}, {1, 2, 3, 5}, {4}, {2}, {3, 6, 10, 7, 2}, {3, 6, 10, 7, 2, 12, 15, 10, 13, 20}};
        int[][] values = {{5, 11, 13}, {1, 5, 4, 8}, {2}, {3}, {12, 10, 15, 17, 13}, {12, 10, 15, 17, 13, 12, 30, 15, 18, 20}};
        int[] capacity = {10, 6, 3, 3, 10, 20};
        int[] n = {3, 4, 1, 1, 5, 10};

        // You can uncomment the lines below and check how this recursive solution causes a time-out
        
        // int[][] temp1 = Arrays.copyOf(weights, weights.length + 1);
        // temp1[weights.length] = new int[]{8575, 554, 3310, 514, 1454, 3251, 2221, 6404, 7779, 155, 1910, 8934, 4781, 414, 3670, 4049, 1425, 3589, 5505, 482, 619, 5484, 6416, 8938, 7114, 912, 934, 5255, 4634, 9096, 
        //                                   1488, 3710, 1002, 5651, 5076, 2456, 8902, 7298, 213, 8033, 8305, 2123, 8319, 3586, 2538, 2489, 7635, 4815, 6930, 4492, 5297, 7549, 476, 3065, 7839, 8443, 4830, 126, 4198, 
        //                                   9464, 574, 6538, 4526, 1577, 2689, 955, 4885, 2943, 8253, 5098, 1476, 7910, 8074, 1147, 2848, 1964, 3636, 1836, 6779, 1919, 6328, 3428, 9468, 7657, 6494, 8660, 6600, 1824, 
        //                                   8786, 2150, 2640, 9360, 8688, 7167, 2289, 2730, 8122, 7175, 5673, 7727, 2773};
        // weights = temp1;

        // int[][] temp2 = Arrays.copyOf(values, values.length + 1);
        // temp2[values.length] = new int[]{4502, 7989, 5199, 6501, 5337, 1663, 4990, 9173, 4442, 6409, 4354, 7371, 6229, 5011, 2217, 2389, 6963, 1041, 8027, 5613, 2681, 6240, 8653, 5700, 529, 3235, 2322, 3704, 6761, 
        //                                  3401, 5830, 1263, 1390, 1029, 4116, 6728, 9045, 9106, 2253, 3487, 5515, 6607, 7210, 1745, 1618, 9427, 486, 4933, 6820, 8514, 6898, 5854, 1106, 1904, 1554, 1635, 5139, 229, 
        //                                  1692, 1900, 3630, 3874, 9515, 1373, 1255, 3632, 8101, 300, 2738, 6706, 140, 4606, 3314, 3702, 6351, 1284, 3130, 6837, 6218, 6302, 1703, 3116, 2156, 2809, 5020, 3711, 797, 
        //                                  160, 3940, 8841, 8412, 3922, 2715, 4280, 5295, 322, 7912, 9748, 623, 7002, 6455};
        // values = temp2;

        // int[] temp3 = Arrays.copyOf(capacity, capacity.length + 1);
        // temp3[capacity.length] = 10000;
        // capacity = temp3;

        // int[] temp4 = Arrays.copyOf(n, n.length + 1);
        // temp4[n.length] = 100;
        // n = temp4;
      
        for (int i = 0; i < values.length; i++){
            System.out.print(i + 1);
            System.out.println(". We have a knapsack of capacity " + capacity[i] + " and we are given the following list of item values and weights:");
            Stream.generate(() -> "-").limit(30).forEach(System.out::print);
            System.out.println();
            System.out.println("Weights   |     Values");
            Stream.generate(() -> "-").limit(30).forEach(System.out::print);
            System.out.println();
            for (int j = 0; j < values[i].length; ++j)
                System.out.printf("%-10d|%6d\n", weights[i][j], values[i][j]);
            int result = unboundedKnapsack(weights[i], values[i], n[i], capacity[i]);
            System.out.println("\nThe maximum we can earn is: " + result);
            Stream.generate(() -> "-").limit(100).forEach(System.out::print);
            System.out.println("\n");
        }
    }
}
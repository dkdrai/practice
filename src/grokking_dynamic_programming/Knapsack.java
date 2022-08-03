package grokking_dynamic_programming;

class Knapsack {
    int result[][];

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return solveKnapsackRec(profits, weights, capacity, 0);
    }

    public int solveKnapsackRec(int[] profits, int[] weights, int capacity, int i) {
        if (capacity == 0 || i == profits.length) {
            return 0;
        }
        int profit1 = 0;
        if (capacity >= weights[i]) {
            profit1 = profits[i] + solveKnapsackRec(profits, weights, capacity - weights[i], i + 1);

        }
        int profit2 = solveKnapsackRec(profits, weights, capacity, i + 1);
        return Math.max(profit1, profit2);
    }

    public int solveKnapsackMemo(int[] profits, int[] weights, int capacity) {
        result = new int[weights.length][capacity + 1];
        for (int i = 0; i < weights.length ; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                result[i][j] = -1;
            }
        }
        return solveKnapsackMemoUtil(profits, weights, capacity, 0);
    }

    public int solveKnapsackMemoUtil(int[] profits, int[] weights, int capacity, int i) {
        if (capacity == 0 || i >= profits.length) {
            return 0;
        }
        if (result[i][capacity] != -1) {
            return result[i][capacity];
        }

        if (capacity >= weights[i]) {
            result[i][capacity] = Math.max(profits[i] + solveKnapsackMemoUtil(profits, weights, capacity - weights[i], i + 1),
                    solveKnapsackMemoUtil(profits, weights, capacity, i + 1));
        } else {
            result[i][capacity] = solveKnapsackMemoUtil(profits, weights, capacity, i + 1);
        }
        return result[i][capacity];
    }

    public int solveKnapsackTab(int[] profits, int[] weights, int capacity) {
        if (capacity == 0 || profits.length == 0) {
            return 0;
        }
        result = new int[weights.length + 1][capacity + 1];
        for (int i = 0; i < weights.length + 1; i++) {
            result[i][0] = 0;
        }
        for (int j = 0; j < capacity + 1; j++) {
            result[0][j] = 0;
        }
        for (int i = 1; i < weights.length + 1; i++) {
            for (int j = 1; j < capacity +1; j++) {
                if (j >= weights[i-1]) {
                    result[i][j] = Math.max(profits[i] + result[i - 1][j - weights[i]], result[i][j - 1]);
                } else {
                    result[i][j] = result[i-1][j ];
                }
            }
        }
        return result[weights.length + 1][capacity + 1];
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 5);
        System.out.println("Total knapsack profit ---> " + maxProfit);


        maxProfit = ks.solveKnapsackMemo(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsackMemo(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsackMemo(profits, weights, 5);
        System.out.println("Total knapsack profit ---> " + maxProfit);


        maxProfit = ks.solveKnapsackTab(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsackTab(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsackTab(profits, weights, 5);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

}

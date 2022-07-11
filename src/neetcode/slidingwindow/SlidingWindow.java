package neetcode.slidingwindow;

public class SlidingWindow {

  public static void main(String args[]) {
    int stocks[] = {7, 1, 5, 3, 6, 4};
    System.out.println(maxProfit(stocks));
  }

  //121. Best Time to Buy and Sell Stock
  //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
  public static int maxProfit(int[] prices) {
    int min = prices[0];

    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > min && prices[i] - min > profit) {
        profit = prices[i] - min;
      }
      if (prices[i] < min) {
        min = prices[i];
      }
    }
    return profit;
  }
}

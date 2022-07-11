package neetcode.arrayandhashing;

public class BuyandSellStockMultipleTimes {

  public static void main(String arg[]) {
    int arr[] = {1, 2, 10, 4, 5 , 6};
    System.out.println(maxProfit(arr));
  }

  //122. Best Time to Buy and Sell Stock II
  //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
  public static int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int profit = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i + 1] > prices[i]) {
        profit += (prices[i + 1] - prices[i]);
      }
    }
    return profit;
  }

}

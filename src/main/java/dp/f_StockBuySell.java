package dp;

public class f_StockBuySell {

  static int maxProfit(int[] arr) {
    int maxProfit = 0;
    int minPrice = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      minPrice = Math.min(minPrice, arr[i]);
      maxProfit = Math.max(maxProfit, arr[i] - minPrice);
    }
    return maxProfit;
  }

  static int maxProfitMultiTrans(int prices[]) {
    // maxProfit adds up the difference between adjacent elements if they are in increasing order
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++)
      if (prices[i] > prices[i - 1])
        maxProfit += prices[i] - prices[i - 1];
    return maxProfit;
  }

  static int maxProfit(int i, int buy, int prices[]) {
    if (i == prices.length)
      return 0;

    int profit = 0;
    if (buy == 1) {
      int b = -prices[i] + maxProfit(i + 1, 0, prices);
      int notB = maxProfit(i + 1, 1, prices);
      profit = Math.max(b, notB);
    } else {
      int sell = prices[i] + maxProfit(i + 1, 1, prices);
      int notSell = maxProfit(i + 1, 0, prices);
      profit = Math.max(sell, notSell);
    }
    return profit;
  }

  static int maxProfitDP(int n,int prices[]) {
    int dp[][] = new int[n + 1][2];

    dp[n][0] = dp[n][1] = 0;

    for (int i = n - 1; i >= 0; i--) {
      for (int buy = 0; buy <= 1; buy++) {
        int profit = 0;
        if (buy == 1) {
          int b = -prices[i] + dp[i + 1][0];
          int notB = dp[i + 1][1];
          profit = Math.max(b, notB);
        } else {
          int sell = prices[i] + dp[i + 1][1];
          int notSell = dp[i + 1][0];
          profit = Math.max(sell, notSell);
        }
        dp[i][buy] = profit;
      }
    }
    return dp[0][1];
  }

  static int maxProfitK(int i, int buy, int k, int prices[]) {
    if (i == prices.length || k == 0)
      return 0;

    int profit = 0;
    if (buy == 1) {
      int b = -prices[i] + maxProfitK(i + 1, 0, k, prices);
      int notB = maxProfitK(i + 1, 1, k, prices);
      profit = Math.max(b, notB);
    } else {
      int sell = prices[i] + maxProfitK(i + 1, 1, k - 1, prices);
      int notSell = maxProfitK(i + 1, 0, k, prices);
      profit = Math.max(sell, notSell);
    }
    return profit;
  }

  static int maxProfitFee(int i, int buy, int prices[]) {
    if (i == prices.length)
      return 0;

    int profit = 0;
    if (buy == 1) {
      int b = -prices[i] + maxProfitFee(i + 1, 0, prices);
      int notB = maxProfitFee(i + 1, 1, prices);
      profit = Math.max(b, notB);
    } else {
      int sell = prices[i] + maxProfitFee(i + 1, 1, prices) -5 ;
      int notSell = maxProfitFee(i + 1, 0, prices);
      profit = Math.max(sell, notSell);
    }
    return profit;
  }

  static int maxProfitCooldown(int i, int buy, int prices[]) {
    if (i >= prices.length)
      return 0;

    int profit = 0;
    if (buy == 1) {
      int b = -prices[i] + maxProfitCooldown(i + 1, 0, prices);
      int notB = maxProfitCooldown(i + 1, 1, prices);
      profit = Math.max(b, notB);
    } else {
      int sell = prices[i] + maxProfitCooldown(i + 2, 1, prices) ;
      int notSell = maxProfitCooldown(i + 1, 0, prices);
      profit = Math.max(sell, notSell);
    }
    return profit;
  }

  /* Driver program to test above functions */
  public static void main(String args[]) {
    int arr[] = {1, 7, 1, 5, 3, 6, 14};
    System.out.println("Max profit is: " + maxProfit(arr));
    System.out.println("Max profit is: " + maxProfitMultiTrans(arr));
    System.out.println("Max profit is: " + maxProfit(0, 1, arr));
    System.out.println("Max profit is: " + maxProfitDP(arr.length, arr));
    System.out.println("Max profit is: " + maxProfitFee(0, 1, arr));
    System.out.println("Max profit is: " + maxProfitCooldown(0, 1, arr));
  }
}

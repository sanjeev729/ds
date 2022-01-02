package arrays;

import java.util.HashMap;

public class StockBuySell {
	
	public static int maxProfitOneTran(int[] price) {
		int min = Integer.MAX_VALUE;
		int diff = 0;
		for (int i = 0; i < price.length; i++) {
			if (price[i] < min) {
				min = price[i];
			} else if (diff < price[i] - min) {
				diff = price[i] - min;
			}

		}
		return diff;
	}
	
	public static int maxProfitManyTrans(int[] price) {
		int profit = 0;
		for (int i = 0; i < price.length - 1; i++) {
			if (price[i + 1] > price[i]) {
				profit += price[i + 1] - price[i];
			}
		}
		return profit;
	}
	
	// At most K transactions TC:O(2^N) every element can perform only 2 operations 1. buy/sell or 2.skip
	// buyOrSell 0:go for buy 1:go for sell
	private static int maxProfit(int i, int buyOrSell, int[] prices, int k, HashMap<String, Integer> hm) {
        if (i >= prices.length || k == 0) 
            return 0;
        
        String key  = i + "" + buyOrSell + "" + k;    
        if(hm.containsKey(key)) return hm.get(key);  //check in mem map
        
        int x = 0; 
        if (buyOrSell == 0) {
            int buy   =  maxProfit(i + 1, 1, prices, k, hm) - prices[i];
            int noBuy =  maxProfit(i + 1, 0, prices, k, hm); 
            x = Math.max(buy, noBuy);
         } else {
            int sell   = maxProfit(i + 1, 0, prices, k-1, hm) + prices[i];
            int noSell = maxProfit(i + 1, 1, prices, k, hm);
            x = Math.max(sell, noSell);
        }
        
        hm.put(key, x);    //put in mem map before returning.
        
        return x;
    }
    public static int maxProfit(int[] prices,int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        return maxProfit(0, 0, prices, k, hm);
    }
    
    /**
     * This is slow method but easier to understand.
     * Time complexity is O(k * number of days ^ 2)
     * T[i][j] = max(T[i][j-1], max(prices[j] - prices[m] + T[i-1][m])) where m is 0...j-1
     */
    public int maxProfitDPSlowSolution(int prices[], int K) {
        if (K == 0 || prices.length == 0) {
            return 0;
        }
        int T[][] = new int[K+1][prices.length];

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                int maxVal = 0;
                for (int m = 0; m < j; m++) {
                    maxVal = Math.max(maxVal, prices[j] - prices[m] + T[i-1][m]);
                }
                T[i][j] = Math.max(T[i][j-1], maxVal);
            }
        }
        
        return T[K][prices.length - 1];
    }
    
    /**
     * This is faster method which does optimization on slower method
     * Time complexity here is O(K * number of days)
     *
     * Formula is
     * T[i][j] = max(T[i][j-1], prices[j] + maxDiff)
     * maxDiff = max(maxDiff, T[i-1][j] - prices[j])
     */
    public static int maxProfitDP(int prices[], int K) {
        if (K == 0 || prices.length == 0) {
            return 0;
        }
        int T[][] = new int[K+1][prices.length];

        for (int i = 1; i < T.length; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < T[0].length; j++) {
                T[i][j] = Math.max(T[i][j-1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i-1][j] - prices[j]);
            }
        }

        return T[K][prices.length-1];
    }
	
	public static void main(String args[]) {
		// stock prices on consecutive days
		int price[] = {2, 5, 7, 1, 4, 3, 1, 3};
		
		System.out.println(maxProfitOneTran(price));
		System.out.println(maxProfitManyTrans(price));
		System.out.println(maxProfit(price,2));
		System.out.println(maxProfitDP(price,2));
	}
}
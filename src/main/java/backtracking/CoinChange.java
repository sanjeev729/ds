package backtracking;

public class CoinChange {

	public static void main(String[] args) {

		int arr[] = { 2, 3, 5, 6};
		int n = 7;
		// System.out.println(makeChange(n, arr));
		coinChange(arr, n, 0, "");
		System.out.println();
		coinChangeMultipleOcc(arr, n, 0, "");
		System.out.println();
		System.out.println("combination: "+coinChangeMultipleOccCombination(arr, n));
		System.out.println("permuation: "+coinChangeMultipleOccPermutation(arr, n));
		}

	// either take it or leave it,one coin will come only once
	private static void coinChange(int[] coin, int sum, int n, String result) {
		if (n == coin.length) {
			if (sum == 0) {
				System.out.println(result);
			}
			return;
		}
		// include the coin
		coinChange(coin, sum - coin[n], n + 1, result + coin[n] + "-");
		// not to include the coin
		coinChange(coin, sum, n + 1, result);

	}
	// multiple occurrences are allowed,combinations only  permutations are not allowed
	private static void coinChangeMultipleOcc(int[] coin, int sum, int n, String result) {
		if (n == coin.length) {
			if (sum == 0) {
				System.out.println(result);
			}
			return;
		}
		// If we decided to include the coin[i] then the coin can come
		// 1,2,3,4...sum/coin[i] times
		for (int times = sum / coin[n]; times >= 1; times--) {

			coinChangeMultipleOcc(coin, sum - coin[n] * times, n + 1, result + coin[n] + "*" + times + "-");

		}
		// decided not to include the coin[i]
		coinChangeMultipleOcc(coin, sum, n + 1, result);

	}
	
	// using dp multiple occurrences are allowed,combinations only  permutations are not allowed 
	private static int coinChangeMultipleOccCombination(int[] coin,int sum) {
		
		// no of ways to make sum trying one coin after another,we can have multiple occurrences of the same coin but once we are done with a coin then we can't use the same coin later
		int[]dp=new int[sum+1];
		dp[0]=1;
		for (int i = 0; i < coin.length; i++) {
			for (int j = coin[i]; j < dp.length; j++) {
				dp[j] = dp[j] + dp[j - coin[i]];
			}
		}
		return dp[sum];

	}
	
	// multiple occurrences are allowed,permutations are allowed
	private static int coinChangeMultipleOccPermutation(int[] coins, int sum) {

		// no of ways to make sum trying all coins one after another,the same
		// coin can come in later calls as well
		int[] dp = new int[sum + 1];
		dp[0] = 1;
		for (int amt = 0; amt <= sum; amt++) {
			for (int coin : coins) {
				if (coin <= amt) {
					int remaining = amt - coin;
					dp[amt] = dp[amt] + dp[remaining];
				}
			}
		}
		return dp[sum];

	}

}

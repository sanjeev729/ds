package dp.knapsack.unbounded;

public class StairCase {

	public static int noWays(int n) {
		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return 0;
		}
		System.out.println("no cals: " + n);
		int ways1 = noWays(n - 1);
		int ways2 = noWays(n - 2);
		int ways3 = noWays(n - 3);

		return ways1 + ways2 + ways3;
	}

	public static int noWays(int n, int[] mem) {
		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return 0;
		}
		if (mem[n] > 0) {
			return mem[n];
		}
		System.out.println("no cals: " + n);
		int ways1 = noWays(n - 1, mem);
		int ways2 = noWays(n - 2, mem);
		int ways3 = noWays(n - 3, mem);

		return mem[n] = ways1 + ways2 + ways3;
	}

	public static int noWaysDP(int n) {
		int[] dp = new int[n + 1];

		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				dp[i] = dp[i - 1];
			} else if (i == 2) {
				dp[i] = dp[i - 1] + dp[i - 2];
			} else {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			}
		}
		return dp[n];
	}

	public static int noWaysVariableSteps(int i, int arr[], int[] ans) {
		if (i == arr.length - 1) {
			return 1;
		} else if (i >= arr.length) {
			return 0;
		}
		if (ans[i] > 0) {
			return ans[i];
		}
		int noway = 0;
		System.out.println("no cals: " + i);
		for (int j = 1; j <= arr[i]; j++) {
			noway = noway + noWaysVariableSteps(i + j, arr, ans);
		}

		return ans[i] = noway;
	}

	public static void noWaysVariableStepsDP(int arr[]) {
		int[] dp = new int[arr.length];
		dp[arr.length - 1] = 1;
		for (int i = arr.length - 2; i >= 0; i--) {
			for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {

				dp[i] += dp[i + j];
			}
		}

		for (int j = 0; j < arr.length; j++) {

			System.out.print(dp[j] + " ");
		}

	}

	public static int minNoOfWaysDP(int arr[]) {
		int[] dp = new int[arr.length];
		dp[arr.length - 1] = 0;
		for (int i = arr.length - 2; i >= 0; i--) {
			int min = Integer.MAX_VALUE;
			if (arr[i] > 0) {
				for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
					min = Math.min(min, dp[i + j]);
				}
				if (min != Integer.MAX_VALUE) {
					dp[i] = min + 1;
				} else {
					dp[i] = 0;
				}
			}
		}
		for (int j = 0; j < arr.length; j++) {
			System.out.print(dp[j] + " ");
		}
		System.out.println();
		return dp[0];
	}
	
	

	public static void main(String[] args) {
		int n = 10;
		int[] mem = new int[n + 1];
		System.out.println(noWays(n));
		System.out.println(noWays(n, mem));
		int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
		int[] ans = new int[arr.length + 1];
		/*
		 * System.out.println(noWaysVariableSteps(0, arr, ans)); for (int i = 0;
		 * i < arr.length; i++) { if (ans[i] == 0 && i < arr.length - 1) {
		 * ans[i] = -1;// to show which cell doesn't reach to end }
		 * System.out.print(ans[i] + " "); }
		 */
		System.out.println();
		noWaysVariableStepsDP(arr);
		System.out.println();
		System.out.println("min number: " + minNoOfWaysDP(arr));
	}

}

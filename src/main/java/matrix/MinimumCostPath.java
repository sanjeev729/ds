package matrix;

public class MinimumCostPath {

	public static int shortestDistanceDP(int[][] cost) {
		// down,diagonal,Right moves are allowed
		int temp[][] = new int[cost.length][cost[0].length];

		temp[0][0] = cost[0][0];
		// Filling top row
		for (int i = 1; i < cost[0].length; i++)
			temp[0][i] = temp[0][i - 1] + cost[0][i];
		// Filling Leftmost column
		for (int i = 1; i < cost.length; i++)
			temp[i][0] = temp[i - 1][0] + cost[i][0];
		// Filling other cells
		for (int r = 1; r < cost.length; r++)
			for (int c = 1; c < cost[0].length; c++) {
				temp[r][c] = cost[r][c] + Math.min(temp[r - 1][c - 1], Math.min(temp[r - 1][c], temp[r][c - 1]));

			}
		return temp[cost.length - 1][cost[0].length - 1];
	}

	static int numberOfPaths(int[][] cost) {
		// down,diagonal,Right moves are allowed
		int m = cost.length, n = cost[0].length;
		// Create a 2D table to store results
		// of subproblems
		int count[][] = new int[m][n];

		// Count of paths to reach any cell in
		// first column is 1
		for (int i = 0; i < m; i++)
			count[i][0] = 1;

		// Count of paths to reach any cell in
		// first column is 1
		for (int j = 0; j < n; j++)
			count[0][j] = 1;

		// Calculate count of paths for other
		// cells in bottom-up manner using
		// the recursive solution
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++)

				count[i][j] = count[i - 1][j] + count[i][j - 1] + count[i - 1][j - 1];
		}
		return count[m - 1][n - 1];
	}

	static int numberWays(int i, int j) {
		// down,diagonal,Right moves are allowed
		if (i == 0 && j == 0)
			return 1;
		// out of bound cases
		if (i < 0 || j < 0)
			return 0;

		return numberWays(i - 1, j) + numberWays(i, j - 1) + numberWays(i - 1, j - 1);
	}

	static int numberWaysDP(int m, int n) {
		// down,diagonal,Right moves are allowed
		int dp[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					dp[0][0] = 1;
				} else {
					int up = 0, down = 0, dg = 0;
					if (i > 0) up = dp[i - 1][j];
					if (j > 0) down = dp[i][j - 1];
					if (i > 0 && j > 0) dg = dp[i - 1][j - 1];
					dp[i][j] = up + down + dg;
				}
			}
		}
		return dp[m - 1][n - 1];
	}

	static long minCostSum(int i, int j, int[][] arr) {
		// down,Right moves are allowed
		if (i == 0 && j == 0)
			return arr[0][0];
		// out of bound cases
		if (i < 0 || j < 0)
			return Integer.MAX_VALUE;

		long up = arr[i][j] + minCostSum(i - 1, j, arr);
		long down = arr[i][j] + minCostSum(i, j - 1, arr);
		long dg = arr[i][j] + minCostSum(i - 1, j - 1, arr);

		return Math.min(dg, Math.min(up, down));
	}

	static long minCostSumDP(int m, int n, int[][] arr) {
      // down,diagonal,Right moves are allowed
      long dp[][] = new long[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (i == 0 && j == 0) {
            dp[0][0] = arr[0][0];
          } else {
            long up = arr[i][j], down = arr[i][j], dg = arr[i][j];

            if (i > 0) up += dp[i - 1][j];
            else up += Integer.MAX_VALUE;

            if (j > 0) down += dp[i][j - 1];
            else down += Integer.MAX_VALUE;

            if (i > 0 && j > 0) dg += dp[i - 1][j - 1];
            else dg += Integer.MAX_VALUE;

            dp[i][j] = Math.min(dg, Math.min(up, down));
          }
        }
      }
      return dp[m - 1][n - 1];
    }

	public static void main(String[] args) {
		int cost[][] = { { 31, 100, 65, 12, 18 },
				         { 10, 13, 47, 157, 6 },
				         { 100, 113, 174, 11, 33 },
				         { 88, 124, 41, 20, 140 },
				         { 99, 32, 111, 41, 20 }};
		System.out.println(shortestDistanceDP(cost));
		System.out.println(numberOfPaths(cost));
		System.out.println(numberWays(4,4));
        System.out.println(numberWaysDP(5,5));
		System.out.println(minCostSum(4,4,cost));
		System.out.println(minCostSumDP(5,5,cost));
	}

}

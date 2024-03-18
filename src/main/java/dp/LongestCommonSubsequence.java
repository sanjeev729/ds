package dp;

public class LongestCommonSubsequence {

	/*
	 * Recursive implementation Returns length of LCS for X[0..m-1], Y[0..n-1]
	 * 
	 * Time complexity of recursive approach is O(2^n) in worst case and worst
	 * case happens when all characters of X and Y mismatch i.e., length of LCS
	 * is 0.
	 */

	public static int lcs(int m, int n, char[] X, char[] Y) {
		if (m == 0 || n == 0)
			return 0;

		if (X[m - 1] == Y[n - 1])
			return 1 + lcs(m - 1, n - 1, X, Y);

		return Math.max(lcs(m - 1, n, X, Y), lcs(m, n - 1, X, Y));
	}

	// DP way

	public static int lcsDp(int m, int n, char[] X, char[] Y) {
		int dp[][] = new int[m + 1][n + 1];

		/*
		 * Following steps build L[m+1][n+1] in bottom up fashion. Note that
		 * L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
		 */
		for (int i = 0; i < m + 1; i++) {
			dp[i][0] = 0;
		}

		for (int j = 0; j < n + 1; j++) {
			dp[0][j] = 0;
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (X[i - 1] == Y[j - 1])
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[m][n];
	}

	public static void lcsPrint( int m, int n,char[] X, char[] Y) {
		int dp[][] = new int[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			dp[i][0] = 0;
		}

		for (int j = 0; j < n + 1; j++) {
			dp[0][j] = 0;
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (X[i - 1] == Y[j - 1])
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		int i = m;
		int j = n;
		StringBuffer lcs = new StringBuffer();
		while (i > 0 && j > 0) {
			
			if (X[i - 1] == Y[j - 1]) {
				lcs.append(X[i - 1]);
				i--;
				j--;
			} else {
				if (dp[i][j - 1] >= dp[i - 1][j])
					j--;
				else
					i--;
			}
		}
		System.out.println(lcs.reverse());
	}

	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String s1 = "AGGTAB";
		String s2 = "GXTXAYyuyuyuwyuB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " + lcs.lcs( m, n,X, Y));
		System.out.println("Length of LCS is" + " " + lcs.lcsDp( m, n,X, Y));
		lcs.lcsPrint( m, n,X, Y);
	}

}
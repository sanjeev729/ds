package dp;
//Appication of catalan no
public class NoBSTPossible {
	// Total number of possible Binary Search Trees with n different keys
	// (countBST(n)) = Catalan number Cn = (2n)!/(n+1)!*n!
	static int catalanNumber(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = 0;
			for (int j = 0; j < i; j++) // fix one node as root node at a time
			{
				dp[i] += dp[j] * dp[i - j - 1]; // 1)multiply the to ends for a particular possibility
										     // 2)Add all possibilities
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(catalanNumber(3));
	}

}

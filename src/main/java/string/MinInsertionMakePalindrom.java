package string;

public class MinInsertionMakePalindrom {
  
	static int findMinInsertions(String str, int i, int j) {
		if (i >= j)
			return 0;

		if (str.charAt(i) == str.charAt(j)) {
			return findMinInsertions(str, i + 1, j - 1); //both characters are same so no need to insert
		} else {
			return Math.min(findMinInsertions(str, i + 1, j), findMinInsertions(str, i, j - 1)) + 1; //inserting one character as characters are not same 
		}
	}
	
	static int findMinInsertionsMem(String str, int i, int j, int[][] mem) {
		if (i >= j)
			return 0;
		if (mem[i][j] > 0)
			return mem[i][j];
		if (str.charAt(i) == str.charAt(j)) {
			return mem[i][j] = findMinInsertionsMem(str, i + 1, j - 1, mem); //both characters are same so no need to insert
		} else {
			return mem[i][j] = Math.min(findMinInsertionsMem(str, i + 1, j, mem),
					findMinInsertionsMem(str, i, j - 1, mem)) + 1; //inserting one character as characters are not same 
		}
	}
	
	static int findMinInsertionsDp(String str) {
		int n = str.length();
		int[][] dp = new int[n][n];

		for (int i = n - 1; i >= 0; i--) {
			dp[i][i] = 0;
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 1; j < n; j++) {
				if (str.charAt(i) == str.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
				}
			}
		}

		return dp[0][n - 1];

	}

	public static void main(String[] args) {
		  int [][]mem=new int[1000][1000];
		String str = "geeks";
		System.out.println(findMinInsertions(str, 0, str.length() - 1));
		System.out.println(findMinInsertionsMem(str, 0, str.length() - 1,mem));
		System.out.println(findMinInsertionsDp(str));
	}

}

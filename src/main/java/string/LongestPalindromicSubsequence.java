package string;

/**
 * 
 *
 * Given a string find longest palindromic subsequence in this string.
 *
 * Time complexity - O(n2) Space complexity - O(n2)
 *
 */
public class LongestPalindromicSubsequence {

	public int calculate1(char[] str) {
		int T[][] = new int[str.length][str.length];
		for (int i = 0; i < str.length; i++) {
			T[i][i] = 1;                        // Bottom up manner first fill string of length 1
		}
		for (int l = 2; l <= str.length; l++) {   // for strings from length 2 to str.length(), considering only upper triangular matrix cells because lower one will have same strings in reverse order
			for (int i = 0; i < str.length - l + 1; i++) {
				int j = i + l - 1;
				if (l == 2 && str[i] == str[j]) {   // l==2 because we haven't fill lower triangular matrix values to 0
					T[i][j] = 2;
				} else if (str[i] == str[j]) {
					T[i][j] = T[i + 1][j - 1] + 2;
				} else {
					T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
				}
			}
		}
		return T[0][str.length - 1];
	}

	public int calculateRecursive(char str[], int start, int len) {
		if (len == 1) {
			return 1;
		}
		if (len == 0) {
			return 0;
		}
		if (str[start] == str[start + len - 1]) {
			return 2 + calculateRecursive(str, start + 1, len - 2);
		} else {
			return Math.max(calculateRecursive(str, start + 1, len - 1), calculateRecursive(str, start, len - 1));
		}
	}

	public static void main(String args[]) {
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		String str = "agbdba";
		int r1 = lps.calculateRecursive(str.toCharArray(), 0, str.length());
		int r2 = lps.calculate1(str.toCharArray());
		System.out.print(r1 + " " + r2);
	}

}
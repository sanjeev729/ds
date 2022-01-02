package string;

public class LongestPalinSubstring {
	
	static int longestPalSubstr(String str, String str2) {

		int table[][] = new int[str.length() + 1][str2.length() + 1];

		// All substrings of length 1 are palindromes
		int maxLength = 0;
		for (int i = 0; i < str.length(); i++)
			for (int j = 0; j < str2.length(); j++) {
				if (i == 0 || j == 0)
					table[i][j] = 0;
			}

		// check for sub-string of length 2.
		for (int i = 1; i < str.length(); i++)
			for (int j = 1; j < str2.length(); j++) {
				if (str.charAt(i - 1) == str2.charAt(j - 1)) {
					table[i][j] = 1 + table[i - 1][j - 1];

					maxLength = Math.max(maxLength, table[i][j]);
				}
			}

		System.out.print("Longest palindrome substring is; ");

		return maxLength; // return length of LPS
	}

	static String reverse(String str1, int start, int end) {

		char str[] = str1.toCharArray();
		// Temporary variable
		// to store character
		char temp;

		while (start < end) {
			// Swapping the first
			// and last character
			temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}

		return String.valueOf(str);
	}

	// Driver program to test above functions
	public static void main(String[] args) {

		String str = "forgeeksskeegfor";
		String strrev = reverse(str, 0, str.length() - 1);
		System.out.println("Length is: " + longestPalSubstr(str, strrev));
	}
}
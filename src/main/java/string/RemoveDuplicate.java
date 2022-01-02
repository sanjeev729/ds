package string;

public class RemoveDuplicate {

	public static void main(String[] args) {
		// Input string with repeating chars
		String s = "geeksforgeeks";

		System.out.println(unique(s));
	}

	private static String unique(String s) {
		boolean[] hash = new boolean[26];
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (hash[s.charAt(i) - 'a'] == false) {
				hash[s.charAt(i) - 'a'] = true;
				result += s.charAt(i);
			}

		}
		return result;
	}

}

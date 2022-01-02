package arrays;

import java.util.Stack;

public class RemoveAdjesenctRepeatedChars {
	
		public static void removeAdjesent(String str) {
		Stack<Character> s = new Stack<>();
		int i = 0;
		while ( i < str.length()) {

			if (!s.isEmpty() && s.peek() == str.charAt(i)) {
				while (!s.isEmpty() && i < str.length() && s.peek() == str.charAt(i)) {
					s.pop();
					s.push(str.charAt(i));
					i++;
				}
				if (!s.isEmpty()) {
					s.pop();
				}

			} else {
				s.push(str.charAt(i));
				i++;
			}
		}
		
		System.out.println(s);
	}

	public static void main(String[] args) {
		
		String str1 = "geeksforgeeg";
	    removeAdjesent(str1);
	    
	    String str2 = "azxxxzy";
	    removeAdjesent(str2);
	 
	    String str3 = "caaabbbaac";
	    removeAdjesent(str3);
	 
	    String str4 = "gghhg";
	    removeAdjesent(str4);
	 
	    String str5 = "aaaacddddcappp";
	    removeAdjesent(str5);
	 
	    String str6 = "aaaaaaaaaa";
	    removeAdjesent(str6);
	 
	    String str7 = "qpaaaaadaaaaadprq";
	    removeAdjesent(str7);
	 
	    String str8 = "acaaabbbacdddd";
	    removeAdjesent(str8	);
	}

}

package string;

import java.util.HashMap;


public class RomanAndNumber {

	public static int romanToNumber(String str) {
		HashMap<Character, Integer> roman = new HashMap<Character, Integer>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				put('I', 1);
				put('V', 5);
				put('X', 10);
				put('L', 50);
				put('C', 100);
				put('D', 500);
				put('M', 1000);
			}
		};
		int num = 0;
		for (int i = 0; i < str.length(); i = i + 1) {
			if (roman.get(str.charAt(i + 1)) > roman.get(str.charAt(i))) {
				num += roman.get(str.charAt(i + 1)) - roman.get(str.charAt(i));    //IV-> 1 5, 5-1=4 
				                                                                   //IX-> 1 10, 10-1=9
				i++;
			} else {
				num += roman.get(str.charAt(i));   //VI-> 5 1,5+1=6
				                                   //XII-> 10 1 1,10+1+1=12 
			}
		}

		return num;

	}

	public String numberToRoman(int num) {
		return null;

	}

	public static void main(String[] args) {
		 // Considering inputs given are valid
	    String input = "MCMIV";
	    
	    System.out.print("Integer form of Roman Numeral is " +
	    		romanToNumber(input));

	}

}

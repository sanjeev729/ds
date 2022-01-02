package arrays.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowVariable {
	

	public static void main(String[] args) {
		int arr[] = { 4, 2,2,7, 1, 8,2, 1, 0};
		int sum = 8;
		System.out.println(maxWinLenGivenSum(arr, sum));
		System.out.println("----------------------");
		System.out.println(minWindowLengthGivenSum(arr, sum));
		System.out.println("----------------------");
		String str="aaahhibc";
		int distinct=2;
		System.out.println(longestSubstringKDistinct(str,distinct));
		System.out.println("----------------------");
		
		System.out.println(longestSubstringAllDistinct(str));
		System.out.println("----------------------");
		
		String str1="abccde";
		int k=1;
		System.out.println(longestSubstringReplaceNomoreKletters(str1,k));
		System.out.println("----------------------");
		int arr2[]={0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
		int k2=3;
		System.out.println(longestSubstringReplaceOsWithOnes(arr2,k2));
		
		String s = "this is a test string";
		String t = "tist";

		System.out.print("Smallest window in s with all chars of t  : " + minWindowWithAllCharsOfT(s, t));
	}
	
	private static int maxWinLenGivenSum(int[] arr, int sum) {
		int i = 0, j = 0;
		int currentSum = 0;
		int maxLen = Integer.MIN_VALUE;
		while (j < arr.length) {

			currentSum = currentSum + arr[j];

			if (currentSum < sum) {
				j++;
			} else if (currentSum == sum) {
				maxLen = Math.max(maxLen, j - i + 1);
				j++;
			} else if (currentSum > sum) {

				while (currentSum > sum) { // keep on reducing the window size from arr[i]

					currentSum = currentSum - arr[i];
					i++;
				}
				j++;
			}
		}

		return maxLen;
	}
	
	private static int minWindowLengthGivenSum(int[] arr, int sum) {
		int i = 0;
		int currentSum = 0;
		int minLen = Integer.MAX_VALUE;
		for(int j=0;j < arr.length;j++) {

			currentSum = currentSum + arr[j];
			
			while(currentSum>=sum){                  //keep on reducing the window size from arr[i] and update the minlen if it satisfies the condition
				minLen = Math.min(minLen, j-i+1);
				currentSum=currentSum -arr[i];
				i++;	
			}

		}
		
		return minLen;
	}
	
	public static int longestSubstringKDistinct(String str, int k) {
		int i = 0, j = 0, maxLength = Integer.MIN_VALUE;
		Map<Character, Integer> charFrequencyMap = new HashMap<>();

		while (j < str.length()) {
			char rightChar = str.charAt(j);
			charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
			if (charFrequencyMap.size() < k) {
				j++;
			} else if (charFrequencyMap.size() == k) {
				maxLength = Math.max(maxLength, j - i + 1);
				j++;
			} else if (charFrequencyMap.size() > k) {

				while (charFrequencyMap.size() > k) {
					char leftChar = str.charAt(i);
					charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
					if (charFrequencyMap.get(leftChar) == 0) {
						charFrequencyMap.remove(leftChar);
					}
					i++;
				}
				j++;
			}
		}
		return maxLength;
	}
	
	public static int longestSubstringAllDistinct(String str) {
		int i = 0, j = 0, maxLength = Integer.MIN_VALUE;
		Map<Character, Integer> charFrequencyMap = new HashMap<>();

		while (j < str.length()) {
			char rightChar = str.charAt(j);
			charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
			if (charFrequencyMap.size() == j-i+1) {
				maxLength = Math.max(maxLength, j - i + 1);
				j++;
			} else if (charFrequencyMap.size() < j-i+1) {

				while (charFrequencyMap.size() <j-i+1) {
					char leftChar = str.charAt(i);
					charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
					if (charFrequencyMap.get(leftChar) == 0) {
						charFrequencyMap.remove(leftChar);
					}
					i++;
				}
				j++;
			}
		}
		return maxLength;
	}
	
	public static String minWindowWithAllCharsOfT(String s, String t) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (char ch : t.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		int counter = map.size();
		int i = 0, j = 0, len = Integer.MAX_VALUE;
		String ans = "";
		while (j < s.length()) {
			char endChar = s.charAt(j);
			Integer count = map.get(endChar);
			if (count != null) {
				map.put(endChar, count - 1);
				if (map.get(endChar) == 0)
					counter--;
			}
       /* Now counter is 0 we can have one ans window length(j-i+1) but 
        * to optimize it even further start deleting charter from left using i as long as counter is 0.
        */			
			 while (counter == 0) {
				char c = s.charAt(i);
				if (map.get(c) != null) {
					map.put(c, map.get(c) + 1);
					if (map.get(c) > 0)
						counter++;
				}
				if (j - i + 1 < len) {
					len = j - i + 1;
					ans = s.substring(i, i + len);
				}
				i++;
			}
			j++;
		}
		return ans;
	}
	
	public static int longestSubstringReplaceNomoreKletters(String str, int k) {
		int i = 0, j = 0, maxLength = 0;
		int maxLetterCount = 0;
		Map<Character, Integer> charFrequencyMap = new HashMap<>();
		while (j < str.length()) {
			char rightChar = str.charAt(j);
			charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
			maxLetterCount = Math.max(maxLetterCount, charFrequencyMap.get(rightChar));
			if ((j - i + 1) - maxLetterCount == k) {
				maxLength = Math.max(maxLength, j - i + 1);
			} else if ((j - i + 1) - maxLetterCount > k) {
				char leftChar = str.charAt(i);
				charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
				i++;
			}
			j++;
		}
		return maxLength;
	}
	
	
	
	public static int longestSubstringReplaceOsWithOnes(int[] arr, int k) {
		int i = 0, maxLength = 0;
		int maxOneCount = 0;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == 1) {
				maxOneCount++;
			}
			if ((j - i + 1) - maxOneCount > k) {
				if (arr[i] == 1) {
					maxOneCount--;
				}
				i++;
			}
			maxLength = Math.max(maxLength, j - i + 1);
		}
		return maxLength;
	}		
}

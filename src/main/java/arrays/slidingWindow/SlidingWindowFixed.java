package arrays.slidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;

public class SlidingWindowFixed {
	

	public static void main(String[] args) {
		int arr[] = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
		int k = 4;
		System.out.println(maxSumOfSizeK(arr, k));
		System.out.println();
		int arr1[] = { -8, 2, 3, -6, 10 };
		int k1 = 2;
		List<Integer> list = firstNegativeInWindow(arr1, k1);
		list.forEach(x -> System.out.print(x + " "));
		System.out.println();
		int arr2[] = { 9, 6, 11, 8, 10, 5, 4, 13, 93,14 };
		int k2 = 4;
		List<Integer> list2 = maxElementInWindow(arr2, k2);
		list2.forEach(x -> System.out.print(x + " "));
	}

	private static int maxSumOfSizeK(int[] arr, int windowSize) {
		int i = 0;
		int j = 0;
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		while (j < arr.length) {

			sum = sum + arr[j];

			if ((j - i + 1) < windowSize) {

				j++;
			} else if ((j - i + 1) == windowSize) {
				maxSum = Math.max(maxSum, sum);
				sum = sum - arr[i];
				j++;  //slide the window
				i++;
			}

		}
		return maxSum;
	}
	
	private static List<Integer> firstNegativeInWindow(int[] arr, int windowSize) {
		int i = 0;
		int j = 0;
		Queue<Integer> negativeList = new LinkedList<>();
		List<Integer> ans = new ArrayList<>();
		while (j < arr.length) {

			if (arr[j] < 0) {

				negativeList.add(arr[j]);
			}

			if ((j - i + 1) < windowSize) {

				j++;
			} else if ((j - i + 1) == windowSize) {

				if (negativeList.isEmpty()) {
					ans.add(0);
				} else {
					ans.add(negativeList.peek());  //element present at front of the negativeList queue will be ans for current window
					if (arr[i] == negativeList.peek()) {  //in next run arr[i] will go out of scope so if it is at front in negativeList then delete it.
						negativeList.poll();
					}
				}
				j++; //slide the window
				i++;
			}
		}
		return ans;
	}

	private static List<Integer> maxElementInWindow(int[] arr, int windowSize) {
		int i = 0;
		int j = 0;
	  Deque<Integer> doublyendedQ = new ArrayDeque<Integer>();//single variable is not enough as we have to maintain other elements also which can become greatest in later windows.
		List<Integer> ans=new ArrayList<>();
		while (j < arr.length) {

			while ( doublyendedQ.size()> 0 && doublyendedQ.getLast() < arr[j]) { //always element in dqueue should be in descending order ,elements before the greater element will not become ans remove them 

				doublyendedQ.pollLast();     //remove from last               
			}

			doublyendedQ.addLast(arr[j]);    //add from last
			
			if ((j - i + 1) < windowSize) {

				j++;
			} else if ((j - i + 1) == windowSize) {
					ans.add(doublyendedQ.getFirst());  //element present at front of the doublyendedQ queue will be ans for current window
					if (arr[i] == doublyendedQ.getFirst()) {  //in next run arr[i] will go out of scope so if it is at front in doublyendedQ then delete it.
						doublyendedQ.pollFirst();  //remove from front
					}
				
				j++;  //slide the window
				i++;
			}
		}
		return ans;
	}

	public int CountOfOccurrencesOfAnagrams(String toCheck, String toSearch) {
		int result = 0;
		int i = 0;// starting point
		int j = 0;// end point
		int k = toSearch.length(); //window size

		//char set
		Map<Character, Integer> keyValuePairs = new HashMap<>();
		for (int s = 0; s < toSearch.length(); s++) {
			if (keyValuePairs.containsKey(toSearch.charAt(s)))
				keyValuePairs.put(toSearch.charAt(s), keyValuePairs.get(toSearch.charAt(s)) + 1);
			else
				keyValuePairs.put(toSearch.charAt(s), 1);
		}
		int count = keyValuePairs.size();

		//sliding window
		while (j < toCheck.length()) {
			if (keyValuePairs.containsKey(toCheck.charAt(j))) {
				keyValuePairs.put(toCheck.charAt(j),keyValuePairs.get(toCheck.charAt(j)) -1);
				if (keyValuePairs.get(toCheck.charAt(j)) == 0)
					count--;
			}
			if ((j - i + 1) < k) {
				j++;
			} else if ((j - i + 1) == k) {
				if (count == 0)
					result++;
				if (keyValuePairs.containsKey(toCheck.charAt(i))) {
					keyValuePairs.put(toCheck.charAt(i),keyValuePairs.get(toCheck.charAt(i))+1);
					if (keyValuePairs.get(toCheck.charAt(i)) == 1)
						count++;
				}
				i++;
				j++;
			}
		}
		return result;
	}

}

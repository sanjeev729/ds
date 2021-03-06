package arrays;

import java.util.Arrays;

public class ChocolateDistribution {
    //1.sort array 
    //2.check min diff for i(smallest) and i+m-1(largest) for each window
	static int findMinDiff(int arr[], int n, int m) {
		// if there are no chocolates or number
		// of students is 0
		if (m == 0 || n == 0)
			return 0;

		// Sort the given packets
		Arrays.sort(arr);

		// Number of students cannot be more than
		// number of packets
		if (n < m)
			return -1;

		// Largest number of chocolates
		int min_diff = Integer.MAX_VALUE;

		// Find the subarray of size m such that
		// difference between last (maximum in case
		// of sorted) and first (minimum in case of
		// sorted) elements of subarray is minimum.
		int first = 0, last = 0;
		for (int i = 0; i + m - 1 < n; i++) {
			int diff = arr[i + m - 1] - arr[i];
			if (diff < min_diff) {
				min_diff = diff;
				first = i;
				last = i + m - 1;
			}
		}
		return (arr[last] - arr[first]);
	}
	
	
	
	public static void main(String[] args) {
		int arr[] = { 12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50 };

		System.out.println(findMinDiff(arr, arr.length, 7));
	}

}

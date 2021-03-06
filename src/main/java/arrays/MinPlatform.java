package arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinPlatform {
	// Returns minimum number of platforms required
	public static int findPlatform(int arr[], int dep[], int n) {
		// Sort arrival and departure arrays
		Arrays.sort(arr);
		Arrays.sort(dep);

		// plat_needed indicates number of platforms needed at a time
		int plat_needed = 1, result = 1;
		int i = 1, j = 0;

		// Similar to merge in merge sort to process all events in sorted order
		while (i < n && j < n) {
			// If next event in sorted order is arrival, increment count of
			// platforms needed
			if (arr[i] < dep[j]) {
				plat_needed++;
				i++;
				if (plat_needed > result) // Update result if needed
					result = plat_needed;
			} else // Else decrement count of platforms needed
			{
				plat_needed--;
				j++;
			}
		}

		return result;
	}
	
	public static int meetingRoom2(Intervals[] interval) {
		
		Arrays.sort(interval, (a, b) -> a.start - b.start);
		PriorityQueue<Intervals> minHeap = new PriorityQueue<>((a, b) -> a.end - b.end);
		minHeap.add(interval[0]);
		for (int i = 1; i < interval.length; i++) {
			Intervals earliest = minHeap.poll();
			Intervals current = interval[i];
			if (current.start >= earliest.end) {
				earliest.end = current.end;
			} else {
				minHeap.add(current);
			}
			minHeap.add(earliest);
		}

		return minHeap.size();
	}


	// Driver program to test methods of graph class
	public static void main(String[] args) {

		int arr[] = { 900, 940, 950, 1500,1100 , 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		int n = arr.length;
		System.out.println(findPlatform(arr, dep, n));
		
	}

}
package dp;

public class MaximumSubarrySum {
	// Kadane's algo only works if at least one element is positive
	static int maxSubArraySum(int a[]) {
		int size = a.length;
		int max = Integer.MIN_VALUE, current = 0, sIndex = 0, eIndex = 0, s = 0;

		for (int i = 0; i < size; i++) {
			current = current + a[i];
			if (current < 0) {
				current = 0;
				s = i + 1;
			} else if (max < current) {
				max = current;
				sIndex = s;
				eIndex = i;
			}
		}
		System.out.println("from " + sIndex + " to " + eIndex);
		return max;
	}

	// Dynamic programming way works for all negative no's also
	static int maxSubArraySumDP(int a[]) {
		int size = a.length;
		int max = a[0], current = a[0];
		for (int i = 1; i < size; i++) {
			current = Integer.max(current + a[i], a[i]);
			max = Integer.max(max, current);
		}

		return max;
	}

	public static void main(String[] args) {
		int[] a = { 10, -3, -9, 8,-7, -10, -11 };
		System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
	}

}

package dp;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequenceLength {

  static int lis(int i, int preMax_idx, int[] arr) {
    if (i == arr.length)
      return 0;

    int len = lis(i + 1, preMax_idx, arr);
    if (preMax_idx == -1 || arr[i] > arr[preMax_idx]) {
      len = Math.max(len, 1 + lis(i + 1, i, arr));
    }
    return len;
  }

  static int lis(int arr[], int n) {
    int lis[] = new int[n];
    int maxLis = 0;
    /* Initialize LIS values for all indexes */
    for (int i = 0; i < n; i++)
      lis[i] = 1;

    /* Compute optimized LIS values in bottom up manner */
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
          lis[i] = lis[j] + 1;
      }
      maxLis = Math.max(maxLis, lis[i]);
    }
    return maxLis;
  }

  public static void main(String args[]) {
    int arr[] = {1, 101, 2, 3, 100, 4,9};
    int n = arr.length;
    System.out.println("Length of lis is " + lis(arr, n));
    System.out.println("Length of lis is " + lis(0, -1, arr));
  }
}

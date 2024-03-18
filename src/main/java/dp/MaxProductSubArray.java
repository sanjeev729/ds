package dp;

public class MaxProductSubArray {

  static int maxProductSubArrayDP(int arr[]) {
    int min = 1, max = 1, maxProduct = 1;
    for (int i = 0; i < arr.length; i++) {
      int premax = Math.max(arr[i], Math.max(max * arr[i], min * arr[i]));
      min = Math.min(arr[i], Math.min(max * arr[i], min * arr[i]));
      max = premax;

      maxProduct = Math.max(maxProduct, max);


    }

    return maxProduct;
  }

  public static void main(String[] args) {
    int[] a = {-1, 2, -1, 6, -3};
    System.out.println("Maximum contiguous product is " + maxProductSubArrayDP(a));
  }
}

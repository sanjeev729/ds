package revise.leetcode75;



public class TwoSumII {

  /**
   * same as two sum only input is sorted
   * bruteforce way. binary search way
   * TC  O(N * logN)
   * SC  O(1)
   * @param arr
   * @param target
   * @return
   */
  public static int[] sum(int[] arr, int target) {

    for (int i = 0; i < arr.length; i++) {
      int diff = target - arr[i];
      int s = i + 1, e = arr.length - 1;
      while (s <= e) {
        int mid = s + (e - s) / 2;
        if (arr[mid] == diff) {
          return new int[]{i, mid};
        } else if (arr[mid] > diff) {
          e = mid - 1;
        } else {
          s = mid + 1;
        }
      }
    }
    return null;
  }

  /**
   * optimized approach using two pointers
   * TC  O(N)
   * SC  O(1)
   *
   * @param arr
   * @param target
   * @return
   */
  public static int[] sumOp(int[] arr, int target) {
    int i = 0, j = arr.length - 1;
    while (i <= j) {
      if ((arr[i] + arr[j]) < target) {
        i++;
      } else if ((arr[i] + arr[j]) > target) {
        j--;
      } else {
        return new int[]{i, j};
      }

    }
    return null;
  }


  public static void main(String[] args) {

    int[] arr = {1, 2, 3, 4, 5};

    for (int a : sumOp(arr, 9)) {
      System.out.println("a = " + a);

    }

    for (int a : sum(arr, 9)) {
      System.out.println("a = " + a);

    }
  }
}

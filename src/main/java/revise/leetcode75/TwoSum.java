package revise.leetcode75;


import java.util.HashMap;


public class TwoSum {

  /**
   * bruteforce way.
   *
   * @param arr
   * @param target
   * @return
   */
  public static int[] sum(int[] arr, int target) {

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if ((target - arr[i]) == arr[j]) {
          return new int[]{i, j};
        }
      }
    }
    return null;
  }

  /**
   * optimized approach
   *
   * @param arr
   * @param target
   * @return
   */
  public static int[] sumOp(int[] arr, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i <= arr.length; i++) {
      int diff = target - arr[i];
      if (map.containsKey(diff)) {
        return new int[]{map.get(diff), i};
      }
      map.put(arr[i], i);
    }
    return null;
  }


  public static void main(String[] args) {

    int[] arr = {2,1,9,6,3,4};

    for (int a : sumOp(arr, 7)) {
      System.out.println("a = " + a);

    }

    for (int a : sum(arr, 7)) {
      System.out.println("a = " + a);

    }
  }
}

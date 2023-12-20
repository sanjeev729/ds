package revise.leetcode75;

public class ProductAllExSelf {

  /**
   * TC O(N)
   * @param arr
   * @return
   */
  public static int[] product(int[] arr) {
    int[] result = new int[arr.length];
    int pre = 1, post = 1;

    for (int i = 0; i < arr.length; i++) {
      result[i] = pre;
      pre = arr[i] * pre;
    }

    for (int i = arr.length - 1; i >= 0; i--) {
      result[i] = result[i] * post;
      post = arr[i] * post;
    }

    return result;
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    int[] product = product(arr);
    for (int i = 0; i < product.length; i++) {
      System.out.println(product[i]);
    }
  }

}

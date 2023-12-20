package revise.leetcode75;

public class MergeInterChange {

  static int[] merge(int[] arr1, int[] arr2) {

    int[] combine = new int[arr1.length + arr2.length];

    int i = 0, j = 0, k = 0;
    boolean flag = true;
    while (i < arr1.length && j < arr2.length) {

      if (flag) {
        combine[k] = arr1[i];
        i++;
      } else {
        combine[k] = arr2[j];
        j++;
      }
      flag = !flag;
      k++;
    }

    while (i < arr1.length) {
      combine[k] = arr1[i];
      i++;
      k++;
    }

    while (j < arr2.length) {
      combine[k] = arr2[j];
      j++;
      k++;
    }

    return combine;

  }

  public static void main(String[] args) {
    int[] arr1 = {1, 2, 3, 4, 5, 10, 11, 1};
    int[] arr2 = {6, 7, 8, 9};

    int[] merger = merge(arr1, arr2);
    for (int a : merger) {
      System.out.print(a + " ");
    }

  }
}

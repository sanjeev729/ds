package Recursion;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class h2_Subsequences {

  private static void allSubsets(int i, int[] arr, List<Integer> temp, List<List<Integer>> ans) {

    //base case
    if (i >= arr.length) {
      ans.add(new ArrayList<>(temp));
      return;
    }

    //take
    temp.add(arr[i]);
    allSubsets(i + 1, arr, temp, ans);
    temp.remove(temp.size() - 1);
    //not take
    allSubsets(i + 1, arr, temp, ans);
  }

  private static void allSubsetsSumK(int i, int[] arr, List<Integer> temp, List<List<Integer>> ans, int sum) {

    //base case
    if (i >= arr.length) {
      if (sum == 0) {
        ans.add(new ArrayList<>(temp));
      }
      return;
    }

    if (arr[i] <= sum) {
    //take
    temp.add(arr[i]);
    allSubsetsSumK(i + 1, arr, temp, ans, sum - arr[i]);
    temp.remove(temp.size() - 1);
    }
    //not take
    allSubsetsSumK(i + 1, arr, temp, ans, sum);
  }

  private static void allSubsetsSumKMultiPick(int i, int[] arr, List<Integer> temp, List<List<Integer>> ans, int sum) {

    //base case
    if (i >= arr.length) {
      if (sum == 0) {
        ans.add(new ArrayList<>(temp));
      }
      return;
    }


    if (arr[i] <= sum) {
      //take
      temp.add(arr[i]);
      allSubsetsSumKMultiPick(i, arr, temp, ans, sum - arr[i]);
      temp.remove(temp.size() - 1);
    }
    //not take
    allSubsetsSumKMultiPick(i + 1, arr, temp, ans, sum);
  }

  /**
   * if there are duplicates in input array then also it will give only unique sets.
   * In this solution we are making only single call for every duplicate entry.
   * this approach is better than doing all subsets and later collecting all ans in set.
   *
   * @param ind
   * @param arr
   * @param temp
   * @param ans
   */
  private static void allSubsetsDistinct(int ind, int[] arr, List<Integer> temp, List<List<Integer>> ans) {
    ans.add(new ArrayList<>(temp));
    List<Integer> list = new ArrayList<>();
    for (int i = ind; i < arr.length; i++) {
      if (!list.contains(arr[i])) {
        list.add(arr[i]);
        temp.add(arr[i]);
        allSubsetsDistinct(i + 1, arr, temp, ans);
        temp.remove(temp.size() - 1);
      }
    }

  }

  /**
   * if there are duplicates in input array then also it will give only unique sets.
   * In this solution we are making only single call for every duplicate entry.
   * this approach is better than doing all subsets and later collecting all ans in set.
   */
  private static void allSubsetsDistinctSumK(int ind, int[] arr, List<Integer> temp, List<List<Integer>> ans, int sum) {
    if (sum == 0) {
      ans.add(new ArrayList<>(temp));
      return;
    }
    Set<Integer> set = new HashSet<>();
    for (int i = ind; i < arr.length; i++) {
      if (!set.contains(arr[i]) && (sum >= arr[i])) {
        set.add(arr[i]);
        temp.add(arr[i]);
        allSubsetsDistinctSumK(i + 1, arr, temp, ans, sum - arr[i]);
        temp.remove(temp.size() - 1);

      }
    }

  }


  /**
   * this works only if distinct elements are there.
   * TC--> O( N! * N )
   * SC--> O( N )
   * @param arr
   * @param temp
   * @param ans
   */
  private static void permuteI(int[] arr, List<Integer> temp, List<List<Integer>> ans) {
    if (temp.size() == arr.length) {
      ans.add(new ArrayList<>(temp));
      return;
    }

    for (int i = 0; i < arr.length; i++) {
      //skip the already picked element
      if (temp.contains(arr[i])) continue;
      //take the element
      temp.add(arr[i]);
      permuteI(arr, temp, ans);
      temp.remove(temp.size() - 1);
    }
  }

  /**
   * this works with duplicate elements also.
   * @param arr
   * @param temp
   * @param ans
   * @param freq
   */

  private static void permuteII(int[] arr, List<Integer> temp, List<List<Integer>> ans, boolean[] freq) {
    if (temp.size() == arr.length) {
      ans.add(new ArrayList<>(temp));
      return;
    }
    for (int i = 0; i < arr.length; i++) {
      if (!freq[i]) {
        // mark the element visited and take it
        freq[i] = true;
        temp.add(arr[i]);
        permuteII(arr, temp, ans, freq);
        temp.remove(temp.size() - 1);
        freq[i] = false;
      }
    }
  }


  public static void main(String[] args) {

    int[] arr = {1, 1,2,3};
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] freq = new boolean[10];
    Set<Integer> set = new HashSet<>();
    //allSubsets(0, arr, new ArrayList<Integer>(), ans);
    //allSubsetsSumK(0, arr, new ArrayList<Integer>(), ans, 5);
    //allSubsetsSumKMultiPick(0, arr, new ArrayList<Integer>(), ans, 5);
    allSubsetsDistinct(0, arr, new ArrayList<Integer>(), ans);
    //allSubsetsDistinctSumK(0, arr, new ArrayList<Integer>(), ans, 5);
   // permuteII(arr, new ArrayList<>(), ans, freq);
    System.out.println(ans);
   // ans = new ArrayList<>();
   // permuteI(arr, new ArrayList<>(), ans);
  //  System.out.println(ans);

  }

}

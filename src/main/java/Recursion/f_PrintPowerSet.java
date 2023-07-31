package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class f_PrintPowerSet {

  private static void printPowerSet(int[] arr, int i, List<Integer> output) {
    //for base case
    if (i >= arr.length) {
      System.out.println(output);
      return;
    }
    //add arr[i] for picked case
    output.add(arr[i]);
    printPowerSet(arr, i + 1, output);
    //remove arr[i] for not picked case
    output.remove(output.size() - 1);
    printPowerSet(arr, i + 1, output);
  }

  private static void printPowerSetsOfSumK(int[] arr, int sum, int i, List<Integer> output, int k) {
    //for base case
    if (i >= arr.length) {
      if (sum == k) {
        System.out.println(output);
      }
      return;
    }
    //add arr[i] for picked case
    output.add(arr[i]);
    sum = sum + arr[i];
    printPowerSetsOfSumK(arr, sum, i + 1, output, k);
    //remove arr[i] for not picked case
    output.remove(output.size() - 1);
    sum = sum - arr[i];
    printPowerSetsOfSumK(arr, sum, i + 1, output, k);
  }

  private static boolean printOnlyOneSetOfSumK(int[] arr, int sum, int i, List<Integer> output, int k) {
    //for base case
    if (i >= arr.length) {
      if (sum == k) {
        //condition satisfied
        System.out.println(output);
        return true;
      }
      //condition not satisfied
      return false;
    }
    //add arr[i] for picked case
    output.add(arr[i]);
    sum = sum + arr[i];
    if (printOnlyOneSetOfSumK(arr, sum, i + 1, output, k)) {
      return true;
    }
    //remove arr[i] for not picked case
    output.remove(output.size() - 1);
    sum = sum - arr[i];
    if (printOnlyOneSetOfSumK(arr, sum, i + 1, output, k)) {
      return true;
    }
    return false;
  }

  private static int countAllSetsOfSumK(int[] arr, int sum, int i, List<Integer> output, int k) {
    //for base case
    if (i >= arr.length) {
      if (sum == k) {
        //condition satisfied
        System.out.println(output);
        return 1;
      }
      //condition not satisfied
      return 0;
    }
    //add arr[i] for picked case
    output.add(arr[i]);
    sum = sum + arr[i];
    int l = countAllSetsOfSumK(arr, sum, i + 1, output, k);
    //remove arr[i] for not picked case
    output.remove(output.size() - 1);
    sum = sum - arr[i];
    int r = countAllSetsOfSumK(arr, sum, i + 1, output, k);
    return l + r;
  }

  private static void printPowerSet(String input, String output) {
    if (input.isEmpty()) {
      System.out.print(output + " ");
      return;
    }

    String outputWithoutChar = new String(output);
    String outputWithChar = new String(output);
    outputWithChar = outputWithChar + input.charAt(0);

    input = input.substring(1);

    printPowerSet(input, outputWithoutChar);
    printPowerSet(input, outputWithChar);

  }

  private static void printPowerSetUnique(String input, String output, Set<String> unique) {
    if (input.isEmpty()) {
      unique.add(output);
      return;
    }

    String outputWithoutChar = new String(output);
    String outputWithChar = new String(output);
    outputWithChar = outputWithChar + input.charAt(0);

    input = input.substring(1);

    printPowerSetUnique(input, outputWithoutChar, unique);
    printPowerSetUnique(input, outputWithChar, unique);

  }

  private static void combinationSum(int[] input, String aux, String output, int sum, int index) {
    if (index == input.length) {
      if (sum == 0) {
        System.out.print(aux + ",");
      }
      return;
    }
    StringBuilder str = new StringBuilder(aux);
    //check if sum can be reduced by current element or not
    if (input[index] <= sum) {
      str.append(input[index]);
      combinationSum(input, str.toString(), output, sum - input[index], index);
      str.deleteCharAt(str.length() - 1);
    }
    combinationSum(input, str.toString(), output, sum, index + 1);

  }

  public static void main(String[] args) {

    String ip = "1234";
    String out = "";
    Set<String> unique = new HashSet<>();
    // printPowerSet(ip, out);
    // System.out.println();
    // printPowerSetUnique(ip, out, unique);
    //System.out.println(unique);
    // System.out.println();
    int[] arr = {1, 2, 3};
    List<Integer> output = new ArrayList<>();
    // printPowerSet(arr,0,itr);
   System.out.println(countAllSetsOfSumK(arr, 0, 0, output, 3)) ;
    //combinationSum(arr, "", "", 6, 0);

  }

}

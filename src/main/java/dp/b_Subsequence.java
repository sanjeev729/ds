package dp;

public class b_Subsequence {

  public static boolean subSetCheck(int i, int target, int[] arr) {
    if (target == 0)
      return true;
    if (i == 0) {
      return arr[0] == target;
    }
    boolean nt = subSetCheck(i - 1, target, arr);
    boolean t = false;
    if (arr[i] <= target) {
      t = subSetCheck(i - 1, target - arr[i], arr);
    }
    return nt || t;
  }

  // DP way
  public static boolean subSetCheckDP(int n, int target, int[] arr) {
    boolean dp[][] = new boolean[n][target + 1];

    for (int i = 0; i < n; i++) {
      dp[i][0] = true;
    }
    dp[0][arr[0]] = true;

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < target + 1; j++) {
        boolean nt = dp[i - 1][j];
        boolean t = false;
        if (arr[i] <= j) {
          t = dp[i - 1][j - arr[i]];
        }
        dp[i][j] = nt || t;
      }
    }
    return dp[n - 1][target];
  }

  public static int subSetCount(int i, int target, int[] arr) {
    if (i == 0) {
      if (target == 0 || arr[0] == target)
        return 1;
      else
        return 0;
    }
    int nt = subSetCount(i - 1, target, arr);
    int t = 0;
    if (arr[i] <= target) {
      t = subSetCount(i - 1, target - arr[i], arr);
    }
    return nt + t;
  }

  public static int subSetCountDP(int n, int target, int[] arr) {
    int dp[][] = new int[n][target + 1];

    for (int i = 0; i < n; i++) {
      dp[i][0] = 1;
    }
    dp[0][arr[0]] = 1;

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < target + 1; j++) {
        int nt = dp[i - 1][j];
        int t = 0;
        if (arr[i] <= j) {
          t = dp[i - 1][j - arr[i]];
        }
        dp[i][j] = nt + t;
      }
    }
    return dp[n - 1][target];
  }

  public static void main(String[] args) {
    int arr[] = {3, 34, 4, 12, 5, 2};
    int target = 9;
    System.out.println(subSetCheck(arr.length - 1, target, arr));
    System.out.println(subSetCheckDP(arr.length, target, arr));
    System.out.println(subSetCount(arr.length - 1, target, arr));
    System.out.println(subSetCountDP(arr.length, target, arr));
  }

}

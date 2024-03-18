package dp;

public class a_StairsClimbing {
  // Q7.No of ways to climb n stairs
  public static int countWays(int n) {

    // checking if n<=3 will be our base condition
    if (n == 1)
      return 1; // climb 1 step

    if (n == 2)
      return 2; // (1,1),(2)

    if (n == 3) // (1,1,1),(1,2),(2,1),(3)
      return 4;

    return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
  }

  public static int countWays2(int n) {
    // base condition
    if (n <= 1)
      return 1; // climb 1 step

    return countWays2(n - 1) + countWays2(n - 2);
  }

  public static int countWaysDp(int n) {
    int dp[] = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  public static int countWays(int n, int k) {
    if (n <= 1)
      return 1; // climb 1 step
    int toatalways = 0;
    for (int j = 1; j <= k; j++) {
      if (n >= j) {
        toatalways += countWays(n - j);
      }
    }

    return toatalways;
  }

  // DP way
  public static int countWaysDP(int n) {
    int a[] = new int[n + 1];
    a[0] = 1;
    a[1] = 1;
    a[2] = 2;
    for (int i = 3; i <= n; i++) {
      a[i] = a[i - 1] + a[i - 2] + a[i - 3];
    }
    return a[n];
  }


  public static void main(String[] args) {
    int s = 3, m = 2;
    //System.out.println("Nuber of ways = " + countWays(s));
    System.out.println("Nuber of ways = " + countWaysDp(s));
    System.out.println("Nuber of ways = " + countWays2(s));
   // System.out.println("Nuber of ways = " + countWays(5,2));

  }

}

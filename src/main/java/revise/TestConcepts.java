package revise;

import java.util.Arrays;

public class TestConcepts {


  public static int ways(int i, int j) {
    if (i < 0 || j < 0) {
      return 0;
    }
    if (i == 0 && j == 0) {
      return 1;
    }

    int up = ways(i - 1, j);
    int left = ways(i, j - 1);
    return up + left;
  }

  public static int waysDP(int m, int n, int[][] dp) {
    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }

    for (int i = 0; i < n; i++) {
      dp[0][i] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        int up = dp[i - 1][j];
        int left = dp[i][j - 1];
        dp[i][j] = up + left;
      }

    }
    return dp[m - 1][n - 1];
  }

  public static int waysDP1(int m, int n, int[][] dp) {
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          dp[0][0] = 1;
          continue;
        }
        int left = 0;
        int up = 0;
        if (i > 0) up = dp[i - 1][j];
        if (j > 0) left = dp[i][j - 1];
        dp[i][j] = up + left;
      }
    }
    return dp[m - 1][n - 1];
  }

  public static int waysDPObstacle(int m, int n, int[][] mat, int[][] dp) {
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i > 0 && j > 0 && mat[i][j] == -1) {
          dp[i][j] = 0;
          continue;
        }
        if (i == 0 && j == 0) {
          dp[0][0] = 1;
          continue;
        }
        int left = 0;
        int up = 0;
        if (i > 0) up = dp[i - 1][j];
        if (j > 0) left = dp[i][j - 1];
        dp[i][j] = up + left;
      }
    }
    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    int mat[][] = {{0, 0, 0, 0},
            {0, 0, -1, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}};

    int m = 4;
    int n = 4;
    int dp[][] = new int[m][n];
    // Initialize the DP array with -1 to indicate uncomputed values
    for (int[] row : dp)
      Arrays.fill(row, -1);

    System.out.println(ways(m - 1, n - 1));
    System.out.println(waysDP(m, n, dp));
    System.out.println(waysDP1(m, n, dp));
    System.out.println(waysDPObstacle(m, n, mat, dp));
  }
}

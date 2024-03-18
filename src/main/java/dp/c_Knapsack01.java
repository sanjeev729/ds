package dp;

public class c_Knapsack01 {

	static int knapsack(int i, int W, int wt[], int val[]) {
		// Base Case
		if (i == 0) {
			if (wt[0] <= W)
				return val[0];
			else
				return 0;
		}
		int notTake = knapsack(i - 1, W, wt, val);
		int take = Integer.MIN_VALUE;
		if (wt[i] <= W) {
			take = val[i] + knapsack(i - 1, W - wt[i], wt, val);
		}
		return Math.max(take, notTake);
	}

	static int knapsackDP(int n, int W, int wt[], int val[]) {
		int dp[][] = new int[n][W + 1];

		for (int w = wt[0]; w <= W; w++) {
			dp[0][w] = val[0];
		}

		for (int i = 1; i < n; i++) {              //choice diagram
			for (int w = 0; w <= W; w++) {
				int notTake = dp[i - 1][w];
				int take = Integer.MIN_VALUE;
				if (wt[i] <= w) {
					take = val[i] + dp[i - 1][w - wt[i]];
				}
				dp[i][w] = Math.max(take, notTake);
			}
		}
		return dp[n - 1][W];
	}

	static int knapsackDP_OPZ1(int n, int W, int wt[], int val[]) {
		int prev[] = new int[W + 1];
		int curr[] = new int[W + 1];

		for (int w = wt[0]; w <= W; w++) {
			prev[w] = val[0];
		}

		for (int i = 1; i < n; i++) {
			for (int w = 0; w <= W; w++) {
				int notTake = prev[w];
				int take = Integer.MIN_VALUE;
				if (wt[i] <= w) {
					take = val[i] + prev[w - wt[i]];
				}
				curr[w] = Math.max(take, notTake);
			}
			prev = curr;
		}
		return prev[W];
	}

	static int knapsackDP_OPZ2(int n, int W, int wt[], int val[]) {
		int prev[] = new int[W + 1];

		for (int w = wt[0]; w <= W; w++) {
			prev[w] = val[0];
		}

		for (int i = 1; i < n; i++) {
			for (int w = W; w >= 0; w--) {
				int notTake = prev[w];
				int take = Integer.MIN_VALUE;
				if (wt[i] <= w) {
					take = val[i] + prev[w - wt[i]];
				}
				prev[w] = Math.max(take, notTake);
			}
		}
		return prev[W];
	}


	// Returns the maximum value that can be put in a knapsack of capacity W (0/1 Knapsack  : multiple occurrences of items are not allowed)
	static int knapSack01(int wt[], int val[], int W, int n) {
		int t[][] = new int[n + 1][W + 1];

		for (int i = 0; i < n + 1; i++) {              //initialization
			for (int j = 0; j < W + 1; j++) {     
				if (i == 0 || j == 0)
					t[i][j] = 0;
			}
		}

		for (int i = 1; i < n + 1; i++) {              //choice diagram
			for (int j = 1; j < W + 1; j++) {
				if (wt[i - 1] <= j)
					t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
				else
					t[i][j] = t[i - 1][j];
			}
		}

		return t[n][W];
	}
	
	//naive approach 2^n time complexity
	static int knapSackRC(int wt[], int val[], int W,int n) 
    { 
        // Base Case 
        if (n == 0 || W == 0) 
            return 0; 
  
       
        if(wt[n-1]<=W)
            return Math.max(val[n - 1] 
                       + knapSackRC( wt, 
                                  val,W - wt[n - 1], n - 1), 
                       knapSackRC( wt, val,W, n - 1));
        
		return  knapSackRC( wt, val,W, n - 1); 
    } 
	
	// Driver program to test above function
	public static void main(String args[]) {
		int val[] = new int[] { 1, 4, 5, 7 };
		int wt[] = new int[] { 1, 3, 4, 5 };
		int W = 7;
		int n = val.length;
		System.out.println(knapSack01( wt, val,W, n));
		System.out.println("----------------");
		System.out.println(knapSackRC( wt, val,W, n));
		System.out.println("----------------");
		System.out.println(knapsack(n - 1, W, wt, val));
		System.out.println("----------------");
		System.out.println(knapsackDP(n , W, wt, val));
		System.out.println("----------------");
		System.out.println(knapsackDP_OPZ1(n , W, wt, val));
		System.out.println("----------------");
		System.out.println(knapsackDP_OPZ2(n , W, wt, val));
	}
}
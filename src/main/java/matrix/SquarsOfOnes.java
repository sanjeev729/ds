package matrix;

public class SquarsOfOnes {

	/*
	 * Time Complexity: O(m*n) where m is number of rows and n is number of
	 * columns in the given matrix. Auxiliary Space: O(m*n) where m is number of
	 * rows and n is number of columns in the given matrix. Algorithmic
	 * Paradigm: Dynamic Programming
	 */

	public static int numberOfSquares(int[][] grid) {

		int[][] temp = new int[grid.length][grid[0].length];
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			temp[i][0] = grid[i][0];
			count += temp[i][0];

		}

		for (int j = 0; j < grid[0].length; j++) {
			temp[0][j] = grid[0][j];
			count += temp[j][0];
		}

		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					// get min from all three directions and add 1 to it
					temp[i][j] = 1 + Math.min(Math.min(temp[i - 1][j], temp[i][j - 1]), temp[i - 1][j - 1]);
					count += temp[i][j];
				}
			}
		}

		return count;
	}

	public static int maxSquareMatrix(int[][] grid) {

		int[][] temp = new int[grid.length][grid[0].length];
		int maxLength = 0;
		for (int i = 0; i < grid.length; i++) {
			temp[i][0] = grid[i][0];

		}

		for (int j = 0; j < grid[0].length; j++) {
			temp[0][j] = grid[0][j];
		}

		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					// get min from all three directions and add 1 to it
					temp[i][j] = 1 + Math.min(Math.min(temp[i - 1][j], temp[i][j - 1]), temp[i - 1][j - 1]);
					maxLength = Math.max(maxLength, temp[i][j]);
				}
			}
		}

		return maxLength;
	}

	public static void main(String[] args) {
	int A[][] = { { 0, 1, 1, 0, 1 },
				  { 1, 1, 0, 1, 0 },
				  { 0, 1, 1, 1, 0 },
				  { 1, 1, 1, 1, 0 },
				  { 1, 1, 1, 1, 1 },
				  { 0, 0, 0, 0, 0 } };
		System.out.println("Total no of squares " + numberOfSquares(A));
		System.out.print("maximum square size is " + maxSquareMatrix(A)+"*"+maxSquareMatrix(A));

	}

}

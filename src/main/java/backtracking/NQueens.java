package backtracking;

public class NQueens {

	public static void main(String[] args) {
		int board[][] = { { 0, 0, 0, 0 }, 
				          { 0, 0, 0, 0 }, 
				          { 0, 0, 0, 0 }, 
				          { 0, 0, 0, 0 } };
		/*
		 * Once you have place queen to current cell then no other queen can come in entire row,entire col, entire normal diagonal and
		 * entire reverse diagonal as we are moving row by row ,we know the next queen
		 * will be placed in the below row not the same row that why no need to
		 * check row.
		 */
		// only sr matrix of nxn
		int n = board.length;

		boolean [] cols = new boolean[n];
		// number of diagonals in nxn matrix = (2*n -1)
		boolean[] ndiag = new boolean[2 * n - 1];
		boolean[] rdiag = new boolean[2 * n - 1];

		solve(board, 0, cols, ndiag, rdiag, "");

	}
	
	/* A utility function to print grid */
	static void printGrid(int grid[][]) {
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++)
				System.out.printf("%2d", grid[row][col]);
			System.out.println();
		}
	}

	private static void solve(int[][] board, int row, boolean[] cols, boolean[] ndiag, boolean[] rdiag, String ans) {
		if (row == board.length) {
			//System.out.println(ans + ".");
			printGrid(board);
			System.out.println();
			return;
		}
		for (int col = 0; col < board[0].length; col++) {
			//(row,col) normal diagonal positions [row + col] and reverse diagonal positions [row - col + (board.length - 1)]
			if (cols[col] == false && ndiag[row + col] == false && rdiag[row - col + board.length - 1] == false) {
				board[row][col] = 1;
				cols[col] = true;
				ndiag[row + col] = true;
				rdiag[row - col + board.length - 1] = true;
				solve(board, row + 1, cols, ndiag, rdiag, ans + row + "-"+col+",");
				board[row][col] = 0;
				cols[col] = false;
				ndiag[row + col] = false;
				rdiag[row - col + board.length - 1] = false;
			}
			
			
		}
		
	}

}

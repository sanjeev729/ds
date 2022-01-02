package backtracking;

public class SudokuSolver {
	int N;
	int aux[];

	public SudokuSolver(int size) {
		N = size;
		aux = new int[2];
	}

	
	void solveSudoku(int grid[][], int i, int j) {
		// if i reaches out of bound it means we are done with all cells just
		// print the grid
		if (i == grid.length) {
			printGrid(grid);
			return;
		}

		int nextI = 0;
		int nextJ = 0;
		// get the next cell co-ordinate from the current cell
		if (j == grid[0].length - 1) {
			nextI = i + 1;
			nextJ = 0;
		} else {
			nextI = i;
			nextJ = j + 1;
		}

		if (grid[i][j] != 0) {
			solveSudoku(grid, nextI, nextJ); //no need to check if current cell has some number just move to the next cell.
		} else {
			for (int pos = 1; pos <= 9; pos++) {
				if (isSafe(grid, i, j, pos)) {
					grid[i][j] = pos;
					solveSudoku(grid, nextI, nextJ);
					grid[i][j] = 0;
				}
			}

		}
	}
		
	/*
	 * Returns a boolean which indicates whether it will be legal to assign val
	 * to the given row,col location.
	 */
	boolean isSafe(int grid[][], int i, int j, int val) {
		// check all rows if val is present
		for (int row = 0; row < grid.length; row++) {
			if (grid[row][j] == val) {
				return false;
			}
		}

		// check all cols if val is present
		for (int col = 0; col < grid[0].length; col++) {
			if (grid[i][col] == val) {
				return false;
			}
		}

		// check subMatrix if val is present
		// extreme top-left cell indexes of sub-matrix for each (i,j grid) row =(i / 3) * 3 ,col= (j / 3) * 3
		int smi = (i / 3) * 3;
		int smj = (j / 3) * 3;
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (grid[smi + row][smj + col] == val) {
					return false;
				}
			}
		}

		return true;
	}

	/* A utility function to print grid */
	void printGrid(int grid[][]) {
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++)
				System.out.printf("%2d", grid[row][col]);
			System.out.println();
		}
	}

	/* Driver Program to test above functions */
	public static void main(String a[]) {
		// 0 means unassigned cells
		int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
				         { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
				         { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				         { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
				         { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
				         { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				         { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
				         { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				         { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		SudokuSolver ss = new SudokuSolver(grid.length);
		ss.solveSudoku(grid,0,0); //start filling from top-left corner
		

	}
}

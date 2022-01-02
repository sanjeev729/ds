package matrix;

public class WallsAndGates {
	      //O(ROW x COL)
	public  void wallsAndGates(int[][] grid) {
				for (int i = 0; i < grid.length; i++) {
					for (int j = 0; j < grid[0].length; j++) {
						if (grid[i][j] == 0) {
							dfs(grid,i,j,0);
						}
					}
				}
			}
			
	public void dfs(int[][] grid, int i, int j, int count) {

		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] < count) {
			return;
		}

		grid[i][j] = count; // current nodes's count
		dfs(grid, i + 1, j, count + 1); // right
		dfs(grid, i - 1, j, count + 1); // left
		dfs(grid, i, j + 1, count + 1); // below
		dfs(grid, i, j - 1, count + 1);// above
		//dfs(grid, i + 1, j + 1, count + 1);
		//dfs(grid, i - 1, j - 1, count + 1);
		//dfs(grid, i + 1, j - 1, count + 1);
		//dfs(grid, i - 1, j + 1, count + 1);

	}

	public static void main(String[] args) {
	     int[][] mat=  { {1000,  -1 , 0 , 1000},
	    		         {1000, 1000 ,1000 , -1},
	    		         {1000 , -1 ,1000,  -1},
	    		         {0 , -1, 1000 ,1000 } };
			WallsAndGates n=new WallsAndGates();
			n.wallsAndGates(mat);
			
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat[0].length; j++) {
					System.out.print(mat[i][j]+" ");
				}
				System.out.println();
			}
		
		}
}

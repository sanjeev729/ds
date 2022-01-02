package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	//up down right left dDR dUR dDL dUL
	//int[][] directions={{-1,0},{1,0},{0,1},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}} ;
	int[][] directions={{-1,0},{1,0},{0,1},{0,-1}} ;
	
	//O(ROW x COL)
	public  int numIslands(int[][] grid) {
		int islandCount = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					islandCount += dfs(grid, i, j);
				}
			}
		}
		return islandCount;
	}
	
	public int dfs(int[][] grid, int i, int j) {

		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
			return 0;
		}

		grid[i][j] = 0; // visit and sink the island
		
		for (int[] dir : directions) {
			int x = dir[0] + i;
			int y = dir[1] + j;
			dfs(grid, x, y);

		}

		/*dfs(grid, i + 1, j); // right
		dfs(grid, i - 1, j); // left
		dfs(grid, i, j + 1); // below
		dfs(grid, i, j - 1);// above
		dfs(grid, i + 1, j + 1);
		dfs(grid, i - 1, j - 1);
		dfs(grid, i + 1, j - 1);
		dfs(grid, i - 1, j + 1);*/

		return 1;

	}
	
	
	//O(ROW x COL)
		public  int numIslandsBFS(int[][] grid) {
			int islandCount = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					if (grid[i][j] == 1) {
						islandCount += bfs(grid, i, j);
					}
				}
			}
			return islandCount;
		}
	
	private int bfs(int[][] grid, int i, int j) {

		Queue<Integer> q = new LinkedList<>();
		int cols = grid[0].length;
		int index = i * cols + j; // 2d to 1d conversion
		q.add(index);
		grid[i][j] = 0; // sink the island
		while (!q.isEmpty()) {
			Integer item = q.poll();
			int row = item / cols;  // 1d to 2d conversion
			int col = item % cols;
			for (int[] dir : directions) {
				int x = dir[0] + row;
				int y = dir[1] + col;
				if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
					grid[x][y] = 0; //sink the new island
					q.add(x * cols + y);  // 2d to 1d conversion
				}
			}
		}
		return 1;
	}


	
	//O(ROW x COL)
		public  int islandWithMaxArea(int[][] grid) {
			int maxArea = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					if (grid[i][j] == 1) {
						maxArea=Math.max(maxArea,dfs2(grid,i,j));
					}
				}
			}
			return maxArea;
		}
		
	public int dfs2(int[][] grid, int i, int j) {

		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
			return 0;
		}

		grid[i][j] = 0; // visit and sink the island
		int count = 1; // current nodes's count
		
		for (int[] dir : directions) {
			int x = dir[0] + i;
			int y = dir[1] + j;
			count += dfs2(grid, x, y);

		}
		/*count += dfs2(grid, i + 1, j); // right
		count += dfs2(grid, i - 1, j); // left
		count += dfs2(grid, i, j + 1); // below
		count += dfs2(grid, i, j - 1);// above
		count += dfs2(grid, i + 1, j + 1);
		count += dfs2(grid, i - 1, j - 1);
		count += dfs2(grid, i + 1, j - 1);
		count += dfs2(grid, i - 1, j + 1);*/

		return count;

	}
	
	//O(ROW x COL)
		public  int numColsedIslands(int[][] grid) {
			int islandCount = 0;
		for (int i = 1; i < grid.length - 1; i++) {
			for (int j = 1; j < grid[0].length - 1; j++) {
				if (grid[i][j] == 1 && isClosedIsland(grid, i, j)) {
					islandCount++;
				}
			}
		}
			return islandCount;
		}

	private boolean isClosedIsland(int[][] grid, int i, int j) {
		// 1=land
		// 0=water
		// -1=visited
		if (grid[i][j] == -1 || grid[i][j] == 0)
			return true;

		if (isOnboundary(grid, i, j))
			return false;

		grid[i][j] = -1;

		boolean right = isClosedIsland(grid, i + 1, j); // right
		boolean left = isClosedIsland(grid, i - 1, j); // left
		boolean down = isClosedIsland(grid, i, j + 1); // down
		boolean up = isClosedIsland(grid, i, j - 1);// up

		return up && down && right && left;

	}

	private boolean isOnboundary(int[][] grid, int i, int j) {
		
		return i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1;
		
	}
	
	// O(ROW x COL)
	public int getMaxGold(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length]; //visited is needed so that not to stuck in looping condition as we can't modify grid only visited array is the way.
		//int[][] cache = new int[grid.length][grid[0].length];
		int maxGold = Integer.MIN_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] > 0) {
					//int gold = findMaxGoldWithCache(grid, cache,visited, i, j);
					int gold = findMaxGold(grid,visited, i, j);
					maxGold = Math.max(maxGold, gold);
				}
			}
		}
		return maxGold;
	}

	public int findMaxGold(int[][] grid, boolean[][] visited, int i, int j) {
		// 1)out of bound
		// 2)set visited[i][j]=true
		// 3)check all neighbors
		// 4)once done with a cell completely set visited[i][j] back to false

		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j] == true) {
			return 0;
		}

		visited[i][j] = true; // visit and sink the island

		int right = findMaxGold(grid, visited, i + 1, j); // right
		int left = findMaxGold(grid, visited, i - 1, j); // left
		int down = findMaxGold(grid, visited, i, j + 1); // down
		int up = findMaxGold(grid, visited, i, j - 1);// up
		
		visited[i][j] = false;

		return Math.max(right, Math.max(left, Math.max(down, up))) + grid[i][j];

	}
	
	public int findMaxGoldWithCache(int[][] grid, int[][] cache, boolean[][] visited, int i, int j) {
		// 1)out of bound
		// 2)set visited[i][j]=true
		// 3)check all neighbors
		// 4)once done with a cell completely set visited[i][j] back to false
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j] == true) {
			return 0;
		}
		
		if (cache[i][j] != 0) {
			return cache[i][j];
		}

		visited[i][j] = true; // visit and sink the island

		int right = findMaxGoldWithCache(grid, cache, visited, i + 1, j); // right
		int left = findMaxGoldWithCache(grid, cache, visited, i - 1, j); // left
		int down = findMaxGoldWithCache(grid, cache, visited, i, j + 1); // down
		int up = findMaxGoldWithCache(grid, cache, visited, i, j - 1);// up

		visited[i][j] = false;

		return cache[i][j] = Math.max(right, Math.max(left, Math.max(down, up))) + grid[i][j];

	}
	
	// O(ROW x COL)
		public int getMaxIncreasingPathLen(int[][] grid) {
			//visited array is not needed as in this situation there is no way to stuck into looping condition as we are only moving if target cell is greater than current cell.
			int[][] cache = new int[grid.length][grid[0].length];
			int maxLen = Integer.MIN_VALUE;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					if (grid[i][j] > 0) {
						int len = getMaxIncLength(grid, cache, i, j);
						maxLen = Math.max(maxLen, len);
					}
				}
			}
			return maxLen;
		}
		
	public int getMaxIncLength(int[][] grid, int[][] cache, int i, int j) {
		
		if (cache[i][j] > 0) {
			return cache[i][j];
		}

		int max = 0;
		for (int[] dir : directions) {
			int x = dir[0] + i;
			int y = dir[1] + j;

			if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] > grid[i][j]) {
				int longest = getMaxIncLength(grid, cache, x, y);
				max = Math.max(max, longest);
			}
		}
		cache[i][j] = max + 1;
		return cache[i][j];
	}

	public static void main(String[] args) {
		int[][] mat= {{ 1, 0, 1, 0, 0, 0, 1, 1, 1, 1 },
	            { 0, 0, 1, 0, 1, 0, 1, 0, 0, 0 },
	            { 1, 1, 1, 1, 0, 0, 1, 0, 0, 0 },
	            { 1, 0, 0, 1, 0, 1, 0, 0, 0, 0 },
	            { 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
	            { 0, 1, 0, 1, 0, 0, 1, 1, 1, 1 },
	            { 0, 0, 0, 0, 0, 1, 1, 1, 0, 0 },
	            { 0, 0, 0, 1, 0, 0, 1, 1, 1, 0 },
	            { 1, 0, 1, 0, 1, 0, 0, 1, 0, 0 },
	            { 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 }};
		NumberOfIslands n=new NumberOfIslands();
		System.out.println(String.format("Numbers of islands : %d", n.numIslands(mat)));
		
		int[][] mat3= {{ 1, 0, 1, 0, 0, 0, 1, 1, 1, 1 },
	            { 0, 0, 1, 0, 1, 0, 1, 0, 0, 0 },
	            { 1, 1, 1, 1, 0, 0, 1, 0, 0, 0 },
	            { 1, 0, 0, 1, 0, 1, 0, 0, 0, 0 },
	            { 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
	            { 0, 1, 0, 1, 0, 0, 1, 1, 1, 1 },
	            { 0, 0, 0, 0, 0, 1, 1, 1, 0, 0 },
	            { 0, 0, 0, 1, 0, 0, 1, 1, 1, 0 },
	            { 1, 0, 1, 0, 1, 0, 0, 1, 0, 0 },
	            { 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 }};
		NumberOfIslands n1=new NumberOfIslands();
		System.out.println(String.format("Numbers of islands BFS: %d", n1.numIslandsBFS(mat3)));
		
		int[][] mat2= {{ 1, 0, 1, 0, 0, 0, 1, 1, 1, 1 },
	            { 0, 0, 1, 0, 1, 0, 1, 0, 0, 0 },
	            { 1, 1, 1, 1, 0, 0, 1, 0, 0, 0 },
	            { 1, 0, 0, 1, 0, 1, 0, 0, 0, 0 },
	            { 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
	            { 0, 1, 0, 1, 0, 0, 1, 1, 1, 1 },
	            { 0, 0, 0, 0, 0, 1, 1, 1, 0, 0 },
	            { 0, 0, 0, 1, 0, 0, 1, 1, 1, 0 },
	            { 1, 0, 1, 0, 1, 0, 0, 1, 0, 0 },
	            { 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 }};
		System.out.println(String.format("Island with max Area : %d", n.islandWithMaxArea(mat2)));
		
		int[][] goldSite={{ 0, 6, 0 },
	                  { 5, 8, 7 },
	                  { 0, 9, 0}};
		System.out.println(String.format("max gold : %d", n.getMaxGold(goldSite)));
		
		int[][] matrix4={{ 3, 4, 5 },
                { 3, 2, 6 }};
	System.out.println(String.format("max path : %d", n.getMaxIncreasingPathLen(matrix4)));
		
	   }
	}
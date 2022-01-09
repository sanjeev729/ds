package tryexample;

public class Matrix {
    public int countIslands(int[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    dfs(i, j, arr);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, int[][] arr) {
        if ((i < arr.length && i >= 0) && (j < arr[0].length && j >= 0) && (arr[i][j] == 1)) {
            arr[i][j] = -1;
            dfs(i + 1, j, arr);
            dfs(i, j + 1, arr);
            dfs(i - 1, j, arr);
            dfs(i, j - 1, arr);
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 0, 1},
                {0, 1, 1},
                {1, 0, 1}};

        Matrix matrix = new Matrix();
        System.out.println(matrix.countIslands(mat));
    }
}

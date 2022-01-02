package matrix;

public class Rotate {
	
	//Valid for NxN grid only and TC: O(NxN)
	public void rotate90(int[][] matrix) {  //CLOCKWISE
		int lo = 0;
		int hi = matrix.length - 1;

		while (lo < hi) {
			int length = hi - lo;
			for (int i = 0; i < length; i++) {
				swap(matrix, lo, lo + i, lo + i, hi);  
				swap(matrix, lo, lo + i, hi, hi - i);
				swap(matrix, lo, lo + i, hi - i, lo);
			}
			lo++;
			hi--;
		}
	}
	
	//Valid for NxN grid only and TC: O(NxN)
		public void rotate90Anti(int[][] matrix) {  //Anti-CLOCKWISE
			int lo = 0;
			int hi = matrix.length - 1;

			while (lo < hi) {
				int length = hi - lo;
			for (int i = 0; i < length; i++) {
				swap(matrix, lo, hi - i, lo + i, lo);
				swap(matrix, lo, hi - i, hi, lo + i);
				swap(matrix, lo, hi - i, hi - i, hi);
			}
				lo++;
				hi--;
			}
		}
	
	public void rotate180(int[][] matrix) {
		int lo = 0;
		int hi = matrix.length - 1;

		while (lo < hi) {
			int length = hi - lo;
			for (int i = 0; i < length; i++) {
				swap(matrix, hi, hi - i, lo, lo + i);
				swap(matrix, lo + i, hi, hi - i, lo);
			}
			lo++;
			hi--;
		}
	}

	private void swap(int[][] matrix, int i, int j, int k, int l) {
		int temp = matrix[i][j];
		matrix[i][j] = matrix[k][l];
		matrix[k][l] = temp;

	}

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3, 4 },
				           { 5, 6, 7, 8 },
				           { 9, 10, 11, 12 },
				           { 13, 14, 15, 16 }
				           };
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("---- After rotaion-----");
		Rotate r = new Rotate();
		r.rotate90(matrix);  //clockwise
		//r.rotate90Anti(matrix); //anti-clockwise
		
	/*	r.rotate180(matrix);   OR  r.rotate90(matrix);
		                           r.rotate90(matrix);*/

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");

			}
			System.out.println();
		}
		
		
	}

}

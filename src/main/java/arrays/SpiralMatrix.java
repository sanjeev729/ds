package arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	static List<Integer> printMatrixSpiral(int arr[][]) {
		List<Integer> ans=new ArrayList<>();
		int top=0;
		int bottom=arr.length-1;
		int left=0;
		int right=arr[0].length-1;
		int size=arr.length*arr[0].length;
		while (ans.size() < size) {

			for (int i = left; i <= right && ans.size() < size; i++) {
				ans.add(arr[top][i]);
			}
			top++;
			
			for (int i = top; i <= bottom && ans.size() < size; i++) {
				ans.add(arr[i][right]);
			}
			right--;
			
			for (int i = right; i >= left && ans.size() < size; i--) {
				ans.add(arr[bottom][i]);
			}
			bottom--;
			
			for (int i = bottom; i >= top && ans.size() < size; i--) {
				ans.add(arr[i][left]);
			}
			left++;

		}
		
		return ans;
		
	}

	public static void main(String[] args) {
		 int a[][] = { { 1, 2, 3, 4 },
                       { 5, 6, 7, 8 },
                       { 9, 10, 11, 12 },
                       { 13, 14, 15, 16 } };
		 
		 System.out.println(printMatrixSpiral(a));
	}

}

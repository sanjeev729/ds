package arrays.oneToN;

public class SwapSort {

	public static void main(String[] args) {
		int arr[] = { 3,5,3,1,4,1 };
		swapSort(arr);
		
		for (int i : arr) {
			System.out.print(i+" ");
		}

		getMissingAndDuplicate(arr);
	}

	private static void getMissingAndDuplicate(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != i + 1) {
				System.out.println("Missing : " + (i + 1));
				System.out.println("Duplicate : " + arr[i]);
			}
		}
	}

	private static void swapSort(int[] arr) {
		int i = 0;
		while (i < arr.length) {
			if (arr[i] != arr[arr[i] - 1]) {
				swap(arr, i, arr[i] - 1);
			} else {
				i++;
			}
		}

	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
}

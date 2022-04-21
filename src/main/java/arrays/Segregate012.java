package arrays;

public class Segregate012 {

    void segregate012(int a[], int size) {

        int lo = 0, hi = size - 1;
        int mid = 0;

        while (mid <= hi) {
            switch (a[mid]) {
                case 0: {
                    int temp = a[lo]; // swap(a[low],a[mid])
                    a[lo] = a[mid];
                    a[mid] = temp;
                    lo++; // low++ mid++
                    mid++;
                    break;
                }
                case 1:
                    mid++; // mid++
                    break;
                case 2: {
                    int temp = a[mid]; // swap(a[mid],a[high])
                    a[mid] = a[hi];
                    a[hi] = temp;
                    hi--; // high--
                    break;
                }
            }
        }

    }

    void segregate012Util(int arr[]) {

        int lo_boundry = 0, hi_boundry = arr.length - 1;
        int i = 0;

        while (i < hi_boundry) {
            if (arr[i] == 0) {
                swap(arr, i, lo_boundry);
                lo_boundry++;
                i++;
            } else if (arr[i] == 2) {
                swap(arr, i, hi_boundry);
                hi_boundry--;
            } else {
                i++;
            }
        }

    }

    private void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }


    /* Driver Program to test above functions */
    public static void main(String[] args) {
        Segregate012 seg = new Segregate012();
        int arr[] = new int[]{0, 1, 2, 0, 1, 1, 2, 1, 1, 2, 2, 0};
        int i, arr_size = arr.length;
       // seg.segregate012(arr, arr_size);
        seg.segregate012Util(arr);

        System.out.print("Array after segregation is ");
        for (i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

    }

}

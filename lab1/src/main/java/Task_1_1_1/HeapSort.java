package Task_1_1_1;

public class HeapSort {
//    int[] heap;
//    public HeapSort(int s) {
//        this.heap = new int[s];
//    }
    public static void sort(int[] arr) {

        int size = arr.length;

        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(arr, size, i);

        for (int i = size - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int size, int i) {
        int max = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < size && arr[l] > arr[max])
            max = l;

        if (r < size && arr[r] > arr[max])
            max = r;

        if (max != i) {
            int t = arr[i];
            arr[i] = arr[max];
            arr[max] = t;

            heapify(arr, size, max);
        }
    }
}

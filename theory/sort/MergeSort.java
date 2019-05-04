public class MergeSort {
    public static void main(String... args) {

    }

    static void mergeSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;

        int mid = (lo + hi) >>> 1;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    static void merge(int[] arr, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        while (i <= mid && j <= hi) {
            if (arr[i] > arr[j]) {
                swap(arr, i, j);
            }
            i++;
        }
    }
}

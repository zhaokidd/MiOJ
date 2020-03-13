package src.common.sort;

public class MergeSortPractice {
    public static void main(String[] args) {
        int[] a = new int[]{7, 6, 3, 8, 1, 2, 9, 0};
        mergeSort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
    }

    private static void mergeSort(int[] arr){
        int len = arr.length;
        int [] result = new int[len];
        mergeSortRecursive(arr, result, 0, len - 1);
    }

    private static void mergeSortRecursive(int[] arr, int[] result,
                                           int start, int end) {
        if (end <= start) {
            return;
        }

        int mid = (end + start) >> 1;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        mergeSortRecursive(arr, result, start1, end1);
        mergeSortRecursive(arr, result, start2, end2);

        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }

        while (start1 <= end1) {
            result[k++] = arr[start1++];
        }

        while (start2 <= end2) {
            result[k++] = arr[start2++];
        }

        for (k = start; k <= end; k++)
            arr[k] = result[k];
    }
}

package src.common.sort;

public class QuickSortPractice {
    public static void main(String[] args) {
        int a[] = new int[]{4, 5, 2, 1, 9, 7};

        quickSort(a,0,a.length-1);

        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }
    }


    private static void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int base = array[low];

        //base值在low处
        while (low < high) {
            while (low < high && array[high] >= base) high--;
            if (low < high) {
                switchElement(array, low, high);
                low++;
            }

            while (low < high && array[low] < base) low++;
            if (low < high) {
                switchElement(array, low, high);
                high--;
            }
        }

        quickSort(array, 0, low - 1);
        quickSort(array, low + 1, high);
    }

    private static void switchElement(int[] array, int indexA, int indexB) {
        int temp = array[indexB];
        array[indexB] = array[indexA];
        array[indexA] = temp;
    }
}

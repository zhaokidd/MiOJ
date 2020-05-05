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

        //base值在low处.从右边的high坐标开始向low方向遍历，遇到小于base的情况停止，交换low和high两个坐标(初始时low在base位置.)
        while (low < high) {
            while (low < high && array[high] >= base) high--;
            if (low < high) {
                switchElement(array, low, high);
                low++;
            }

            //从low坐标开始向high遍历，遇到大于base的元素停止，然后交换low和high位置元素.
            while (low < high && array[low] < base) low++;
            if (low < high) {
                switchElement(array, low, high);
                high--;
            }
        }

        //最终停止的位置就是base元素，再以base元素做划分，对base元素两侧分别做排序.
        quickSort(array, 0, low - 1);
        quickSort(array, low + 1, high);
    }

    private static void switchElement(int[] array, int indexA, int indexB) {
        int temp = array[indexB];
        array[indexB] = array[indexA];
        array[indexA] = temp;
    }
}

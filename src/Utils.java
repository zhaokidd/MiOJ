public class Utils {
    /**
     * 解析输入的一行文本，例如: 1,2,3,4,5,6
     * 得到分隔的数字数组
     *
     * @param inputLine 输入的字符串
     * @return int型数组
     */
    public static int[] getIntArray(String inputLine) {
        if (inputLine == null || inputLine.length() <= 0)
            return null;

        String[] splitNumberStringArray = inputLine.split(",");
        int[] splitIntArray = new int[splitNumberStringArray.length];

        for (int i = 0; i < splitNumberStringArray.length; i++) {
            try {
                splitIntArray[i] = Integer.valueOf(splitNumberStringArray[i]);
            } catch (Exception e) {
                splitIntArray[i] = -1;
                System.out.println("Exception occurs when integer converts" + e.getStackTrace().toString());
            }
        }

        return splitIntArray;
    }


    //{@merge sort start

    /**
     * 归并排序
     */
    private static void mergeSort(int[] a) {
        int[] temp = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    /**
     * 排序方法
     * 用分治的方法将数组分为小的区块,然后在进行交换排序。
     */
    private static void sort(int[] a, int low, int high) {
        if (a == null || a.length <= 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;
        System.out.println("[low]:" + low + "[high]:" + high + "[mid]:" + mid);
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    /**
     * 对sort的结果进行合并
     */
    private static void merge(int[] a, int low, int mid, int high) {
        int[] tmpArr = new int[a.length];

        int leftLow = low, leftHigh = mid, rightLow = mid + 1, rightHigh = high;
        int tmpPos = low;

        while (leftLow <= leftHigh && rightLow <= rightHigh) {
            if (a[leftLow] <= a[rightLow])
                tmpArr[tmpPos++] = a[leftLow++];
            else
                tmpArr[tmpPos++] = a[rightLow++];
        }

        //剩余的放入数组中
        while (leftLow <= leftHigh) {
            tmpArr[tmpPos++] = a[leftLow++];
        }

        while (rightLow <= rightHigh) {
            tmpArr[tmpPos++] = a[rightLow++];
        }


        //将tmp数组中的内容拷贝回原数组中
        for (int k = low; k <= high; k++) {
            a[k] = tmpArr[k];
        }
    }
    //merge sort end @}

    /**
     * test
     */
    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 6, 7, 8, 9};

        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k] + ",");
        }
        System.out.print("\n");

        mergeSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.print("\n");

    }
}

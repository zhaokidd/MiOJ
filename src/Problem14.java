import java.util.Scanner;

/**
 * 在一个有序的经过旋转的数组里查找一个数
 *
 * 一个有序的数组,经过未知次数的旋转.从中查找一个目标值,如果存在,则返回其下标.
 *
 * 核心仍然是用二分法实现查找，但关键点是mid游标的选取，不能简单的去取中间数，而是要查找波峰值.
 *
 * */
public class Problem14 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            String[] array = line.split(" ");
            String[] numbers = array[0].split(",");
            int[] a = new int[numbers.length];
            int num = Integer.parseInt(array[1]);

            for(int i=0;i<a.length;i++){
                a[i] = Integer.parseInt(numbers[i]);
            }

            System.out.println(flipBinarySearch(a,num));
        }
    }

    /**
     * 查找翻转有序数组中的对应值的序号
     * */
    private static int flipBinarySearch(int[] a,int num) {
        int mid = findMidNum(a);

        if (num <= a[mid] && num >= a[0]) {
            return binarySearch(a, 0, mid, num);
        } else {
            return binarySearch(a, mid + 1, a.length-1, num);
        }

    }

    /**
     * @param a 原始数组
     * @param num 要查找的目标值
     * */
    private static int binarySearch(int[] a, int low, int high, int num) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (num < a[mid]) {
            return binarySearch(a, low, mid, num);
        } else if (num > a[mid]) {
            return binarySearch(a, mid + 1, high, num);
        } else {
            return mid;
        }

    }

    /**
     * find the divide position,a[pos]>a[pos+1]
     */
    private static int findMidNum(int[] a){
        int dividePos = -1;

        for (int i = 0; i < a.length-1; i++) {
            if(a[i]>a[i+1]){
                dividePos = i;
                break;
            }
        }

        if(dividePos<0){
            dividePos = (a.length)/2;
        }

        return dividePos;
    }
}

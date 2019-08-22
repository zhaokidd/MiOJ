import java.util.Scanner;

/***
 *
 * 找出k个数中出现频率最高的前m个数。
 * 方法１：
 * */
public class Problem13 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            String[] arrays = line.split(" ");

            if (arrays == null || arrays.length < 2) {
                continue;
            }

            String numberString = arrays[0];


            int count = Integer.valueOf(arrays[1]);

            //split the data
            String[] numberCharacters = numberString.split(",");
            int[] numberIntegers = new int[numberCharacters.length];
            for (int i = 0; i < numberCharacters.length; i++) {
                numberIntegers[i] = Integer.valueOf(numberCharacters[i]);
            }

            //Get the biggest k element
            Number biggestNumber = sortFrequentNumber(numberIntegers);
            for (int n = 0; n < count; n++) {
                if ((n + 1) < count) {
                    System.out.print(biggestNumber.value + ",");
                } else {
                    System.out.print(biggestNumber.value + "");
                }
                biggestNumber = biggestNumber.next;
            }

            // System.out.println("answer");
        }
    }


    /**
     * structure of the array to sort
     */
    static class Number {
        int value;
        int count;

        Number next;
        Number prev;
    }

    private static Number sortFrequentNumber(int[] elements) {
        int pre = elements[0];
        int cur = pre;
        int count = 0;

        Number head = new Number();
        head.value = cur;
        head.count = 0;
        head.next = head;
        head.prev = head;

        for (int i = 0; i < elements.length; i++) {
            cur = elements[i];
            if (cur == pre) {
                count++;
                if ((i + 1) >= elements.length) {
                    Number newElement = new Number();
                    newElement.value = cur;
                    newElement.count = count;
                     head = insertAndSortNumber(head, newElement);

                }
            } else {
                if (pre != head.value) {
                    Number newElement = new Number();
                    newElement.value = pre;
                    newElement.count = count;
                    head = insertAndSortNumber(head, newElement);
                } else {
                    head.count = count;
                }


                count = 1;
                pre = cur;

                //record last element because there is no extra element after last
                if ((i + 1) >= elements.length) {
                    Number last = new Number();
                    last.value = cur;
                    last.count = count;
                    head = insertAndSortNumber(head, last);
                }
            }
        }

        return head;
    }

    /**
     * 将新的number对象插入到数组中。
     * 按照count大小升序排列，count相同时比较value大小，value值较小的排在前列。
     */
    private static Number insertAndSortNumber(Number head, Number node) {
        Number cur = head;

        do {
            if (node.count > cur.count || (node.count == cur.count && node.value < cur.value)) {
                Number temp = cur.prev;
                temp.next = node;
                node.prev = temp;
                cur.prev = node;
                node.next = cur;

                if(cur==head){
                    head = node;
                }
                break;
            }
            cur = cur.next;
        } while (cur != head);

        //如果cur游标回到head，说明没找到合适的插入点，需要头插在head之前,倒数第一位。
        if (cur == head) {
            Number temp = cur.prev;
            temp.next = node;
            node.prev = temp;
            head.prev = node;
            node.next = cur;
        }

        return head;
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


}
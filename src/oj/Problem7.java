package oj;

import java.util.Scanner;

/**
 * 给出一个无序的数列，找出其中第一个缺失的正数，例如[3,4,-1,1],缺失的第一个正数为２
 */
public class Problem7 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            int[] numbers = getIntArray(line);
            int max = 1, min = Integer.MAX_VALUE, count = 0;
            //1.第一次遍历，先获取正数的个数及最大值。
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] > 0) {
                    count++;
                    if (numbers[i] < min) {
                        min = numbers[i];
                    } else if (numbers[i] >= max) {
                        max = numbers[i];
                    }
                }
            }

            //2.第二次遍历，建一个大小为(max-min)的桶。然后遍历numbers数组，将numbers数组中的数放入桶中。
            int[] barrel = new int[max];
            for (int k = 0; k < numbers.length; k++) {
                if (numbers[k] > 0) {
                    barrel[numbers[k] - 1] = barrel[numbers[k] - 1] + 1;
                }
            }

            //3.第三次遍历，判断哪个位置首先出现空桶，就说明缺失的第一个正数在哪儿
            boolean finded = false;
            for (int j = 0; j < barrel.length; j++) {
                if (barrel[j] <= 0) {
                    finded = true;
                    System.out.println(j + 1);
                    break;
                }
            }
            if (!finded) {
                System.out.println(barrel.length + 1);
            }
        }
    }


    /**
     * 解析输入的一行文本，例如: 1,2,3,4,5,6
     * 得到分隔的数字数组
     *
     * @param inputLine 输入的字符串
     * @return int型数组
     */
    private static int[] getIntArray(String inputLine) {
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
}

package oj;

import sun.awt.image.BufferedImageDevice;

import java.awt.image.BufferedImage;
import java.util.Scanner;

/**
 * 类型：排序
 *
 * 描述：一个旋转后的有序数组序列，找到数组的中间值位置。
 *
 * 例如: 4,6,7,0,1,2,3。中间值为3，其位置为index=6;
 * */
public class Problem5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            //读取序列中的所有数字
            line = scan.nextLine().trim();
            String[] numbers = line.split(",");
            int[] integerNumbers = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                integerNumbers[i] = Integer.valueOf(numbers[i]);
            }

            //遍历数组，找到整个有序序列中的最小值。数组旋转后，只需看做循环链表，其仍是有序排列。
            int lowestIndex = 0;
            for (int k = 1; k < integerNumbers.length; k++) {
                if (integerNumbers[k] < integerNumbers[k - 1]) {
                    lowestIndex = k;
                }
            }

            //视作循环链表.最低位 = index , 将前半部分换至末尾　，　范围为 index ~ (index+ length)，中间点为 (index + index + length)/2
            System.out.println("" + integerNumbers[(lowestIndex + integerNumbers.length / 2) % integerNumbers.length]);

        }
    }
}

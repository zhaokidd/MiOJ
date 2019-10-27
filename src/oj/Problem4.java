package oj;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 寻找最长连续子序列的长度
 *
 * 输入一个乱序的序列
 * 输出这个乱序序列按有序排列时的最长连续子序列的长度
 *
 * 100,200,1,15,2,4,3
 * 最长长度为7
 *
 *
 * 解法一：
 * 时间复杂度 O(n) 空间复杂度O(n)
 * 用HashSet存储所有元素,再依次遍历整个序列。
 * 规则是：对每一个元素，如果它的左上边界元素存在，则不需对该元素寻找最长序列。
 *        如果它的坐上边界不存在，右下边界存在，则将当前最长序列+1.
 *        直到遍历完输入的所有元素.
 * */
public class Problem4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            String[] numberArray = line.split(",");
            int[] nums = new int[numberArray.length];

            HashSet<Integer> hashSet = new HashSet<>();

            for (int i = 0; i < numberArray.length; i++) {
                int temp = Integer.valueOf(numberArray[i]);
                nums[i] = temp;
                hashSet.add(temp);
            }

            //
            int maxLen = 1;

            for (int i = 0; i < nums.length; i++) {
                int cur = nums[i];
                int count = 0;
                if (hashSet.contains(cur - 1)) {
                    continue;
                }


                while (hashSet.contains(cur++)) ++count;

                maxLen = Math.max(maxLen, count);
            }

            System.out.println(maxLen);
        }
    }
}

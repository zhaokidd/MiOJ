package src.oj;

import java.util.Scanner;

/**
 * 按序合成最大的数
 * 题目描述:
 * 给定两个数组，由数字 0-9 组成的，长度分别为 a 和 b，需要用 a、b 两个数组中的数字组合得到长度为 k （k <= a+b）的正整数，
 * 输出所有可能的组合中数值最大的一个（原同一数组中的数字顺序不能改变）
 *
 * a、b 数组中的数字间用 , 隔开，两个数组以及 k 之间用空格隔开，如：1,3,4,5,1,2 8,9,1 5，其中 a = [1,3,4,5,1,2]，b = [8,9,1]，k = 5. 数组 a, b 元素个数不大于20.
 *
 * 长度为 k 的所有组合中数值最大的整数，如：95121
 *
 * 从 a 或 b 中取数的时候需保证 a，b 内部的顺序不变，如第一个数取到 b 中的 9，那么 b 中只有 1 可以后续取用；第二个数取到 a 中的 5，则 a 中还剩下 1,2 可以后续取用
 * */
public class Problem21 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            String[] inputStrings = line.split(" ");
            String[] inputStringArray1 = inputStrings[0].split(",");
            String[] inputStringArray2 = inputStrings[1].split(",");
            int k = Integer.parseInt(inputStrings[2]);
            int[] inputIntegerArray1 = new int[inputStringArray1.length];
            int[] inputIntegerArray2 = new int[inputStringArray2.length];
            for (int i = 0; i < inputStringArray1.length; i++) {
                inputIntegerArray1[i] =
                        Integer.parseInt(inputStringArray1[i]);
            }

            for(int i=0;i< inputStringArray2.length;i++){
                inputIntegerArray2[i] =
                        Integer.parseInt(inputStringArray2[i]);
            }

            //处理k<=0的异常情况
            if (k <= 0) {
                System.out.println(0);
            }


        }
    }

    private static int findMaxNumber(int[] a,int[] b, int k) {
        if (k <= 0 || (a.length<=0 && b.length<=0))
            return -1;

        //TODO to be continued

        return -1;
    }
}

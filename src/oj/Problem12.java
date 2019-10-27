package oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一组长度为N的不重复正整数，以及给定的目标值M。
 * 求这组数中有多少种组合，其加和等于M值。
 */
public class Problem12 {
    static int count = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            String[] a1 = line.split(" ")[0].split(",");
            String a2 = line.split(" ")[1];
            int[] numbers = new int[a1.length];
            int target = Integer.valueOf(a2);
            for (int i = 0; i < numbers.length; i++)  

            printSolutionCount(target,numbers[0],numbers[numbers.length-1]);
        }
    }


    /**
     * @param target 还需要凑出来的剩余值
     * @param start  待选择队列的开始值
     * @param end    待选择队列的结束值
     */
    private static void recursive(int target, int start, int end) {
        if (end < start || target < 0) {
            //待选择队列的结束值已经超过队列头部值
            //target值
            return;
        }

        if (target == 0) {
            count++;
            return;
        }

        //代表三种策略
        //1.使用当前的end值，从target中减去，下次递归仍从end选择。
        //2.不使用当前的end值，target值保持不变，下次递归选择end-1。
        //3.使用end值，从target中减去，下次递归从end-1选择。
        recursive(target - end, start, end);
        recursive(target, start, end - 1);
        recursive(target - end, start, end - 1);
    }

    /**
     *打印结果
     * */
    private static void printSolutionCount(int target,int start,int end){
        count = 0;
        recursive(target,start,end);
        System.out.println(count);
    }


//-----------------------------------------------------------------------------------------------------

    /**
     * 计算n的阶乘
     */
    private static long factorial(long number) {
        if (number <= 1) {
            return 1;
        }

        return number * factorial(number - 1);
    }

    /**
     * 计算排列数。公式： A(n,m) =n!/(n-m)!
     */
    public static long arrangement(int n, int m) {
        return (n - m) >= 0 ? (factorial(n) / factorial(n - m)) : 0;
    }

    /**
     * 计算组合数。公式： C(n,m) = n!/(m*(n-m)!)
     */
    private static long combination(int n, int m) {
        return (n - m) >= 0 ? (factorial(n) / factorial(n - m) / factorial(m)) : 0;
    }


    private static void arrangementSelect(String[] datalist, int n) {
        System.out.println(String.format("A(%d,%d) = %d", datalist.length, n));
    }

    /**
     *
     */
    private static void combinationSelect(String[] dataList, int n) {
        System.out.println(String.format("C(%d,%d) = %d", dataList.length, n, combination(dataList.length, n)));

    }

    /**
     * 组合选择:
     *
     * @param dataList    待选列表
     * @param dataIndex   待选开始索引
     * @param resultList  前面(resultIndex - 1)个结果
     * @param resultIndex 选择索引，从0开始
     */
    private static void combinationSelect(String[] dataList, int dataIndex, String[] resultList,
                                          int resultIndex) {
        int resultLen = resultList.length;
        int resultCount = resultIndex + 1;
        if (resultCount > resultLen) {
            System.out.println(Arrays.asList(resultList));
            return;
        }

        for (int i = dataIndex; i < dataList.length - (resultLen - resultCount); i++) {
            resultList[resultIndex] = dataList[i];
            combinationSelect(dataList, i + 1, resultList, resultIndex + 1);
        }
    }

    /*    *//**
     * test main
     *//*
    public static void main(String[] args) {
        String[] dataList = new String[]{"1", "2", "3", "4", "8", "10"};
        String[] resultList = new String[3];

        combinationSelect(dataList, 0, resultList, 0);
    }*/
}

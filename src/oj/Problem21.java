package src.oj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 按序合成最大的数
 * 题目描述:
 * 给定两个数组，由数字 0-9 组成的，长度分别为 a 和 b，需要用 a、b 两个数组中的数字组合得到长度为 k （k <= a+b）的正整数，
 * 输出所有可能的组合中数值最大的一个（原同一数组中的数字顺序不能改变）
 * <p>
 * a、b 数组中的数字间用 , 隔开，两个数组以及 k 之间用空格隔开，如：1,3,4,5,1,2 8,9,1 5，其中 a = [1,3,4,5,1,2]，b = [8,9,1]，k = 5. 数组 a, b 元素个数不大于20.
 * <p>
 * 长度为 k 的所有组合中数值最大的整数，如：95121
 * <p>
 * 从 a 或 b 中取数的时候需保证 a，b 内部的顺序不变，如第一个数取到 b 中的 9，那么 b 中只有 1 可以后续取用；第二个数取到 a 中的 5，则 a 中还剩下 1,2 可以后续取用
 * <p>
 * <p>
 * <p>
 * TODO 还有跑不通的输入
 用例输入: "5,9,7,5,3,9,0,5,5,6,3,2,6,8 9,1,4,8 6"
 期望输出: "999868"
 你的输出: "999848"
 */
public class Problem21 {
    private static int[] inputIntegerArray1;
    private static int[] inputIntegerArray2;

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
            inputIntegerArray1 = new int[inputStringArray1.length];
            inputIntegerArray2 = new int[inputStringArray2.length];
            for (int i = 0; i < inputStringArray1.length; i++) {
                inputIntegerArray1[i] =
                        Integer.parseInt(inputStringArray1[i]);
            }

            for (int i = 0; i < inputStringArray2.length; i++) {
                inputIntegerArray2[i] =
                        Integer.parseInt(inputStringArray2[i]);
            }

            //处理k<=0的异常情况
            if (k <= 0) {
                System.out.println(0);
            }

            findMaxNumber(inputIntegerArray1, inputIntegerArray2, inputIntegerArray1.length, inputIntegerArray2.length, k);
        }
    }

    private static void findMaxNumber(int[] arrayA, int[] arrayB, int lengthA, int lengthB, int k) {
        int[] result = new int[k];

        findMaxNumberInner(result, inputIntegerArray1, inputIntegerArray2, lengthA, lengthB, k);

        for (int n = 0; n < result.length; n++) {
            System.out.print(result[n]);
        }
        System.out.println();

    }

    /**
     * 找到当前组合中的最大值数字
     */
    private static void findMaxNumberInner(int[] totalResult, int[] arrayA, int[] arrayB, int lengthA, int lengthB, int k) {
        if (k <= 0 || (lengthA <= 0 && lengthB <= 0))
            return;

        int maxA = -1;
        int maxB = -1;
        int indexA = -1;
        int indexB = -1;

        //先从数组a中寻找最大数字
        int cA = lengthA + lengthB - k + 1;
        cA = Math.min(cA, lengthA);
        for (int i = 0; i < cA; i++) {
            if (arrayA[i] > maxA) {
                maxA = arrayA[i];
                indexA = i;
            }
        }

        //再从数组B中寻找最大值
        int cB = lengthA + lengthB - k + 1;
        cB = Math.min(cB, lengthB);
        for (int i = 0; i < cB; i++) {
            if (arrayB[i] > maxB) {
                maxB = arrayB[i];
                indexB = i;
            }
        }

        if (maxA > maxB) {
            int[] tempA = new int[lengthA];
            for (int i = 0; i < tempA.length; i++) {
                tempA[i] = arrayA[i];
            }

            for (int i = 0; i < lengthA && (i + indexA + 1) < tempA.length; i++) {
                arrayA[i] = tempA[i + indexA + 1];
            }

            totalResult[totalResult.length - k] = maxA;
            System.out.println("maxA > maxB,result index:" + (totalResult.length - k + " num:" + maxA) + "indexA: " + indexA + "indexB: " + indexB);
            findMaxNumberInner(totalResult, arrayA, arrayB, lengthA - indexA - 1, lengthB, k - 1);
        } else if (maxB > maxA) {
            int[] tempB = new int[lengthB];
            for (int i = 0; i < tempB.length; i++) {
                tempB[i] = arrayB[i];
            }

            for (int i = 0; i < lengthB && (i + indexB + 1) < tempB.length; i++) {
                arrayB[i] = tempB[i + indexB + 1];
            }

            totalResult[totalResult.length - k] = maxB;
            System.out.println("maxB > maxA,result index:" + (totalResult.length - k + " num:" + maxB) + "indexA: " + indexA + "indexB: " + indexB);
            findMaxNumberInner(totalResult, arrayA, arrayB, lengthA, lengthB - indexB - 1, k - 1);
        } else {
            System.out.println("equal happens,begin traversal,num:" + maxA + "indexA: " + indexA + "indexB: " + indexB);
            //如果遇到相等的情况,就遍历AB数组两种情况,找到剩下的(k-1)次迭代后的最大值.
            int[] resultA = new int[k - 1];
            int[] tempA = new int[arrayA.length];
            int[] tempArrayA = new int[arrayA.length - 1 - indexA];//用来做后续的二次迭代遍历
            int[] tempArrayBUsedByA = Arrays.copyOf(arrayB, arrayB.length);
            for (int i = 0; i < tempA.length; i++) {
                tempA[i] = arrayA[i];
            }
            for (int i = 0; i < tempArrayA.length && (i + indexA + 1) < tempA.length; i++) {
                tempArrayA[i] = tempA[i + indexA + 1];
            }
            for (int i = k - 1; i > 0; i--) {
                findMaxNumberInner(resultA, tempArrayA, tempArrayBUsedByA,
                        tempArrayA.length, tempArrayBUsedByA.length, i);
            }

            int[] resultB = new int[k - 1];
            int[] tempB = new int[arrayB.length];
            int[] tempArrayB = new int[arrayB.length - 1 - indexB];
            int[] tempArrayAUsedByB = Arrays.copyOf(arrayA, arrayA.length);
            for (int i = 0; i < tempB.length; i++) {
                tempB[i] = arrayB[i];
            }
            for (int i = 0; i < tempArrayB.length && (i + indexB + 1) < tempB.length; i++) {
                tempArrayB[i] = tempB[i + indexB + 1];
            }
            for (int i = k - 1; i > 0; i--) {
                findMaxNumberInner(resultB, tempArrayAUsedByB,
                        tempArrayB, tempArrayAUsedByB.length, tempArrayB.length, i);
            }

            boolean isABigger = true;
            if(resultA.length>resultB.length){
                isABigger = true;
            }else if(resultB.length > resultA.length) {
                isABigger = false;
            } else{
                for (int i = 0; i < resultA.length && i < resultB.length; i++) {
                    if (resultB[i] != resultA[i]) {
                        isABigger = resultA[i] > resultB[i];
                        break;
                    }
                }
            }

            if (isABigger) {
                int[] tempA2 = new int[arrayA.length];
                for (int i = 0; i < tempA2.length; i++) {
                    tempA2[i] = arrayA[i];
                }

                for (int i = 0; i < arrayA.length && (i + indexA + 1) < tempA2.length; i++) {
                    arrayA[i] = tempA2[i + indexA + 1];
                }

                System.out.println("maxB == maxA,find maxA is bigger,result index:" + (totalResult.length - k + " num:" + maxA) + "indexA: " + indexA + "indexB: " + indexB);
                totalResult[totalResult.length - k] = maxA;
                findMaxNumberInner(totalResult, arrayA, arrayB, lengthA - indexA - 1, lengthB, k - 1);
            } else {
                int[] tempB2 = new int[arrayB.length];
                for (int i = 0; i < tempB2.length; i++) {
                    tempB2[i] = arrayB[i];
                }

                for (int i = 0; i < arrayB.length && (i + indexB + 1) < tempB2.length; i++) {
                    arrayB[i] = tempB2[i + indexB + 1];
                }

                System.out.println("maxB == maxA,find maxB is bigger,result index:" + (totalResult.length - k + " num:" + maxA) + "indexA: " + indexA + "indexB: " + indexB);
                totalResult[totalResult.length - k] = maxB;
                findMaxNumberInner(totalResult, arrayA, arrayB, lengthA, lengthB - indexB - 1, k - 1);
            }
        }
    }
}

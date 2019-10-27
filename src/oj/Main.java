package oj;

import java.util.*;

/**
 * 类型：字符串
 * <p>
 * 给出三个队列 s1，s2，s3 ，判断 s3 是否是由 s1 和 s2 交叉得来。
 * 如：s1 为 aabcc ， s2 为 dbbca。 当 s3 为 aadbbcbcac 时，
 * 返回 true（即将 s1 拆成三部分： aa，bc，c 分别插入 s2 对应位置） 否则返回 false。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = null;
        while (scan.hasNextLine()) {
            input = scan.nextLine().trim();
            String[] lines = input.split(",");
            String lineA = lines[0];
            String lineB = lines[1];
            String lineResult = lines[2];

            if (lineA == null || lineA.length() <= 0 || lineB == null || lineB.length() <= 0) {
                System.out.println("false");
            }

            int indexA = 0;
            int indexB = 0;
            int indexResult = 0;

            if (isCrossLetterQueue(lineA, lineB, lineResult, indexA, indexB, indexResult)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

        }
    }


    private static boolean isCrossLetterQueue(String lineA, String lineB, String lineResult, int indexA, int indexB,
                                              int indexResult) {
        if ((lineA.length() + lineB.length()) != lineResult.length()) {
            return false;
        }

        while ((indexA + indexB) < lineResult.length()) {
//            System.out.println("[indexA]:" + indexA + " [indexB]:" + indexB);
            //如果在某个位置上字符串A和字符串B对应的字符与最终位置均相同。则先尝试A，再尝试B。
            if (indexA < lineA.length() && indexB < lineB.length() && lineA.charAt(indexA) == lineB.charAt(indexB)
                    && lineA.charAt(indexA) == lineResult.charAt(indexResult)) {
                return isCrossLetterQueue(lineA, lineB, lineResult, indexA + 1, indexB, indexResult + 1) ||
                        isCrossLetterQueue(lineA, lineB, lineResult, indexA, indexB + 1, indexResult + 1);
                //only A
            } else if (indexA < lineA.length() && lineA.charAt(indexA) == lineResult.charAt(indexResult)) {
                indexA++;
                indexResult++;
                //only B
            } else if (indexB < lineB.length() && lineB.charAt(indexB) == lineResult.charAt(indexResult)) {
                indexB++;
                indexResult++;
            } else {
                break;
            }
        }

        return (indexA + indexB) == lineResult.length();
    }


}
            
package src.oj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 我是一个爱吃香蕉的强迫症。今天我要去水果店论筐买香蕉。 现在水果店有好多筐香蕉，我的要求是买回来的每一筐里必须有相同数量的香蕉。
 *
 * 为了实现这个目标，你可以每次做两件事情。
 * 1）放弃框里的一部分香蕉 2）连筐带香蕉放弃一整筐
 *
 * 我想知道我能得到最多多少香蕉。
 *
 *
 * 解题思路：
 *
 * 按照升序依照香蕉的数量对每筐香蕉的数量进行排序.然后按照贪心原则选取．
 *
 * */
public class Problem98 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();

            //解析输入
            String[] bananaStringArray = line.split(" ");
            int[] bananaNums = new int[bananaStringArray.length];
            for (int i = 0; i < bananaStringArray.length; i++) {
                bananaNums[i] = Integer.parseInt(bananaStringArray[i]);
            }

            //为数组排序
            Arrays.sort(bananaNums);

            int maxTotalBananas = 0;
            for (int i = 0; i < bananaNums.length; i++) {
                int curBananaNum = bananaNums[i];
                maxTotalBananas = Math.max(maxTotalBananas, (bananaNums.length - i) * curBananaNum);
            }

            System.out.println(maxTotalBananas);
        }
    }
}

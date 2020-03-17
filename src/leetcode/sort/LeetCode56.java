package src.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * <p>
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class LeetCode56 {
    public static void main(String[] args) {
        int[][] a = new int[4][2];

        for (int i = 0; i < a.length; i++) {
            a[i] = new int[2];
        }

        a[0][0] = 1;
        a[0][1] = 3;
        a[1][0] = 2;
        a[1][1] = 6;
        a[2][0] = 8;
        a[2][1] = 10;
        a[3][0] = 15;
        a[3][1] = 18;

        int[][] b = merge(a);
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, comparator);
        int newLength = intervals.length;

        for (int i = 0; i < newLength - 1;) {
            int[] prev = intervals[i];
            int[] next = intervals[i + 1];

            if (prev[1] >= next[0]) {
                prev[1] = Math.max(prev[1], next[1]);
                newLength--;

                for (int j = i + 1; j < intervals.length - 1; j++) {
                    intervals[j] = intervals[j + 1];
                }
            }else{
                i++;
            }
        }

        return Arrays.copyOf(intervals, newLength);
    }

    static Comparator<int[]> comparator = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[0], o2[0]);
        }
    };
}

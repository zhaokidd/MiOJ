package src.leetcode.sort;

import java.util.*;

/**
 * 合并区间
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 *
 *
 * 解题思路:
 * 1.合并区间首先需要对区间进行排序,以start为基准进行排序.
 * 2.排序完成后进行合并.合并有两种可能性:
 *   1.>区间不相交则加入merge集合
 *   2.>区间相交则更新end值
 * */
public class Problem56 {
    public static void main(String[] args) {
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 0) {
            return new int[0][];
        }

        //转换int[][]形式为对象形式
        List<Node> intervalList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] a = intervals[i];
            intervalList.add(new Node(a[0], a[1]));
        }

        //以start为基准进行排序
        Collections.sort(intervalList, new IntervalComparator());

        List<Node> mergedList = new ArrayList<>();

        for (int i = 0; i < intervalList.size(); i++) {
            if (mergedList.size() <= 0) {
                mergedList.add(intervalList.get(i));
                continue;
            }

            Node temp = intervalList.get(i);
            Node lastMergedNode = mergedList.get(mergedList.size() - 1);
            if (mergedList.isEmpty() || lastMergedNode.getEnd() < temp.getStart()) {
                mergedList.add(temp);
            } else if (lastMergedNode.getEnd() < temp.getEnd()) {
                lastMergedNode.setEnd(temp.getEnd());
            }
        }

        int[][] result = new int[mergedList.size()][];
        for (int i = 0; i < mergedList.size(); i++) {
            Node temp = mergedList.get(i);
            result[i] = new int[]{temp.getStart(), temp.getEnd()};
        }

        return result;
    }

    static class IntervalComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o1.start, o2.start);
        }
    }

    static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }
}

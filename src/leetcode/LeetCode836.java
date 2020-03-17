package src.leetcode;

/**
 * 矩形重叠计算.
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 *
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 *
 * 给出两个矩形，判断它们是否重叠并返回结果。
 *
 * 示例 1：
 *
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false
 *
 * */
public class LeetCode836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return isRectangleOverLapInner(rec1, rec2) && isRectangleOverLapInner(rec2, rec1);
    }

    private static boolean isRectangleOverLapInner(int[] rec1, int[] rec2) {
        int l1 = rec1[0], t1 = rec1[3], r1 = rec1[2], d1 = rec1[1];
        int l2 = rec2[0], t2 = rec2[3], r2 = rec2[2], d2 = rec2[1];

        return (l1 > l2 && l1 < r2 && t1 > d2 && t1 < t2) ||
                (r1 > l2 && r1 < r2 && t1 > d2 && t1 < t2) ||
                (l1 > l2 && l1 < r2 && d1 < t2 && d1 > d2) ||
                (r1 > l2 && r1 < r2 && d1 > d2 && d1 < t2) ||
                (r1 == r2 && l1 == l2 && d1 == d2 && t1 == t2);
    }
}

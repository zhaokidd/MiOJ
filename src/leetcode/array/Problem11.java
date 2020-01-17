package src.leetcode.array;

/**
 * 盛水最多的容器
 * <p>
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 *
 * 解题思路：
 * area面积由　宽度和长度两个因素决定，长度有low和high两个坐标所指向的最小height决定
 * 所以当(high - low)宽度决定后，移动最小height的游标，会使长度增加，有可能是area面积变大.
 */
public class Problem11 {
    public static void main(String[] args) {

    }

    public static int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }

        int low = 0, high = height.length - 1;
        int area = 0;

        while (low < high) {
            area = Math.max(area,
                    (high - low) * Math.min(height[low], height[high]));

            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }

        return area;
    }
}

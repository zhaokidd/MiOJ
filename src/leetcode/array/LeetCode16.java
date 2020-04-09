package src.leetcode.array;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class LeetCode16 {
    public static void main(String[] args) {
        int[] a = new int[]{-1, 2, 1, -4};
        int target = 1;

        threeSumClosest(a, target);
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int ans = 0;
        int curGap = Integer.MAX_VALUE;

        if (nums.length <= 3) {
            for (int i = 0; i < nums.length; i++) {
                ans += nums[i];
            }
            return ans;
        }

        Arrays.sort(nums);


        for (int i = 0; i < nums.length - 2; i++) {
            int cur = nums[i];
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                int total = cur + nums[j] + nums[k];
                int gap = total - target;

                if (Math.abs(gap) < curGap) {
                    curGap = Math.abs(gap);
                    ans = total;
                }

                if (gap > 0) {
                    k--;
                } else if (gap < 0) {
                    j++;
                } else {
                    break;
                }
            }
        }

        return ans;
    }
}

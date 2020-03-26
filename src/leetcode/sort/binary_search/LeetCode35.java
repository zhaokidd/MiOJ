package src.leetcode.sort.binary_search;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class LeetCode35 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3};
        int result = searchInsert(a, 2);
    }

    public static int searchInsert(int[] nums, int target) {
        return searchInsertInner(nums, target, 0, nums.length - 1);
    }

    private static int searchInsertInner(int[] nums, int target, int startPos, int endPos) {
        if (startPos == endPos) {
            if (nums[startPos] < target) {
                return (startPos + 1);
            } else if (nums[startPos] >=target) {
                return startPos;
            }
        }

        int mid = (startPos + endPos) / 2;

        if (target < nums[mid]) {
            return searchInsertInner(nums, target, 0, mid - 1 < startPos ? startPos : mid - 1);
        } else if (nums[mid] < target) {
            return searchInsertInner(nums, target, mid + 1 > endPos ? endPos : mid + 1, endPos);
        } else {
            return mid;
        }
    }

    public static int binarySearchRecursive(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            }
        }

        return low;
    }
}

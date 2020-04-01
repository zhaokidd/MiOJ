package src.leetcode.sort.binary_search;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class LeetCode33 {
    public static void main(String[] args) {
/*        int[] a = new int[]{3, 4, 0, 1, 2};
        int[] b = new int[]{1, 2, 3, 5, 6, 7, 9, 10};
        searchTopLocation(a, 0, a.length - 1);
        binarySearch(b, 0, b.length - 1, 7);*/

        int[] c = new int[]{1,3};
        searchTopLocation(c,0,c.length-1);
        search(c, 1);
    }


    public static int search(int[] nums, int target) {
        if (nums.length <= 0)
            return -1;

        int topPosition = searchTopLocation(nums, 0, nums.length-1);

        int left = binarySearch(nums, 0, topPosition, target);
        if (left != -1) {
            return left;
        }

        return binarySearch(nums, topPosition + 1, nums.length - 1, target);
    }

    private static int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, high, target);
        } else {
            return binarySearch(nums, low, mid - 1, target);
        }
    }


    /**
     * @return 返回旋转数组的的交界元素
     */
    private static int searchTopLocation(int[] nums, int low, int high) {
        if (nums.length == 1)
            return 0;

        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if ((mid == nums.length - 1) || (mid < nums.length - 1
                && nums[mid] > nums[mid + 1])) {
            return mid;
        }

        int left = searchTopLocation(nums, low, mid - 1);
        if (left == -1) {
            return searchTopLocation(nums, mid + 1, high);
        } else {
            return left;
        }
    }
}

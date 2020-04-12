package src.leetcode.sort.binary_search;

public class LeetCode34 {
    public static void main(String[] args) {

    }

    public static int[] searchRange(int[] nums, int target) {
        int start = searchTargetStart(nums, target, 0, nums.length - 1);
        int end = searchTargetEnd(nums, target, 0, nums.length - 1);
        int[] a = new int[2];
        a[0] = start;
        a[1] = end;

        return a;
    }

    private static int searchTargetStart(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (nums[mid] < target) {
            if (mid < high && nums[mid + 1] == target) {
                return mid + 1;
            } else {
                return searchTargetStart(nums, target, mid + 1, high);
            }
        } else if (nums[mid] > target) {
            return searchTargetStart(nums, target, low, mid - 1);
        } else {
            if (mid - 1 >= low && nums[mid - 1] < target) {
                return mid;
            } else if (mid == low) {
                return mid;
            } else {
                return searchTargetStart(nums, target, low, mid - 1);
            }
        }
    }

    private static int searchTargetEnd(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (nums[mid] > target) {
            if (mid > low && nums[mid - 1] == target) {
                return mid - 1;
            } else {
                return searchTargetEnd(nums, target, low, mid - 1);
            }
        } else if (nums[mid] < target) {
            return searchTargetEnd(nums, target, mid + 1, high);
        } else {
            if (mid + 1 <= high && nums[mid + 1] > target) {
                return mid;
            } else if (mid == high) {
                return mid;
            } else {
                return searchTargetEnd(nums, target, mid + 1, high);
            }
        }
    }
}

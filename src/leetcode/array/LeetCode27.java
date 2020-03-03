package src.leetcode.array;

/**
 * 移除元素
 * <p>
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 解题思路：用两个游标,标识前后位置,如果发现有目标元素则进行对换.
 *
 * 注意：元素为长度１的情况
 */
public class LeetCode27 {
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length <= 0)
            return 0;

        int resLength = nums.length;
        int prev = 0;
        int next = nums.length - 1;

        while (prev <= next) {
            if (nums[next] == val) {
                resLength--;
                next--;
                continue;
            }

            if (nums[prev] == val) {
                nums[prev] = nums[next];
                nums[next] = val;
                next--;
                prev++;
                resLength--;
                continue;
            }

            prev++;
        }

        return resLength;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1};
        int num = 1;
        System.out.println(removeElement(a, num)+"");;
    }

}

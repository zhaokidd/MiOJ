package src.leetcode.array;
/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 *
 * 解题思路：
 * 根据数组已排序的特性,从头位置开始遍历，每个位置放置一个元素．确定重复数组的范围，取最后一个元素.
 * */
public class Problem26 {
    public static void main(){

    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;

        int index = 0;
        int length  =0;

        while (index < nums.length) {
            while ((index + 1) < nums.length && nums[index] == nums[index + 1])
                index++;

            nums[length++] = nums[index];
            index++;
        }

        return length;
    }
}

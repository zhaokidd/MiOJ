package src.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * <p>
 * 解题思路：
 * １.穷举暴力法.时间复杂度: O(n3)
 * 2.游标定位:　首先确定三数中的中间位置medium,剩下的low和high定位在序列的开始和结束位置,
 * 　　　　　　　挪动low和high游标向中间靠拢,寻找和为0的数字组合.
 * 需要注意的情况是：如果遇到前后相同的数字，需要挪动游标向后或向前.
 */
public class Problem15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

//        if (nums[0] == nums[nums.length - 1] && nums[0] == 0) {
//            List<Integer> sp = new ArrayList<>();
//            sp.add(0);
//            sp.add(0);
//            sp.add(0);
//            list.add(sp);
//            return list;
//        }

        for (int mid = 1; mid < nums.length - 1; mid++) {
            int low = 0, high = nums.length - 1;
            while (low < mid && high > mid && nums[low] <= 0 && nums[high] >= 0) {
                while (low < mid && nums[low] == nums[low + 1]) low++;
                while (high > mid && nums[high] == nums[high - 1]) high--;

                int total = nums[low] + nums[mid] + nums[high];
                if (total < 0) {
                    low++;
                } else if (total > 0) {
                    high--;
                } else {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[low]);
                    tempList.add(nums[mid]);
                    tempList.add(nums[high]);

                    //放入list前先判断下
                    if (list.size() > 0) {
                        boolean isSame = false;
                        for (int k = 0; k < list.size(); k++) {
                            List<Integer> prevList = list.get(k);

                            if (prevList.size() != tempList.size()) {
                                continue;
                            }

                            boolean isSameInner = true;
                            for (int m = 0; m < tempList.size(); m++) {
                                if (!tempList.get(m).equals(prevList.get(m))) {
                                    isSameInner = false;
                                    break;
                                }
                            }

                            if (isSameInner) {
                                isSame = true;
                                break;
                            }
                        }

                        if(!isSame){
                            list.add(tempList);
                        }

                    } else {
                        list.add(tempList);
                    }

                    low++;
                    high--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums2 = new int[]{0, 0, 0, 0, 0, 0};
        int[] nums3 = new int[]{-2, 0, 1, 1, 2};
        int[] nums4 = new int[]{-1, 0, 1, 0};
        int[] nums5 = new int[]{-2, -1, 0, 0, 1, 2, 3};
        int[] nums6 = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        List<List<Integer>> resultList = threeSum(nums6);

        if (resultList != null) {
            for (int i = 0; i < resultList.size(); i++) {
                ArrayList<Integer> tempList = (ArrayList<Integer>) resultList.get(i);
                if (tempList != null) {
                    for (int j = 0; j < tempList.size(); j++) {
                        System.out.print(tempList.get(j));
                    }
                    System.out.println();
                }
            }
        }
    }
}

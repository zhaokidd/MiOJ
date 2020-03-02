package src.leetcode.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 解题思路：
 * 1.首先对两个数组中的元素做去重.
 * 2.然后迭代长度较小的数组，查找交集元素.
 * */
public class LeetCode349 {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();

        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }

        return intersectionInner(set1, set2);
    }

    private int[] intersectionInner(HashSet set1, HashSet set2) {
        if (set1.size() <= 0 || set2.size() <= 0)
            return new int[0];

        int[] res = new int[set1.size()];
        int index = 0;

        Iterator<Integer> iterator = set1.iterator();

        while(iterator.hasNext()) {
            int val = iterator.next();
            if (set2.contains(val)) {
                res[index++] = val;
            }
        }

        return Arrays.copyOf(res,index);
    }
}

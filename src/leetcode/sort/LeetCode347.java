package src.leetcode.sort;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
public class LeetCode347 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3};
        topKFrequent(nums, 3);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length <= 0 || k <= 0 || k > nums.length) {
            return new int[0];
        }

        //用hashMap统计元素出现的次数
        HashMap<Integer, Integer> elementMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            elementMap.merge(element, 1, Integer::sum);
        }

        //用堆排序的思想统计前K频率的元素.
        Set<Map.Entry<Integer, Integer>> entrySet = elementMap.entrySet();
        HashMap.Entry<Integer, Integer>[] entries = new HashMap.Entry[entrySet.size()];
        int[] res = new int[k];

        Iterator<HashMap.Entry<Integer, Integer>> iterator = entrySet.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            entries[index++] = iterator.next();
        }

        res[0] = buildEntryHeap(entries, entries.length -1 );
        for (int i = 1; i < k; i++) {
            res[i] = heaplify(entries, i);
        }

        return res;
    }

    private static int buildEntryHeap(HashMap.Entry<Integer, Integer>[] entries, int length) {
        for (int index = length / 2 - 1; index >= 0; index--) {
            int maxPos = index;
            if (2 * index + 1 < length && entries[2 * index + 1].getValue() > entries[maxPos].getValue())
                maxPos = 2 * index + 1;
            if (2 * index + 2 < length && entries[2 * index + 2].getValue() > entries[maxPos].getValue())
                maxPos = 2 * index + 2;

            swapElement(entries, index, maxPos);
        }

        return entries[0].getKey();
    }

    private static int  heaplify(HashMap.Entry<Integer, Integer>[] entries, int index) {
        swapElement(entries, 0, entries.length - index);

        //做上浮操作
        return buildEntryHeap(entries, entries.length - index);
    }

    private static void swapElement(HashMap.Entry<Integer, Integer>[] entries, int prev, int next) {
        HashMap.Entry<Integer, Integer> element = entries[prev];
        entries[prev] = entries[next];
        entries[next] = element;
    }

}

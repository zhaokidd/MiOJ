package src.leetcode.sort.heapsort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 使用堆排序找出数组中最大的第K个数字.
 * */
public class HeapK {
    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 1, 5, 6, 4};
        int result = findKthLargest(a, 2);
    }

    public int findKthLargest2(int[] nums, int k) {
        if (nums.length <= 0 || k <= 0) {
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.poll();
    }

    public static int findKthLargest(int[] nums, int k) {
        //前k个元素构建小顶堆
        buildHeap(nums, k);

        for (int i = k; i < nums.length; i++) {
            if (nums[i] < nums[0]) continue;

            swap(nums, i, 0);

            heaplify(nums, k, 0);

        }

        return nums[0];

    }

    /**
     * 对前K个元素进行堆的构造
     * */
    private static void buildHeap(int[] nums, int k) {
        for (int i = k / 2 - 1; i >= 0; i--) {
            heaplify(nums, k, i);
        }
    }

    /**
     * @param index 当前序号
     * @param k 第k大数字
     * */
    private static void heaplify(int[] nums, int k, int index) {
        int minPos = index;
        while (true) {
            if ((2 * index + 1) < k && nums[2 * index + 1] < nums[index]) minPos = 2 * index + 1;
            if ((2 * index + 2) < k && nums[2 * index + 2] < nums[minPos]) minPos = 2 * index + 2;
            if (minPos == index) break;

            swap(nums, index, minPos);
            index = minPos;
        }
    }

    public static void swap(int[] a, int n, int m) {
        int tmp = a[n];
        a[n] = a[m];
        a[m] = tmp;
    }

}

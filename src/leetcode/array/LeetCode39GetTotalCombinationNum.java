package src.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 *
 * 思路：使用回朔法解题
 */
public class LeetCode39GetTotalCombinationNum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();

        if (candidates == null || candidates.length <= 0)
            return list;

        Arrays.sort(candidates);

        //以每一个数为基准
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> curList =new ArrayList<>();
            curList.add(candidates[i]);
            combinationSumInner(candidates, target, i, candidates[i], list, curList);
        }

        return list;
    }


    private void combinationSumInner(int[] candidates, int target, int index, int totalCount,
                                     List<List<Integer>> resList,List<Integer> curList) {

        if (totalCount == target) {
            resList.add(curList);
        }
        //剪枝操作(totalCount > target直接返回)
        else if (totalCount < target) {
            List<Integer> list1 = new ArrayList<>(curList);
            List<Integer> list2 = new ArrayList<>(curList);

            //使用本层
            list1.add(candidates[index]);
            combinationSumInner(candidates, target, index, totalCount + candidates[index], resList, list1);

            //跳过本层
            if (index + 1 < candidates.length) {
                combinationSumInner(candidates, target, index + 1, totalCount, resList, list2);
            }
        }
    }
}

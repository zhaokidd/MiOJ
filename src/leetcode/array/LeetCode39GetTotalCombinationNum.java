package src.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode39GetTotalCombinationNum {
    public static void main(String[] args){

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();

        if (candidates == null || candidates.length <= 0)
            return list;

        Arrays.sort(candidates);

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
        } else if (totalCount < target) {
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

package src.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 *
 * 解题思路：在每添加一个闭括号之前，都必须先添加一个开括号．
 *
 * 利用递归遍历，先遍历添加开括号，然后遍历添加闭括号．
 *
 * 利用剪枝的思想，在遍历过程中，如果发现当前的组合已经不符合要求，则中断当前的遍历，回朔到上一层的遍历中．
 *
 * */
public class LeetCode22 {
    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();

        generateParenthesisInner(resultList, "", 0, 0, n);

        return resultList;
    }

    private void generateParenthesisInner(List<String> resultList,String cur,int open, int close, int num) {
        if (open + close == num * 2) {
            resultList.add(cur);
            return;
        }

        if (open < num)
            generateParenthesisInner(resultList, cur + "(", open + 1, close, num);

        if (close < open)
            generateParenthesisInner(resultList, cur + ")", open, close + 1, num);

    }


}

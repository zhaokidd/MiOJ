package src.leetcode.string;

import java.util.Stack;

/**
 * 括号匹配
 * */
public class LeetCode20 {
    private static final char ROUND_BRACKETS_LEFT = '(';
    private static final char ROUND_BRACKETS_RIGHT = ')';
    private static final char RECT_BRACKETS_LEFT = '[';
    private static final char RECT_BRACKETS_RIGHT = ']';
    private static final char FLOWER_BRACKETS_LEFT = '{';
    private static final char FLOWER_BRACKETS_RIGHT = '}';


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.size() > 0) {
                char top = stack.peek();
                char cur = s.charAt(i);
                if (isCharReverse(top, cur)) {
                    stack.pop();
                } else {
                    stack.push(cur);
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.size() <= 0;
    }

    private boolean isCharReverse(char left,char right){
        return left==ROUND_BRACKETS_LEFT&&right==ROUND_BRACKETS_RIGHT||
                left==RECT_BRACKETS_LEFT&&right==RECT_BRACKETS_RIGHT||
                left==FLOWER_BRACKETS_LEFT&&right==FLOWER_BRACKETS_RIGHT;
    }
}

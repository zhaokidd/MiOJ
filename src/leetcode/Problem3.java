package src.leetcode;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 解题思路，利用滑动窗口的概念+HashMap存储窗口内元素的坐标．
 * 步骤可拆解为：
 * １. 判断末尾元素是否重复出现，如果重复即将头部游标置于重复位置．
 * ２. 更新当前最长子串长度.
 * 3. 更新末尾游标对应元素的索引
 * 4. 移动末尾游标向后一位.
 */
public class Problem3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 1;
        for (int low = 0, high = 0; high < s.length(); high++) {
            if (map.containsKey(s.charAt(high))) {
                low = Math.max(map.get(s.charAt(high)), low);
            }
            ans = Math.max(high - low + 1, ans);
            map.put(s.charAt(high), high + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            if (line != null) {
                int length = lengthOfLongestSubstring(line);
                System.out.println("" + length);
            }
        }
    }
}

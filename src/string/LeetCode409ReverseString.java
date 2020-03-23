package src.string;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class LeetCode409ReverseString {
    public static void main() {

    }

    public static int longestPalindrome(String s) {
        //存储字符串中每个大小写字母的出现频率
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.get(cur) == null || map.get(cur) <= 0) {
                map.put(cur, 1);
            } else {
                map.put(cur, map.get(cur) + 1);
            }
        }

        //根绝字母出现频率的奇偶性计算回文字母个数.
        int totalCount = 0;
        boolean hasAddSingle = false;
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Character cur = (Character) iterator.next();
            int curLength = map.get(cur);
            if (curLength % 2 == 1) {
                totalCount += curLength - 1;

                if (!hasAddSingle) {
                    totalCount++;
                    hasAddSingle = true;
                }
            } else if (curLength % 2 == 0) {
                totalCount += curLength;
            }
        }

        return totalCount;
    }
}

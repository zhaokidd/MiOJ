package src.leetcode;

import java.util.Scanner;

/**
 * 最长回文子串
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 解题思路:使用动态规划的思想
 * when s.length()>3
 * p[i][j] = p[i+1][j-1] && s[i]==s[j]
 * 长度１的子串和长度２子串需要单独判断.s
 */
public class Problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = null;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            System.out.println(longestPalindrome(line));
        }
    }

    public static String longestPalindrome(String s) {
        if(s==null || s.trim().equals("")){
            return "";
        }

        //声明一个二维数组，用来指明i和j之间的子串是否是回文串
        boolean a[][] = new boolean[s.length()][s.length()];
        int low = 0;
        int len = 1;

        //先确定长度为１的，都是回文串
        for (int i = 0; i < s.length(); i++) {
            a[i][i] = true;
        }

        //再确定长度为２的子串是否对称.
        for (int i = 0; i < s.length() - 1; i++) {
            a[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (a[i][i + 1] && len < 2) {
                len = 2;
                low = i;
            }
        }

        //从长度３的字符串序列开始遍历，判断是否满足公式.
        for (int j = 2; j < s.length(); j++) {
            for (int i = 0; i < s.length() - j; i++) {
                a[i][i + j] = a[i + 1][i + j - 1] && (s.charAt(i) == s.charAt(i + j));
                if (a[i][i+j] && j+1 > len) {
                    low = i;
                    len = j+1;
                }

            }
        }


        return s.substring(low, low + len);
    }
}

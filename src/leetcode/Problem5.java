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
 * p[i][j] = p[i+1][j-1] && s[i]==s[j]
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

        boolean a[][] = new boolean[s.length()][s.length()];
        int low = 0;
        int len = 1;

        for (int i = 0; i < s.length(); i++) {
            a[i][i] = true;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            a[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (a[i][i + 1] && len < 2) {
                len = 2;
                low = i;
            }
        }

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

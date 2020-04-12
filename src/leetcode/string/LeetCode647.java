package src.leetcode.string;

public class LeetCode647 {
    public static void main(String[] args) {

    }

    public static int countSubstrings(String s) {
        int[][] ans = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            ans[i][i] = 1;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                ans[i][i + 1] = 1;
            }
        }

        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j < s.length() && i + j < s.length(); j++) {
                if (ans[j + 1][j + i - 1] == 1
                        && s.charAt(j) == s.charAt(j + i)) {
                    ans[j][j + i] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (ans[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}

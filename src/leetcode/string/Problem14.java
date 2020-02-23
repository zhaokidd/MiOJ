package src.leetcode.string;

public class Problem14 {
    public static void main(String[] args) {

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }

        String first = strs[0];
        int index = 0;
        boolean stop = false;

        if (first == null || first.trim().equals("")) {
            return "";
        }

        while (index < first.length()) {

            for (int i = 1; i < strs.length; i++) {
                String temp = strs[i];
                if (temp == null || temp.trim().equals("")
                        || index + 1 > temp.length()) {
                    stop = true;
                    break;
                }

                if (first.charAt(index) != temp.charAt(index)) {
                    stop = true;
                    break;
                }
            }

            if (stop)
                break;

            index++;
        }

        return first.substring(0, index);
    }

}

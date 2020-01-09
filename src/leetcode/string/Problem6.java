package src.leetcode.string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Z字形变换.
 *
 * */
public class Problem6 {
    public static void main(String[] args) {

    }

    public String convert(String s, int numRows) {
        if (s == null || s == "" || numRows <= 0) {
            return "";
        }

        int order = 0;//0:从上到下，１:从下到上
        List<List<Character>> nums = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            nums.add(new ArrayList<Character>());
        }

        for (int i = 0, j = 0; i < s.length(); i++) {
            nums.get(j).add(s.charAt(i));

            if (order == 0) {
                if (j == numRows - 1) {
                    order = 1;
                    //注意边界
                    j = (j - 1) > 0 ? (j - 1) : 0;
                } else {
                    j++;
                }
            } else {
                if (j == 0) {
                    order = 0;
                    j = (j + 1) >= numRows ? (numRows - 1) : (j + 1);
                } else {
                    j--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.size(); i++) {
            List<Character> temp = nums.get(i);
            Iterator<Character> iterator = temp.iterator();
            while (iterator.hasNext()) {
                sb.append(iterator.next());
            }
        }

        return sb.toString();
    }
}

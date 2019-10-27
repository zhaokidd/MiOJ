package oj;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 给定两个字符串，判断长字符串中的字符能否构成短字符串。
 */
public class Problem11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;

        while (scan.hasNextLine()) {
            boolean result = true;
            String sString, lString;
            int[] sCount = new int[123], lCount = new int[123];

            line = scan.nextLine().trim();
            // please write your code here
            String[] params = line.split(" ");
            if (params[0].length() > params[1].length()) {
                lString = params[0];
                sString = params[1];
            } else {
                lString = params[1];
                sString = params[0];
            }

            for (int i = 0; i < sString.length(); i++) {
                sCount[sString.charAt(i)]++;
            }
            for (int j = 0; j < lString.length(); j++) {
                lCount[lString.charAt(j)]++;
            }
            for (int k = 'a'; k <= 'z'; k++) {
//                System.out.println("[character]:"+(char)k+" [scount]:"+sCount[k]+"  [lCount]:"+lCount[k]);
                if (lCount[k] < sCount[k]) {
                    result = false;
                    break;
                }
            }

            System.out.println(result);
        }
    }
}

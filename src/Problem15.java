import java.util.Arrays;
import java.util.Scanner;

/**
 * 问题15
 * <p>
 * 从某个序列中找出不重复的三元素组合，其加和等于0
 * <p>
 * 解法：
 * １.先排序，得到一有序数组.O(n)log(n).
 * 2.每次固定游标一位,移动剩下两个游标,从低位和高位向中间靠拢.
 * 3.判断三游标对应的元素之和是否为零,遇到重复的元素需要跳过.
 * <p>
 * 复杂度为O(n*logN)+O(n^2)
 */
public class Problem15 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            int count = 0;

            String[] numberCharacters = line.split(",");
            int[] a = new int[numberCharacters.length];

            for (int i = 0; i < numberCharacters.length; i++) {
                a[i] = Integer.valueOf(numberCharacters[i]);
            }

            //sort the array
            Arrays.sort(a);

            //固定单独的一个游标，让剩下的两个游标分别从低位和高位开始向中间靠拢
            for (int i = 0; i < a.length; i++) {
                //如果元素和前一位的元素重复，就需要跳过该元素.
                if (i > 0 && a[i] == a[i - 1])
                    continue;

                for (int j = i + 1, k = a.length - 1; j < k; ) {

                    //如果低位游标所指元素和前一个低位元素重复,则不考虑该元素.
                    if (j > (i + 1) && a[j] == a[j - 1]) {
                        j++;
                        continue;
                    }

                    //如果高位游标所指元素和后一个高位元素重复,则不考虑该元素.
                    if (k < (a.length - 1) && a[k] == a[k + 1]) {
                        k--;
                        continue;
                    }

                    int result = a[i] + a[j] + a[k];

                    if (result == 0) {
                        count++;
                        j++;
                        k--;
                        continue;
                    } else if (result < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
            System.out.println(count + "");
        }
    }
}

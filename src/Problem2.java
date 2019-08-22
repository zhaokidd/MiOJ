import java.util.Scanner;

public class Problem2 {
    /***
     * 描述:给出N个数字。其中仅有一个数字出现过一次，其他数字均出现过两次，找出这个出现且只出现过一次的数字。要求时间和空间复杂度最小。
     *
     * 输入：输入多个数字，每个数字以空格分开。数字数量 N < 20，输入数字的最大值小于 256.
     *
     * eg:  10 10 11 12 12 11 16
     *
     * 解法：使用位运算的思想。异或：相同数字异或=0,不同数字异或＝1.
     * 如果是数组中有偶数个相同的数字，只有一个数值出现奇数次。那么可以使用0去连续异或数组序列中的数字，这样最后剩下的
     * 是存在奇数次的数字。
     *
     * 如果是数组中有奇数个相同的数字（例如每个数字有３次重复），只有一个数字出现一次。
     * 这时候无法使用异或来寻找唯一数字，正确的方法是记录 32bit上每个位置出现的1的总次数，再对３做余运算。
     * */
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            String[] numbers = line.split(" ");
            int[] array = new int[numbers.length];
            // please write your code here
            for (int i = 0; i < numbers.length; i++) {
                array[i] = Integer.valueOf(numbers[i]);
            }

            int result = 0;
            for (int i = 0; i < array.length; i++) {
                result ^= array[i];
            }

            System.out.println(result);
        }
    }
}

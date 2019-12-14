package src.oj;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 大数运算：计算两个超长数字的大小比较结果或相加之和
 * */
public class Problem19 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            if (line.contains(">")) {
                String[] nums = line.split(">");
                BigInteger num1 = new BigInteger(nums[0]);
                BigInteger num2 = new BigInteger(nums[1]);
                System.out.println(num1.compareTo(num2) > 0 ? "Y" : "N");
            } else if (line.contains("<")) {
                String[] nums = line.split("<");
                BigInteger num1 = new BigInteger(nums[0]);
                BigInteger num2 = new BigInteger(nums[1]);
                System.out.println(num1.compareTo(num2) < 0 ? "Y" : "N");
            } else if (line.contains("+")) {
                String[] nums = line.split("\\+");
                BigInteger num1 = new BigInteger(nums[0]);
                BigInteger num2 = new BigInteger(nums[1]);
                System.out.println(num1.add(num2).toString());
            }
        }
    }
}

package src.leetcode.sort.binary_search;
/**
 * 定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3(-2的31次方 ~ 2的31次方-1)
 *
 *
 * dividend:被除数
 * divisor: 除数
 *
 * 解题思路:
 * 位运算,2的n次方,
 *
 * */
public class Problem29 {
    public static void main(String[] args) {
        int result = divide(-1<<31,1);
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;

        boolean negative = (dividend ^ divisor) < 0;

        long dividendLong = Math.abs((long)dividend);
        long divisorLong = Math.abs((long)divisor);


        long result = 0;//减去的除数的总和
        for (long i = 31; i >= 0; i--) {
            //如果被除数右移i位后,余数大于等于divisor,
            //说明(被除数- 2^i*除数) > 0,然后计算新的被除数进行下一轮循环.
            //就把当前的右移位数*2^n算入除数总和中.
            if (dividendLong >> i >= divisorLong) {
                result += 1L << i;
                dividendLong -= divisorLong << i;
            }
        }

        if(!negative){
            result = result > ((1 << 31) - 1) ? ((1 << 31) - 1) : result;
        }

        return (int) (negative ? -result : result);
    }
}

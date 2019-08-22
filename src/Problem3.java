import java.util.Scanner;

/**
 * 大数相减
 */
public class Problem3 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            String a = line.split("-")[0];
            String b = line.split("-")[1];

            BigNumber subTraction = new BigNumber(a);
            BigNumber subTracted = new BigNumber(b);
            subTraction.sub(subTracted);
            subTraction.printBigNumber();
        }
    }

    static class BigNumber{
        final int[] values;

        BigNumber(String number) {
            values = new int[number.length()];
            for (int i = 0; i < number.length(); i++) {
                values[number.length() - 1 - i] = number.charAt(i) - '0';
            }
        }

        void printBigNumber() {
            boolean zeroComes = false;
            for (int i = values.length - 1; i >= 0; i--) {
                if (zeroComes) {
                    System.out.print(values[i]);
                } else if (values[i] > 0) {
                    System.out.print(values[i]);
                    zeroComes = true;
                } else if (values[i] == 0 && !zeroComes) {
                    continue;
                } else if (i == 0 && !zeroComes) {
                    System.out.print(values[i]);
                }
            }
            System.out.println();
        }

        void sub(BigNumber subNum) {
            int[] subValues = subNum.values;
            for (int i = 0; i < values.length; i++) {
                if (subValues.length <= i) {
                    continue;
                }

                if (values[i] >= subValues[i]) {
                    values[i] = values[i] - subValues[i];
                } else {
                    values[i] = values[i] + 10 - subValues[i];
                    values[i + 1]--;
                }
            }
        }
    }
}

package oj;

import java.util.Scanner;

public class ProblemFibnocci {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            int inputNumber = Integer.valueOf(line);
            int outputNumber = 0;
            if (inputNumber < 0) {
                outputNumber = 0;
            } else {
                outputNumber = fibnocci(inputNumber);
            }


            System.out.println("" + outputNumber);
        }
    }

    private static int fibnocci(int num) {
        if (num == 0) return 1;
        if (num == 1) return 1;

        return fibnocci(num - 1) + fibnocci(num - 2);
    }


}

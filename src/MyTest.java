package src;

import java.util.Scanner;

public class MyTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = null;
        while ((line = scanner.nextLine()) != null) {
            String[] params = line.split(" ");
            String[] prevNums = params[0].split("/");
            String[] nextNums = params[1].split("/");
            String splitter = params[2];

            int[] nums1 = new int[2];
            int[] nums2 = new int[2];
            nums1[0] = Integer.valueOf(prevNums[0]);
            nums1[1] = Integer.valueOf(prevNums[1]);
            nums2[0] = Integer.valueOf(nextNums[0]);
            nums2[1] = Integer.valueOf(nextNums[1]);

            int count1 = 0, count2 = 0;
            if ("+".equals(splitter)) {
                count1 = nums1[0] * nums2[1] + nums1[1] * nums2[0];
                count2 = nums1[1] * nums2[1];
            } else if ("/".equals(splitter)) {
                count1 = nums1[0] * nums2[1];
                count2 = nums1[1] * nums2[0];
            } else if ("*".equals(splitter)) {
                count1 = nums1[0] * nums2[0];
                count2 = nums1[1] * nums2[1];
            } else if ("-".equals(splitter)) {
                count1 = nums1[0] * nums2[1] - nums1[1] * nums2[0];
                count2 = nums1[1] * nums2[1];
            }

            int divisor = getDivisor(count1, count2);
            boolean flag = false;
            if (count1 < 0) {
                flag = true;
            }
            System.out.println((flag ? "-" : "") + Math.abs(count1 / divisor) + "/" + Math.abs(count2 / divisor));
        }
    }


    static int getDivisor(int a, int b){
        if(a%b == 0){
            return b;
        }else{
            return getDivisor(b,a%b);
        }
    }

}

package oj;

import java.util.*;

/**
 * 给一队人按身高排序，每个人有两个属性：身高以及在队伍中排在其前边的人的数量。
 * 形如 H1K1H2K2H3K3......
 * 给这组数字重新排序，使K值满足排列特征.
 * <p>
 * 思路：实际是一个二元数组排序的问题。
 * 当身高相同时，按照前方人数升序排列。
 * 当前方人数相同时，按照身高降序排列。
 */
public class Problem18 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here

            String[] array = line.split(" ");
            int[] numbers = new int[array.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.valueOf(array[i]);
            }

            int count = numbers[0];
            int[][] peopleHeights = new int[count][2];
            for (int i = 1; i < numbers.length; i += 2) {
                peopleHeights[i / 2][0] = numbers[i];
                peopleHeights[i / 2][1] = numbers[i + 1];
            }

            Arrays.sort(peopleHeights, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
                }
            });

            List<int[]> list = new ArrayList<>();
            for (int[] p : peopleHeights) {
                list.add(p[1], p);
            }

            int[][] result = list.toArray(new int[peopleHeights.length][]);

            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i][0] + " " + result[i][1] + " ");
            }

        }
    }

    private static void inner() {
        int[][] people = new int[][]{
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i][0]);
        }
    }

}

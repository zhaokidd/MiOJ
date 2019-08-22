
/**
 * 测试动态规划DP算法
 */
public class DPMain {
    public static void main(String[] args) {
        problemLIS();
    }

    /**
     * 给定长度为a的字符序列，从a中抽出一个随机子序列，可以不连续抽取。
     * 求最终的最长子序列长度。
     */
    private static void problemLIS() {
        //1.设计状态:f(x)表示下标为x时的最长子序列长度 -> f[]
        //  a(n)表示下标为n的地方，元素的值。
        //
        //2.f(x) = Max<p<x,a(p)<a(x)>(f(p))+1

        int[] f = new int[]{1,1,1,1,1,1,1,1,1,1};
        int[] a = new int[]{1, 2, 3, 6, 7, 3, 4, 5, 6, 7};

        for (int x = 0; x < f.length; x++) {
            for (int p = 0; p < x; p++) {
                if (a[p] < a[x]) {
                    f[x] = Math.max(f[x], f[p] + 1);
                }
            }
            System.out.printf("f[%d]:%d\n", x, f[x]);
        }

    }

    private static void problemBagPack() {
        int[] f = new int[105];
        int i, n, cost;

        f[0] = 0;
        for (i = 1; i <= 15; i++) {
            cost = Integer.MAX_VALUE;
            if (i - 1 >= 0) cost = Math.min(cost, f[i - 1] + 1);
            if (i - 5 >= 0) cost = Math.min(cost, f[i - 5] + 1);
            if (i - 11 >= 0) cost = Math.min(cost, f[i - 11] + 1);
            f[i] = cost;
            System.out.printf("f[%d]:%d\n", i, f[i]);
        }
    }


}

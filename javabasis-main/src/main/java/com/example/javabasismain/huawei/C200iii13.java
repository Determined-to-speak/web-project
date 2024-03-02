package com.example.javabasismain.huawei;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 高效货运    0/1背包问题
 */
public class C200iii13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wa = sc.nextInt();
        int wb = sc.nextInt();
        int wt = sc.nextInt();
        int pa = sc.nextInt();
        int pb = sc.nextInt();

        wt -= wa + wb;

        int[] w = new int[]{wa, wb};
        int[] p = new int[]{pa, pb};

        int maxP = getResult(wt, 2, w, p);
        if (maxP >= 0) {
            System.out.println(maxP + pa + pb);
        } else {
            System.out.println(0);
        }
    }


    /**
     * 完全背包问题
     *
     * @param bag 背包承重
     * @param n   物品种数
     * @param w   物品的重量数组
     * @param p   物品的价值数组
     * @return 装满背包的最大价值
     */
    private static int getResult(int bag, int n, int[] w, int[] p) {
        int[] dp = new int[bag + 1];

        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) { //遍历物品
            for (int j = w[i]; j <= bag; j++) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + p[i]);
            }
        }

        return dp[bag];
    }

}

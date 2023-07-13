package com.example.javabasismain.swordfingeroffer;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * <p>
 * <p>
 * https://leetcode.cn/problems/chou-shu-lcof/
 */
public class Offer49 {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {
        int a = 1, b = 1, c = 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(Math.min(dp[a] * 2, dp[b] * 3), dp[c] * 5);
            if (dp[i] == dp[a] * 2) a++;
            if (dp[i] == dp[b] * 3) b++;
            if (dp[i] == dp[c] * 5) c++;
        }
        return dp[n];
    }

}

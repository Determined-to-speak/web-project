package com.example.javabasismain.swordfingeroffer;


/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer46 {
    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }

    /**
     * 直接动态规划
     *
     * @param num
     * @return
     */
    public static int translateNum(int num) {
        if (num <= 9) {
            return 1;
        }
        char[] arr = String.valueOf(num).toCharArray();
        int n = arr.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = 10 * (arr[i - 2] - '0') + (arr[i - 1] - '0');
            if (tmp >= 10 && tmp <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }
}

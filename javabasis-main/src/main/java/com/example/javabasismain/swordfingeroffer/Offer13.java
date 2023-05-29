package com.example.javabasismain.swordfingeroffer;

import java.util.Arrays;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer13 {

    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));
        System.out.println(movingCount(3, 1, 0));
        System.out.println(movingCount(11, 8, 16));
        System.out.println(movingCount(36, 11, 15));

    }


    /**
     * 这里一开始的思路还是回溯法
     *
     * @param m 行
     * @param n 列
     * @param k 坐标数之和的最大值
     * @return
     */
    public static int movingCount(int m, int n, int k) {
        boolean[][] flag = new boolean[m][n];
        boolean[][] not = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int intSumNumber = 0;
                intSumNumber += getDigitSum(i) + getDigitSum(j);
                not[i][j] = intSumNumber <= k;
            }
        }
        int result = search(0, 0, m, n, flag, not);

        return result;
    }

    private static int search(int i, int j, int m, int n, boolean[][] flag, boolean[][] not) {

        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) {
            return 0;
        }

        if (!not[i][j] || flag[i][j]) {
            return 0;
        }

        flag[i][j] = true;
        return search(i + 1, j, m, n, flag, not) +
                search(i - 1, j, m, n, flag, not) +
                search(i, j + 1, m, n, flag, not) +
                search(i, j - 1, m, n, flag, not) + 1;

    }

    public static int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }


}

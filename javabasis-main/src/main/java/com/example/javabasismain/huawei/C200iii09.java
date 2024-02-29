package com.example.javabasismain.huawei;

import java.util.Scanner;

public class C200iii09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        if (matrix[0][0] == 1 || matrix[n - 1][m - 1] == 1) {
            System.out.println(0);
            return;
        }

        long[][] dp = new long[n][m];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) continue;
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        System.out.println(dp[n - 1][m - 1]);
    }
}

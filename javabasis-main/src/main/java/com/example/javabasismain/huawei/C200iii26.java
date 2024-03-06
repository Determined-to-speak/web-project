package com.example.javabasismain.huawei;


import java.util.Scanner;

/**
 * 华为OD机试 - 两个字符串间的最短路径问题（Java & JS & Python & C & C++）
 */
public class C200iii26 {
    static String A;
    static String B;
    static int m;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        A = scanner.next();
        B = scanner.next();
        n = A.length();
        m = B.length();

        System.out.println(getResult());
    }

    private static int getResult() {
        int[][] dp = new int[m + 1][n + 1];

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(j - 1) == B.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[m][n];
    }
}

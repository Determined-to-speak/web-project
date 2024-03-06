package com.example.javabasismain.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 华为OD机试 - Wonderland（Java & JS & Python & C & C++）
 */
public class C200iii30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] costs = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] days = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int maxDay = days[days.length - 1];
        int[] dp = new int[maxDay + 1];
        int index = 0;
        for (int i = 1; i <= maxDay; i++) {
            if (i == days[index]) {
                int buy1 = dp[i - 1] + costs[0];
                int buy3 = (i >= 3 ? dp[i - 3] : 0) + costs[1];
                int buy7 = (i >= 7 ? dp[i - 7] : 0) + costs[2];
                int buy30 = (i >= 30 ? dp[i - 30] : 0) + costs[3];
                // 最终dp[i]取上面四种花费的最小值
                dp[i] = Math.min(Math.min(Math.min(buy1, buy3), buy7), buy30);
                index++;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        System.out.println(dp[maxDay]);
    }
}

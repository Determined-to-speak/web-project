package com.example.javabasismain.huawei;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 华为OD机试 - 抢7游戏（Java & JS & Python & C & C++）
 */
public class C200iii32 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        // dpA[i] 表示 A 叫 数字i 的方案数
        BigInteger[] dpA = new BigInteger[m + 2];
        for (int i = 0; i < m + 2; i++) {
            dpA[i] = new BigInteger("0");
        }
        dpA[m] = new BigInteger("1");

        BigInteger[] dpB = new BigInteger[m + 2];
        for (int i = 0; i < m + 2; i++) {
            dpB[i] = new BigInteger("0");
        }
        for (int i = m - 1; i >= 7; i--) {
            dpB[i] = dpA[i + 1].add(dpA[i + 2]);
            dpA[i] = dpB[i + 1].add(dpB[i + 2]);
        }
        System.out.println(dpB[7]);
    }
}

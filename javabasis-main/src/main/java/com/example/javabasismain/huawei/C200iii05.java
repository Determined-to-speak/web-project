package com.example.javabasismain.huawei;

import java.util.Scanner;

public class C200iii05 {

    //员工数
    static int m;
    //月饼数
    static int n;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //员工数
        m = scanner.nextInt();
        //月饼数
        n = scanner.nextInt();

        if (m == 1) {
            System.out.println(1);
        } else {
            recurive(0, 1, n / m, n);
            System.out.println(ans);
        }
    }

    public static void recurive(int level, int min, int max, int remain) {
        if (level == m - 1) {
            if (remain - min <= 3) {
                ans++;
            }
            return;
        }
        for (int i = min; i <= max; i++) {
            remain -= i;
            recurive(level + 1, i, Math.min(i + 3, remain / (m - level - 1)), remain);
            remain += i;
        }
    }

}

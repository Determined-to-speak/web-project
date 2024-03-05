package com.example.javabasismain.huawei;

import java.util.Scanner;

/**
 * 员工派遣
 */
public class C200iii19 {

    static long x;
    static long y;
    static long cntx;
    static long cnty;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        cntx = sc.nextInt();
        cnty = sc.nextInt();

        long min = cntx + cnty;
        long max = Long.MAX_VALUE;

        while (min <= max) {
            long mid = min + (max - min) / 2;
            if (check(mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min);
    }

    private static boolean check(long k) {
        long A = k / x;
        long B = k / y;
        long C = k / (x * y);
        return Math.max(0, cntx - (B - C)) + Math.max(0, cnty - (A - C)) <= k - A - B + C;
    }


}

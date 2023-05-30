package com.example.javabasismain.swordfingeroffer;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 */
public class Offer16 {

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2));
    }


    public static double myPow(double x, int n) {
        double result;

        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }

        result = myPow(x, n >> 1);
        result *= result;
        if ((n & 1) == 1) {
            result *= x;
        }


        return result;
    }

}

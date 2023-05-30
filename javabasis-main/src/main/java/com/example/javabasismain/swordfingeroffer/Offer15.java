package com.example.javabasismain.swordfingeroffer;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 * <p>
 * https://leetcode.cn/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class Offer15 {


    public static void main(String[] args) {
        System.out.println(hammingWeight(111));
    }

    public static int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result += n & 1;
            n = n >>> 1;
        }
        return result;
    }
}

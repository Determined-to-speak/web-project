package com.example.javabasismain.swordfingeroffer;


import java.util.Arrays;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class Offer17 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(1)));
    }

    public static int[] printNumbers(int n) {
        StringBuilder numberString = new StringBuilder();
        for (int i = 0; i < n; i++) {
            numberString.append("9");
        }

        int max = Integer.parseInt(numberString.toString());
        int[] result = new int[max];
        for (int i = 0; i < max; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}

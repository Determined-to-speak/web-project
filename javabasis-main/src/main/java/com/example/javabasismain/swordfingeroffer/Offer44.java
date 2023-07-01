package com.example.javabasismain.swordfingeroffer;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数，求任意第n位对应的数字
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer44 {

    public static void main(String[] args) {
        System.out.println(findNthDigit(3));
        System.out.println(findNthDigit(11));
    }

    public static int findNthDigit(int n) {
        if (n == 0) return 0;
        int bit = 1;
        int i = 1;
        long count = 9;
        while (count < n) {
            n = (int) (n - count);
            bit = bit * 10;
            i++;
            count = (long) bit * i * 9;
        }
        //确定是在这个区间的那个数
        long num = bit + (n - 1) / i;
        int index = (n - 1) % i + 1;
        int res = (int) ((num / Math.pow(10, i - index)) % 10);
//        int res = String.valueOf(Integer.valueOf((int) num)).charAt(index - 1) - '0';
//        System.out.println(String.valueOf(Integer.valueOf((int) num)).charAt(index-1));
        return res;
    }
}

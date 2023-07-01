package com.example.javabasismain.swordfingeroffer;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer43 {

    public static void main(String[] args) {
        System.out.println(countDigitOne(12));
        System.out.println(countDigitOne(13));
    }

    public static int countDigitOne(int n) {
        long bit = 1;
        int sum = 0;
        while (bit <= n) {
            int cur = (int) ((n / bit) % 10);
            int low = (int) (n % bit);
            int high = (int) (n / bit / 10);

            if (cur > 1) {
                sum += (high + 1) * bit;
            } else if (cur == 1) {
                sum += (high * bit) + (1 + low);
            } else {
                sum += high * bit;
            }
            bit = bit * 10;
        }
        return sum;
    }
}

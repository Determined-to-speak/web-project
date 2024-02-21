package com.example.javabasismain.swordfingeroffer;



/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class Offer50 {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

    public static char firstUniqChar(String s) {
        char result = ' ';
        int length = s.length();
        if (length == 0) {
            return result;
        }
        int max = s.charAt(0);
        for (int i = 0; i < length; i++) {
            max = Math.max(max, s.charAt(i));
        }
        int[] temp = new int[max - 'a' + 1];

        for (int i = 0; i < length; i++) {
            temp[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < length; i++) {
            if (temp[s.charAt(i) - 'a'] == 1) return s.charAt(i);
        }
        return result;
    }
}

package com.example.javabasismain.swordfingeroffer;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * <p>
 * 部分数值列举如下：
 * <p>
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 * <p>
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer20 {

    public static void main(String[] args) {
//        System.out.println(isNumber("0"));
//        System.out.println(isNumber("e"));
//        System.out.println(isNumber("."));
//        System.out.println(isNumber("    .1  "));
//        System.out.println(isNumber("0E"));
//        System.out.println(isNumber(". 1"));
        System.out.println(isNumber(".1."));
    }

    static int i = 0;

    public static boolean isNumber(String s) {
        if (s.trim().equals("")) return false;
        s = s.trim();
        boolean numberTrue = scanInteger(s);
        if (i < s.length() && s.charAt(i) == '.') {
            i++;
            if (i < s.length() && s.charAt(i) == ' ') return false;
            numberTrue = scanUnsignedInteger(s) || numberTrue;
        }
        if (i < s.length() && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
            i++;
            if (s.charAt(i - 1) == '0') return false;
            numberTrue = numberTrue && scanInteger(s);
        }
        int result = i;
        i = 0;
        return numberTrue && result == s.length();
    }

    public static boolean scanInteger(String s) {
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }
        return scanUnsignedInteger(s);
    }

    public static boolean scanUnsignedInteger(String s) {
        int before = i;
        while (i < s.length() && ((s.charAt(i) >= '0' && s.charAt(i) <= '9'))) {
            i++;
        }
        return i > before;
    }

}

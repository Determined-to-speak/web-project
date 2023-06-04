package com.example.javabasismain.swordfingeroffer;

/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zheng-ze-biao-da-shi-pi-pei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer19 {

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("a", ".*..a*"));
        System.out.println(isMatch("ab", ".*.."));
        System.out.println(isMatch("a", "ab*a"));
        System.out.println(isMatch("aaa", "ab*a*c*a"));
        System.out.println(isMatch("abcd", "d*"));
        System.out.println(isMatch("a", "ab*"));
    }


    /**
     * 动态规划法匹配正则表达式
     *
     * @return
     */
    public static boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; i++) {
            //从1开始，因为模式p一定不为空
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }

        return f[m][n];
    }

    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


    /**
     * 下面的这个解法是递归的解法
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < p.length()) {

            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    int new_i = i + 1;
                    int new_j = j + 2;
                    return isMatch(s.substring(new_i), p.substring(j)) || isMatch(s.substring(i), p.substring(new_j));
                }
                if (s.charAt(i) != p.charAt(j)) {
                    int new_j = j + 2;
                    return isMatch(s.substring(i), p.substring(new_j));
                }
            }

            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                return isMatch(s.substring(++i), p.substring(++j));
            }

            if (s.charAt(i) != p.charAt(j)) {
                return false;
            }
            return isMatch(s.substring(++i), p.substring(++j));
        }

        if (i == s.length() && j == p.length()) {
            return true;
        } else {
            while (j < p.length()) {
                if (p.charAt(j) != '*' && (j & 1) == 1) return false;
                j++;
            }
            if (p.length() > 0 && p.charAt(p.length() - 1) == '*') {
                return true;
            }

            return false;
        }
    }


}

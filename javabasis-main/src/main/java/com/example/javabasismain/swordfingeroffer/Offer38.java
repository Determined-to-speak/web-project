package com.example.javabasismain.swordfingeroffer;


import java.util.*;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class Offer38 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("abc")));
    }

    public static String[] permutation(String s) {
        if (s == null) {
            return null;
        }
        Set<String> result = new HashSet<>();
        char[] sArray = s.toCharArray();
        find(result, sArray, 0);
        String[] resultArray = new String[result.size()];
        Iterator<String> iterator = result.iterator();
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = iterator.next();
        }
        return resultArray;
    }

    private static void find(Set<String> result, char[] s, int index) {
        if (index < 0 || index >= s.length) {
            StringBuilder s_str = new StringBuilder();
            for (char c : s) {
                s_str.append(c);
            }
            result.add(s_str.toString());
            return;
        }
        char[] new_s = new char[s.length];
        System.arraycopy(s, 0, new_s, 0, s.length);

        for (int i = index; i < new_s.length; i++) {

            char temp = new_s[index];
            new_s[index] = new_s[i];
            new_s[i] = temp;

            find(result, new_s, index + 1);

            temp = new_s[index];
            new_s[index] = new_s[i];
            new_s[i] = temp;

        }
    }
}

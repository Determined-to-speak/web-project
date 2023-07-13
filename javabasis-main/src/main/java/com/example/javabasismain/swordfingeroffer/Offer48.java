package com.example.javabasismain.swordfingeroffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class Offer48 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }


    /**
     * 动态规划，也就是剑指offer的解题思路
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        sMap.put(s.charAt(0), 0);

        int result = 1;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (!sMap.containsKey(s.charAt(i))) {
                dp[i] = dp[i - 1] + 1;
            } else {
                int k = sMap.get(s.charAt(i));
                dp[i] = i - k > dp[i - 1] ? dp[i - 1] + 1 : i - k;
            }

            sMap.put(s.charAt(i), i);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}

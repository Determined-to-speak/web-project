package com.example.javabasismain.swordfingeroffer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer05 {

    /**
     * 这里注意Java中的数组是定长的，需要初始化长度，所以还是尽可能的使用list
     *
     * @param args
     */

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }


    public static String replaceSpace(String s) {
        char[] begin = s.toCharArray();
        int length = 0;
        for (char c : begin) {
            if (c == ' ') {
                length = length + 3;
            } else length++;
        }
        char[] result = new char[length];
        for (int j = length - 1, i = begin.length - 1; j >= 0 && i >= 0; ) {
            if (begin[i] != ' ') {
                result[j--] = begin[i--];
            } else {
                result[j--] = '0';
                result[j--] = '2';
                result[j--] = '%';
                i--;
            }
        }
        return String.copyValueOf(result);
    }

//    下面的这个方法是旧的方法，不可取
//    public static String replaceSpace(String s) {
//        if (s.length() == 0) {
//            return "";
//        }
//        char[] chars = s.toCharArray();
//        List<String> resultList = new ArrayList<>();
//        for (char aChar : chars) {
//            if (aChar == ' ') {
//                resultList.add("%");
//                resultList.add("2");
//                resultList.add("0");
//            } else {
//                resultList.add(String.valueOf(aChar));
//            }
//        }
//        return resultList.stream().collect(Collectors.joining());
//    }

}

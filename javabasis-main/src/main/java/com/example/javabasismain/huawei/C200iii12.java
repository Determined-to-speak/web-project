package com.example.javabasismain.huawei;

import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C200iii12 {
    static String[] cells;
    static Pattern p = Pattern.compile("(<.*?>)");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cells = sc.nextLine().split(",");
        System.out.println(getResult());
    }

    public static String getResult() {
        StringJoiner sj = new StringJoiner(",");

        for (int i = 0; i < cells.length; i++) {
            // 替换单元格中的引用，替换失败，则返回-1
            if (!changeCell(i)) return "-1";
            // 替换成功，则记录单元格内容
            sj.add(cells[i]);
        }

        return sj.toString();
    }

    public static boolean changeCell(int index) {
        // 通过正则匹配出单元格内容中"引用字符串"
        Matcher m = p.matcher(cells[index]);

        while (m.find()) {
            // reference记录引用字符串
            String reference = m.group(0);

            // 引用单元格编号只能是A~Z的字母，即引用引用字符串长度只能是3，比如"<A>"
            if (reference.length() != 3) {
                return false;
            }

            // 引用单元格的编号
            char reference_cellNum = reference.charAt(1);
            // 当前单元格的编号
            char self_cellNum = (char) ('A' + index);

            // 引用单元格编号只能是A~Z的字母，且不能自引用
            if (reference_cellNum < 'A' || reference_cellNum > 'Z' || reference_cellNum == self_cellNum) {
                return false;
            }

            // 引用单元格的数组索引， 'A' -> 0  ... 'Z' -> 25
            int reference_index = reference_cellNum - 'A';

            // 引用单元格编号不存在
            if (reference_index >= cells.length) {
                return false;
            }

            if (!changeCell(reference_index)) return false;

            // 将单元格内容中的引用部分，替换为被引用的单元格的内容
            cells[index] = cells[index].replaceAll(reference, cells[reference_index]);
            // 重新正则匹配
            m = p.matcher(cells[index]);
        }

        return true;
    }
}

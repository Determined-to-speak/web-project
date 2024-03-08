package com.example.javabasismain.huawei;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 华为OD机试 - 最长子字符串的长度(二)（Java & JS & Python & C & C++）
 */
public class C200iii43 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(getResult(s));
    }

    private static int getResult(String s) {
        int status = 0b000;
        ArrayList<LinkedList<Integer>> map = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            map.add(new LinkedList<>());
        }
        map.get(0).add(-1);
        int maxLen = 0;

        for (int i = 0; i < s.length() * 2; i++) {
            char c = s.charAt(i % s.length());
            switch (c) {
                case 'l':
                    status ^= 0b100;
                    break;
                case 'o':
                    status ^= 0b010;
                    break;
                case 'x':
                    status ^= 0b001;
                    break;
            }

            if (i < s.length()) {
                map.get(status).add(i);
            }

            while (map.get(status).size() > 0) {
                int earliest = map.get(status).getFirst();
                if (i - earliest > s.length()) {
                    map.get(status).removeFirst();
                } else {
                    maxLen = Math.max(maxLen, i - earliest);
                    break;
                }
            }
        }
        return maxLen;
    }
}

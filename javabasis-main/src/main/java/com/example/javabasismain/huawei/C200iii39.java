package com.example.javabasismain.huawei;

import java.util.Scanner;

/**
 * 华为OD机试 - 反射计数（Java & JS & Python & C & C++）
 */

public class C200iii39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        int t = sc.nextInt();

        char[][] matrix = new char[h][w];
        for (int i = 0; i < h; i++) {
            matrix[i] = sc.next().toCharArray();
        }
        int ans = 0;
        while (t >= 0) {
            if (matrix[y][x] == '1') {
                ans++;
            }
            y += sy;
            x += sx;
            if (x < 0) {
                x = 1;
                sx = -sx;
            } else if (x >= w) {
                x = w - 2;
                sx = -sx;
            }

            if (y < 0) {
                y = 1;
                sy = -sy;
            } else if (y >= h) {
                y = h - 2;
                sy = -sy;
            }
            t--;
        }
        System.out.println(ans);
    }
}

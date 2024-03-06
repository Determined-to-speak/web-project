package com.example.javabasismain.huawei;


import java.util.LinkedList;
import java.util.Scanner;

/**
 * 亲子游戏
 */
public class C200iii23 {

    static int n;
    static int[][] matrix;
    static int[][] candy;
    static int[][] offsets = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
        candy = new int[n][n];

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                candy[i][j] = -1;
                matrix[i][j] = sc.nextInt();
                //妈妈的位置
                if (matrix[i][j] == -3) {
                    candy[i][j] = 0;
                    queue.add(i * n + j); // 二维坐标一维化
                }
            }
        }
        //记录题解
        int ans = -1;
        //bfs按层数扩散
        while (queue.size() > 0) {
            //记录当前扩散层数的点
            LinkedList<Integer> newQueue = new LinkedList<>();
            boolean flag = false;
            for (int pos : queue) {
                int x = pos / n;
                int y = pos % n;

                for (int[] offset : offsets) {
                    int newX = x + offset[0];
                    int newY = y + offset[1];
                    if (newX < 0 || newX >= n || newY < 0 || newY >= n) {
                        continue;
                    }

                    if (candy[newX][newY] == -1) {
                        newQueue.addLast(newX * n + newY);
                    }

                    candy[newX][newY] = Math.max(candy[newX][newY], candy[x][y] + Math.max(0, matrix[newX][newY]));
                    if (matrix[newX][newY] == -2) {
                        ans = candy[newX][newY];
                        flag = true;
                    }
                }
            }
            if (flag) break;
            queue = newQueue;
        }
        System.out.println(ans);
    }
}

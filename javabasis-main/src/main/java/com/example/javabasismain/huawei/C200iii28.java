package com.example.javabasismain.huawei;


import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 华为OD机试 - 路口最短时间问题（Java & JS & Python & C & C++）
 */

public class C200iii28 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] lights = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                lights[i][j] = sc.nextInt();
            }
        }

        int timePreRoad = sc.nextInt();

        int rowStart = sc.nextInt();
        int colStart = sc.nextInt();

        int rowEnd = sc.nextInt();
        int colEnd = sc.nextInt();

        System.out.println(new Solution().calcTime(lights, timePreRoad, rowStart, colStart, rowEnd, colEnd));
    }


    static class Solution {
        static int[][] offsets = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int calcTime(int[][] lights, int timePerRoad, int rowStart, int colStart, int rowEnd, int colEnd) {
            int n = lights.length;
            int m = lights[0].length;

            int[][][] dist = new int[n][m][4];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < 4; k++) {
                        dist[i][j][k] = Integer.MAX_VALUE;
                    }
                }
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[4] - b[4]);
            for (int k = 0; k < 4; k++) {
                dist[rowStart][colStart][k] = 0;
                pq.add(new int[]{-1, -1, rowStart, colStart, 0});
            }
            while (pq.size() > 0) {
                int[] tmp = pq.poll();

                int preX = tmp[0];
                int preY = tmp[1];
                int curX = tmp[2];
                int curY = tmp[3];
                int cost = tmp[4];

                for (int k = 0; k < 4; k++) {
                    int newX = curX + offsets[k][0];
                    int newY = curY + offsets[k][1];

                    if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
                    if (newX == preX && newY == preY) continue;
                    int newCost = cost + timePerRoad;
                    if (preX != -1 && preY != -1 && getDirection(preX, preY, curX, curY, newX, newY) >= 0) {
                        newCost += lights[curX][curY];
                    }
                    if (newCost >= dist[newX][newY][k]) continue;
                    dist[newX][newY][k] = newCost;
                    pq.add(new int[]{curX, curY, newX, newY, newCost});
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                ans = Math.min(ans, dist[rowEnd][colEnd][i]);
            }
            return ans;
        }

        public static int getDirection(int preX, int preY, int curX, int curY, int nextX, int nextY) {
            //向量 pre->cur
            int dx1 = curX - preX;
            int dy1 = curY - preY;
            //向量 cur->next
            int dx2 = nextX - curX;
            int dy2 = nextY - curY;
            return dx1 * dy2 - dx2 * dy1;
        }
    }
}

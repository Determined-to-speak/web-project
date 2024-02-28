package com.example.javabasismain.huawei;

import java.util.Scanner;

/**
 * 5G网络建设
 * <p>
 * https://blog.csdn.net/qfc_128220/article/details/134844501
 */
public class C200iii07 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //基站数量(节点数)
        int n = sc.nextInt();
        //基站对数量(边数)
        int m = sc.nextInt();

        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            int p = sc.nextInt();

            if (p == 0) {
                graph[x][y] = z;
                graph[y][x] = z;
            } else {
                graph[x][y] = 0;
                graph[y][x] = 0;
            }
        }

    }

    public static int prim(int[][] graph, int n) {
        //记录最小生成树的边权和
        int minWeight = 0;
        //inTree[i] 表示 节点i  是否在最小生成树中
        boolean[] inTree = new boolean[n + 1];
        //初始化时任选一个节点作为最小生成树的初始节点
        inTree[1] = true;
        //记录最小生成树中点的数量
        int inTree_count = 1;
        //dis[i]表示 节点i 到最小生成树集合 的最短距离
        int[] dis = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dis[i] = graph[1][i];
        }
        //如果最小生成树的数量达到n个，则结束循环
        while (inTree_count < n) {
            //minDis 记录这个最短距离
            int minDis = Integer.MAX_VALUE;
            //idx记录距离最小生成树minDis个距离的节点
            int nodeIdx = 0;

            // 从未纳入最小生成树的点中，找到一个距离最小生成树最近的
            for (int i = 1; i <= n; i++) {
                if (!inTree[i] && dis[i] < minDis) {
                    minDis = dis[i];
                    nodeIdx = i;
                }
            }

            if (nodeIdx == 0) {
                return -1;
            }

            inTree[nodeIdx] = true;
            inTree_count++;
            minWeight += dis[nodeIdx];

            for (int i = 1; i <= n; i++) {
                if (!inTree[i] && graph[nodeIdx][i] < dis[i]) {
                    dis[i] = graph[nodeIdx][i];
                }
            }
        }
        return minWeight;
    }
}

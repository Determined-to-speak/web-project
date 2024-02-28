package com.example.javabasismain.huawei;


import java.util.*;

/**
 * 743. 网络延迟时间      Dijkstra经典算法
 * <p>
 * 有 n 个网络节点，标记为 1 到 n。
 * <p>
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * <p>
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 */
public class C200iii03 {
    public static void main(String[] args) {

    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        //使用邻接表表示图结构
        Map<Integer, ArrayList<int[]>> graph = new HashMap<>();

        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new int[]{v, w});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> dist[a] - dist[b]);
        priorityQueue.add(k);

        while (priorityQueue.size() > 0) {
            k = priorityQueue.poll();

            if (graph.containsKey(k)) {
                for (int[] next : graph.get(k)) {
                    int v = next[0], w = next[1];
                    int newDist = dist[k] + w;
                    if (dist[v] > newDist) {
                        dist[v] = newDist;
                        priorityQueue.add(v);
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < dist.length; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

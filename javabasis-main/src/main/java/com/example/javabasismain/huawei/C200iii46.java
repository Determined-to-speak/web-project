package com.example.javabasismain.huawei;

import java.util.*;

/**
 * 华为OD机试 - 查找一个有向网络的头节点和尾节点（Java & JS & Python & C & C++）
 */
public class C200iii46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> next = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            set.add(a);
            set.add(b);
            inDegree.put(b, inDegree.getOrDefault(b, 0) + 1);
            next.putIfAbsent(a, new ArrayList<>());
            next.get(a).add(b);
        }

        // 图中总共total个节点
        int total = set.size();

        // head记录图的头节点
        int head = 0;

        // 队列记录入度为0的点
        LinkedList<Integer> queue = new LinkedList<>();
        for (int p : set) {
            // 题目描述中说图中只有一个首节点，首节点是入度为0的节点，因此如果某节点p没有入度，则为头节点
            if (!inDegree.containsKey(p)) {
                head = p;
                queue.add(p);
                break;
            }
        }
        // tails记录所有尾节点
        ArrayList<Integer> tails = new ArrayList<>();

        // count记录已被剥去的点个数，如果图中存在环，则必然最终count < total
        int count = 0;

        while (queue.size() > 0) {
            int fa = queue.removeFirst();
            count++;

            if (!next.containsKey(fa)) {
                tails.add(fa);
                continue;
            }
            for (int ch : next.get(fa)) {
                inDegree.put(ch, inDegree.get(ch) - 1);
                if (inDegree.get(ch) == 0) {
                    queue.add(ch);
                }
            }
        }
        if (count != total) {
            System.out.println(-1);
        } else {
            StringJoiner sj = new StringJoiner(" ");
            sj.add(head + "");
            tails.stream().sorted((a, b) -> a - b).forEach(p -> sj.add(p + " "));
            System.out.println(sj);
        }
    }
}

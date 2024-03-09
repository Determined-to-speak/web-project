package com.example.javabasismain.huawei;

import java.util.*;

/**
 * 华为OD机试 - 找城市（Java & JS & Python & C & C++）
 */
public class C200iii56 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] relations = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            relations[i][0] = sc.nextInt();
            relations[i][1] = sc.nextInt();
        }

        System.out.println(getResult(n, relations));
    }

    private static String getResult(int n, int[][] relations) {
        int minDp = Integer.MAX_VALUE;
        List<Integer> city = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            UnionFindSet ufs = new UnionFindSet(n + 1);
            for (int[] relation : relations) {
                int x = relation[0];
                int y = relation[1];
                if (x == i || y == i) continue;
                ufs.union(x, y);
            }

            int[] cnts = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                int fa = ufs.find(j);
                cnts[fa]++;
            }

            int dp = Arrays.stream(cnts).max().orElse(0);
            if (dp < minDp) {
                minDp = dp;
                city = new ArrayList<>();
                city.add(i);
            } else if (dp == minDp) {
                city.add(i);
            }
        }

        city.sort((a, b) -> a - b);
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (Integer c : city) {
            stringJoiner.add(c + "");
        }
        return stringJoiner.toString();
    }


    /**
     * 求图的联通分量一般使用并查集实现
     */
    static class UnionFindSet {
        int[] fa;

        public UnionFindSet(int n) {
            this.fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        public int find(int x) {
            if (this.fa[x] != x) {
                return this.fa[x] = this.find(this.fa[x]);
            }
            return x;
        }

        public void union(int x, int y) {
            int x_fa = find(x);
            int y_fa = find(y);
            if (x_fa != y_fa) {
                this.fa[y_fa] = x_fa;
            }
        }

    }
}

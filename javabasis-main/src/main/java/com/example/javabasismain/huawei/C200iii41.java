package com.example.javabasismain.huawei;

import java.util.*;

/**
 * 华为OD机试 - 特殊的加密算法（Java & JS & Python & C & C++）
 * <p>
 * <p>
 * 本题可以使用深度优先搜索DFS解题
 * <p>
 * 深度优先搜索的顺序是有讲究的，需要按照上、左、右、下的顺序依次深搜
 */
public class C200iii41 {

    //明文的数字个数
    static int n;
    //明文
    static int[] datas;
    //密码本矩阵大小
    static int m;
    //密码本
    static int[][] secrets;
    //上、左、右、下的偏移量
    static int[][] offsets = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        datas = new int[n];
        for (int i = 0; i < n; i++) {
            datas[i] = scanner.nextInt();
        }
        List<Integer> starts = new ArrayList<>();
        m = scanner.nextInt();
        secrets = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                secrets[i][j] = scanner.nextInt();
                if (datas[0] == secrets[i][j]) {
                    starts.add(i * m + j);
                }
            }
        }
        System.out.println(getResult(starts));

    }

    private static String getResult(List<Integer> starts) {
        for (int start : starts) {
            int x = start / m;
            int y = start % m;

            boolean[][] used = new boolean[m][m];
            used[x][y] = true;
            LinkedList<String> path = new LinkedList<>();
            path.add(x + " " + y);
            //开始深度搜索
            if (dfs(x, y, 1, path, used)) {
                StringJoiner stringJoiner = new StringJoiner(" ");
                for (String pos : path) {
                    stringJoiner.add(pos);
                }
                return stringJoiner.toString();
            }
        }
        return "error";
    }

    /**
     * @param x     当前位置的横坐标
     * @param y     当前位置的纵坐标
     * @param index datas[index]是将要匹配的明文数字
     * @param path  路径
     * @param used  密码本各元素使用情况
     * @return
     */
    private static boolean dfs(int x, int y, int index, LinkedList<String> path, boolean[][] used) {
        if (index == n) {
            return true;
        }
        for (int[] offset : offsets) {
            int newX = x + offset[0];
            int newY = y + offset[1];
            if (newX < 0 || newX >= m || newY < 0 || newY >= m || used[newX][newY] || secrets[newX][newY] != datas[index])
                continue;
            path.add(newX + " " + newY);
            used[newX][newY] = true;
            if (dfs(newX, newY, index + 1, path, used)) {
                return true;
            }
            used[newX][newY] = false;
            path.removeLast();
        }
        return false;
    }
}

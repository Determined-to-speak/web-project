package com.example.javabasismain.huawei;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 跳格子3
 */
public class C200iii20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] scores = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(n, scores, k));

    }

    private static int getResult(int n, int[] scores, int k) {
        //第i个格子，可以从第i-k个格子~第i-1个格子跳过来，因此本题的滑动窗口的长度为 k+1
        k++;
        int[] dp = new int[n];
        dp[0] = scores[0];

        //单调队列（单调递减，队首是滑窗最大值）
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(dp[0]);

        //滑动窗口的形成过程
        for (int i = 1; i < Math.min(k, n); i++) {
            dp[i] = queue.getFirst() + scores[i];
            while (queue.size() > 0 && dp[i] > queue.getLast()) {
                queue.removeLast();
            }
            queue.addLast(dp[i]);
        }

        //滑窗的右移过程（老滑窗失去一个首元素，新增一个尾元素）
        for (int i = k; i < n; i++) {
            if (dp[i - k] == queue.getFirst()) {
                queue.removeFirst();
            }

            dp[i] = queue.getFirst() + scores[i];
            while (queue.size() > 0 && dp[i] > queue.getLast()) {
                queue.removeLast();
            }
            queue.addLast(dp[i]);
        }

        return dp[n - 1];
    }


}

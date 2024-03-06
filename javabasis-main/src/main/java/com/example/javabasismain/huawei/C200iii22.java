package com.example.javabasismain.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 项目排期
 */

public class C200iii22 {

    static int[] tmp;
    static Integer[] balls;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        tmp = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = tmp.length;
        balls = new Integer[length];
        int i = 0;
        for (int t : tmp) {
            balls[i] = tmp[i];
            i++;
        }
        n = Integer.parseInt(scanner.nextLine());

        System.out.println(getResult());
    }

    private static int getResult() {
        Arrays.sort(balls, (a, b) -> b - a);
        int min = balls[0];
        int max = Arrays.stream(balls).reduce(Integer::sum).get();
        int ans = max;
        while (min <= max) {
            int mid = (min + max) >> 1;
            if (check(0, new int[n], mid)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }


    /**
     * @param index   当前轮次要装入的球的索引
     * @param buckets 桶数组
     * @param limit   每个桶的最大可用容量
     * @return
     */
    private static boolean check(int index, int[] buckets, int limit) {
        if (index == balls.length) return true;
        int selected = balls[index];
        for (int i = 0; i < buckets.length; i++) {
            if (i > 0 && buckets[i] == buckets[i - 1]) continue;
            if (selected + buckets[i] <= limit) {
                buckets[i] += selected;
                if (check(index + 1, buckets, limit)) {
                    return true;
                }
                buckets[i] -= selected;
            }
        }
        return false;
    }


}

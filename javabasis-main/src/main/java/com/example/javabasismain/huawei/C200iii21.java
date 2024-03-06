package com.example.javabasismain.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 贪吃的猴子
 */
public class C200iii21 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = Integer.parseInt(sc.nextLine());
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(len, nums, n));
    }

    private static int getResult(int len, int[] nums, int n) {
        int leftSum = 0;
        int rightSum = 0;
        for (int i = len - n; i < len; i++) {
            rightSum += nums[i];
        }
        // 如果是全选的情况
        if (len == n) {
            return rightSum;
        }
        // 如果不是全选的情况
        int sum = leftSum + rightSum;
        int ans = sum;

        int l = 0;
        int r = len - n;
        while (l < n) {
            sum += nums[l++] - nums[r++];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}

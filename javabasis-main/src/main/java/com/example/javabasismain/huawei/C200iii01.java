package com.example.javabasismain.huawei;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 875. 爱吃香蕉的珂珂
 * <p>
 * https://leetcode.cn/problems/koko-eating-bananas/description/
 * 30,11,23,4,20
 * <p>
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 k（单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 */
public class C200iii01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] piles = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int h = Integer.parseInt(scanner.nextLine());
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int result = 0;
        if (piles.length > h) {
            return 0;
        }
        int max = Arrays.stream(piles).max().orElse(0);
        if (piles.length == h) {
            return max;
        }
        int min = 1;
        result = max;

        while (min <= max) {
            //这里使用二分法，速度从小到大，先用中间的速度开始试
            int mid = (min + max) / 2;
            if (check(mid, piles, h)) {
                result = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return result;
    }


    public static boolean check(int speed, int[] piles, int h) {
        int cost = 0;
        for (int i = 0; i < piles.length; i++) {
            cost += piles[i] / speed + (piles[i] % speed == 0 ? 0 : 1);
            if (cost > h) {
                return false;
            }
        }
        return true;
    }
}

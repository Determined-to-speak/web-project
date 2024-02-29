package com.example.javabasismain.huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class C200iii08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] heights = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int strength = Integer.parseInt(sc.nextLine());
        System.out.println(getResult(heights, strength));
    }

    public static int getResult(int[] heights, int strength) {
        HashSet<Integer> idxs = new HashSet<>();
        climb(heights, strength, idxs, true);
        reverse(heights);
        climb(heights, strength, idxs, false);
        return idxs.size();
    }

    public static void climb(int[] heights, int strength, HashSet<Integer> idxs, boolean direction) {
        int j = 0;
        while (j < heights.length && heights[j] != 0) {
            j++;
        }

        int cost = 0;

        for (int i = j + 1; i < heights.length; i++) {
            if (heights[i] == 0) {
                cost = 0;
                continue;
            }

            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                cost += diff * 3;

                if (i + 1 >= heights.length || heights[i] > heights[i + 1]) {
                    if (cost < strength) {
                        if (direction) {
                            idxs.add(i);
                        } else {
                            idxs.add(heights.length - i - 1);
                        }
                    }
                }
            } else if (diff < 0) {
                cost -= diff * 3;
            }
        }
    }

    public static void reverse(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}






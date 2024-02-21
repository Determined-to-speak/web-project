package com.example.javabasismain.swordfingeroffer;

/**
 * JZ53 数字在升序数组中出现的次数   使用二分法查找数据
 *
 * <p>
 * 描述
 * 给定一个长度为 n 的非降序数组和一个非负数整数 k ，要求统计 k 在数组中出现的次数
 * <p>
 * 数据范围：
 * 0≤n≤1000, 0≤k≤100，数组中每个元素的值满足 0≤val≤100
 * 要求：空间复杂度 O(1)，时间复杂度 O(logn)
 * <p>
 * https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2
 */

public class Offer53I {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 3, 3, 3};
        int k = 3;
        System.out.println(GetNumberOfK(nums, k));
    }

    public static int GetNumberOfK(int[] nums, int k) {
        // write code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int number = 0;

        int first = getFirst(nums, k, 0, nums.length - 1);
        int last = getEnd(nums, k, 0, nums.length - 1);

        if (last > -1 && first > -1) {
            number = last - first + 1;
        }
        return number;
    }


    private static int getFirst(int[] nums, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = (end + start) / 2;
        int middleNum = nums[middleIndex];
        if (middleNum == k) {
            if (middleIndex == 0 || (middleIndex > 0 && nums[middleIndex - 1] != k)) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if (middleNum > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }

        return getFirst(nums, k, start, end);
    }

    private static int getEnd(int[] nums, int k, int start, int end) {

        if (start > end) {
            return -1;
        }
        int middleIndex = (end + start) / 2;
        int middleNum = nums[middleIndex];
        if (middleNum == k) {
            if (middleIndex == nums.length - 1 || (middleIndex > 0 && nums[middleIndex + 1] != k)) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
        } else if (middleNum < k) {
            start = middleIndex + 1;
        } else {
            end = middleIndex - 1;
        }

        return getEnd(nums, k, start, end);

    }


//    public static int GetNumberOfK(int[] nums, int k) {
//        // write code here
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        Map<Integer, Integer> times = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (times.containsKey(nums[i])) {
//                times.put(nums[i], times.get(nums[i]) + 1);
//            } else {
//                times.put(nums[i], 1);
//            }
//        }
//        return times.getOrDefault(k, 0);
//    }
}


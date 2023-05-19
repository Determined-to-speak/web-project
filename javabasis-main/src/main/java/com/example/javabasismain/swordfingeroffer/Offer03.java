package com.example.javabasismain.swordfingeroffer;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer03 {

    public static void main(String[] args) {
        int result = findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
        System.out.println(result);
    }

    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i <= nums.length - 1; i++) {
            while (nums[i] != i) {
                //对每一位上的数字一直循环到应该是他位置的地方
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }

                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;

            }
        }
        return -1;
    }
}

package com.example.javabasismain.swordfingeroffer;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer14I {

    public static void main(String[] args) {
        System.out.println(cuttingRope(2));
        System.out.println(cuttingRope(10));
        System.out.println(cuttingRope(5));
        System.out.println(cuttingRope(12));
    }

    public static int cuttingRope(int n) {

        //必须切的话，返回固定的结果
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;


        int[] result = new int[n + 1];
        //下面这5个长度，在切的时候默认不进行切割，不切比切的结果大。
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        result[4] = 4;

        int max = 0;
        for (int i = 5; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= i / 2 ; j++) {
                int indexdata = result[j] * result[i - j];
                max = Math.max(max, indexdata);
                result[i] = max;
            }
        }
        return result[n];
    }

}

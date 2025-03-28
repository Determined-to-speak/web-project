package com.example.javabasismain.swordfingeroffer;

import java.math.BigInteger;
import java.util.Arrays;

public class Offer14II {

    public static void main(String[] args) {
        System.out.println(cuttingRope(2));
        System.out.println(cuttingRope(10));
        System.out.println(cuttingRope(5));
        System.out.println(cuttingRope(12));
        System.out.println(cuttingRope(127));
    }


    public static int cuttingRope(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
        Arrays.fill(dp, BigInteger.valueOf(1));
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = dp[i].max(BigInteger.valueOf(j * (i - j))).max(dp[i - j].multiply(BigInteger.valueOf(j)));
            }
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }

}

package com.example.javabasismain.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class C200iii14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String nBinStr = "0" + Integer.toBinaryString(n);
        char[] mBinCharArr = nBinStr.toCharArray();

        int countOne = 0;

        for (int i = mBinCharArr.length - 2; i >= 0; i--) {
            if (mBinCharArr[i] == '0' && mBinCharArr[i + 1] == '1') {
                mBinCharArr[i] = '1';
                mBinCharArr[i + 1] = '0';

                if (countOne > 0) {
                    for (int j = i + 2; j < mBinCharArr.length; j++) {
                        if (j < mBinCharArr.length - countOne) {
                            mBinCharArr[j] = '0';
                        } else {
                            mBinCharArr[j] = '1';
                        }
                    }
                }
                break;
            }
            if (mBinCharArr[i + 1] == '1') countOne++;
        }

        int result = Integer.parseInt(new String(mBinCharArr), 2);

        System.out.println(result);

    }


}

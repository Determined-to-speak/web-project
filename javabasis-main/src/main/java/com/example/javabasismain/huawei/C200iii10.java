package com.example.javabasismain.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class C200iii10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        int[] requirements = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getResult(m, requirements));
    }

    public static long getResult(int m, int[] requirement) {
        Arrays.sort(requirement);

        int n = requirement.length;
        long min = requirement[n - 1];
        long max = requirement[n - 1] + requirement[n - 2];
        long result = max;

        while (min <= max) {
            long mid = (min + max) >> 1;
            if (check(mid, m, requirement)) {
                result = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return result;
    }

    public static boolean check(long limit, int m, int[] requirement) {
        int l = 0;
        int r = requirement.length - 1;

        int need = 0;
        while (l <= r) {
            if (requirement[l] + requirement[r] <= limit) {
                l++;
            }
            r--;
            need++;
        }
        return m >= need;
    }


}

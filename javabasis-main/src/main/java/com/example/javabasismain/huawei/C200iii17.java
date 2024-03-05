package com.example.javabasismain.huawei;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 根据IP查找城市
 */
public class C200iii17 {

    static class Range {
        String city;
        long startIpDec;
        long endIpDec;
        long ipLen;

        public Range(String city, String startIpStr, String endIpStr) {
            this.city = city;
            this.startIpDec = ip2dec(startIpStr);
            this.endIpDec = ip2dec(endIpStr);
            this.ipLen = this.endIpDec - this.startIpDec + 1;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Range> ranges = new ArrayList<>();

        //城市IP列表
        String[] cities = sc.nextLine().split(";");
        //待查询的IP列表
        String[] queryIps = sc.nextLine().split(",");

        for (String city : cities) {
            String[] tmp = city.split("[=,]");
            ranges.add(new Range(tmp[0], tmp[1], tmp[2]));
        }

        StringJoiner result = new StringJoiner(",");
        for (String ip : queryIps) {
            long ipDec = ip2dec(ip);
            String city = "";
            long minLen = Long.MAX_VALUE;

            //将待查询IP与城市IP段列表逐一匹配
            for (Range range : ranges) {
                //如果带查询IP地址，在某一城市的IP段范围内，且该城市的IP长度更小，则该城市是待查询的
                if (ipDec >= range.startIpDec && ipDec <= range.endIpDec && minLen > range.ipLen) {
                    city = range.city;
                    minLen = range.ipLen;
                }
            }
            result.add(city);
        }
        System.out.println(result);
    }

    /**
     * IP地址转整形
     *
     * @param ip
     * @return
     */
    private static long ip2dec(String ip) {
        long res = 0;
        String[] blocks = ip.split("\\.");
        for (String block : blocks) {
            res = (Integer.parseInt(block)) | (res << 8);
        }
        return res;
    }


}

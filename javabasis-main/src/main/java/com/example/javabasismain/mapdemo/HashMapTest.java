package com.example.javabasismain.mapdemo;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        // initialCapacity只是初始化的容量，之后是可以逐渐扩大的
        Map<Integer, String> a = new HashMap<Integer, String>(3);
        a.put(1, "111");
        a.put(2, "222");
        a.put(3, "333");
        a.put(4, "444");
        for (Map.Entry entry : a.entrySet()) {
            System.out.println(entry.getValue());
        }

        // remove会返回删除的value
        String removeString = a.remove(2);
        System.out.println("remove的String为：----" + removeString + "----");
    }


}

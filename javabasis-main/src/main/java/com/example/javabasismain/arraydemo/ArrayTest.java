package com.example.javabasismain.arraydemo;


import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        getStringArrayFromObjectArray();
    }

    //获取Object数组中的字符串类型数据
    public static void getStringArrayFromObjectArray() {
        Object[] obj3 = {1, 2, 3, "4", "5"};
        String[] obj4 = new String[5];
        try {
            System.arraycopy(obj3, 3, obj4, 3, 2);
        } catch (Exception e) {
            System.out.println("transfer exception:" + e);
        }
        System.out.println(Arrays.toString(obj3));
        //[null, null, null, 4, 5]
        System.out.println(Arrays.toString(obj4));
        obj3[3] = "zhangssan";
        System.out.println("查看是浅复制还是深复制~~~~~");
        System.out.println(Arrays.toString(obj3));
        System.out.println(Arrays.toString(obj4));
    }

}

package com.example.javabasismain.stringutildemo;


import org.springframework.util.StringUtils;

/**
 *
 */
public class SpringStringUtilTest {

    public static void main(String[] args) {

        String[] atrs = StringUtils.delimitedListToStringArray("1,2,3,4;5", ",;");
        for (String str : atrs) {
            System.out.println(str);
        }
        String[] btrs = StringUtils.tokenizeToStringArray("1,2,3,4;5", ",;");
        for (String str : btrs) {
            System.out.println(str);
        }

    }
}

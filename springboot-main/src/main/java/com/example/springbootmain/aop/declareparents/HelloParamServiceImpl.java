package com.example.springbootmain.aop.declareparents;

public class HelloParamServiceImpl implements HelloParamService {
    @Override
    public String printOut(String str) {
        if (str.equals("PHP")) {
            return "{PHP}";
        } else if (str.equals("JAVA")) {
            return "[JAVA]";
        }
        return str;
    }
}

package com.test.consumer.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class JsonTest
{
    public static void main(String[] args)
    {
        List<Test> tests = new ArrayList<>();
        tests.add(new Test(null));

        System.out.println(JSON.toJSONString(tests));
    }



}
class Test{
    private String name;

    public Test(String name)
    {
        this.name = name;
    }
}
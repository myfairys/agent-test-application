package com.test.consumer.test;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.JsonArray;
import com.test.consumer.ConsumerApplication;
import com.test.consumer.controller.DemoController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassLoaderTest {
    public static void main(String[] args) {

        List<Entity> entities = new ArrayList<>();
        entities.add(new Entity(1, "a"));
        entities.add(new Entity(2, "b"));
        entities.add(new Entity(3, "c"));

        String entity = JSONArray.toJSONString(entities);
        System.out.println(entity);

//        Map map = new HashMap();
//        map.put(1, 3);
//        map.put(2, 4);
//        map.forEach((key, value)->{
//            System.out.println("key="+ key + " value=" + value);
//
//        });
//        System.out.println("ClassLoader.getSystemClassLoader()" + null);
    }
}

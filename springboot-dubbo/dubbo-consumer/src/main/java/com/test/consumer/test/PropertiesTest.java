package com.test.consumer.test;

import com.test.consumer.entity.ParamTest;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IllegalAccessException {
//        Properties properties = System.getProperties();
//        properties.forEach((key, value)->{
//            System.out.println(key + "=" + value);
//        });
//        String test = "${name:12}";
//        int indexStart = test.indexOf("${");
//        System.out.println(indexStart);
//        System.out.println(test.indexOf("}"));
//        System.out.println(test.indexOf("*"));
//        StringBuilder stringBuilder = new StringBuilder(test);
//        stringBuilder.replace(0, 11, "19");
//        System.out.println(stringBuilder);
//        LinkedList<String> linkedList = new LinkedList<>();
//        System.out.println(String.join(".", linkedList));
        Field[] fields = ParamTest.class.getFields();
        for (Field field : fields) {
            Type type = field.getType();
            if (type.equals(Map.class)) {
                System.out.println(field.getGenericType().getTypeName());
                ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
                System.out.println(parameterizedType);
                Type[] types = parameterizedType.getActualTypeArguments();
                Type key = null;
                Type value = null;
                if (types != null && types.length != 0) {
                    key = types[0];
                    value = types[1];
                }
                Map map = (Map) field.get(null);
                System.out.println(map);
                System.out.println("key:" + key);
                System.out.println("value:" + value);
            }
        }
    }
}

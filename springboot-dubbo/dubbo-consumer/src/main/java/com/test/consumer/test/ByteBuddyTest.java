package com.test.consumer.test;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;

public class ByteBuddyTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        DynamicType.Unloaded unloaded = new ByteBuddy()
                .subclass(Object.class)
                .name("Hello")
                .method(ElementMatchers.named("toString"))
                .intercept(FixedValue.value("vxvsd"))
                .make();
        Class<?> tClass = unloaded.load(ByteBuddyTest.class.getClassLoader()).getLoaded();

        System.out.println(tClass.newInstance().toString());
    }
}

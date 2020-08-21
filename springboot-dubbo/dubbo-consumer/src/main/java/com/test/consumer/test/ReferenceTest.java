package com.test.consumer.test;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ReferenceTest {

    private int name;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public static void main(String[] args) {
//        ReferenceTest test = new ReferenceTest();
//        ReferenceTest[] tests = new ReferenceTest[]{test, test, test};
//        System.out.println(tests.length);

//        Interface i = new ImpClass();
//        i.test();
//        ImpClass impClass = new ImpClass();
//        impClass.test();
//        impClass.print();
        ImpClass.get();

        sum();
    }

    public static int sum() {
        int a =6;
        int b = 6;
        int c = a + b;
        return 4;
    }
}

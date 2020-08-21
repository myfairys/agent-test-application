package com.test.consumer.test;

public class ByteBuddyUse {

    public void print() {

    }
    public static void main(String[] args) {
        ByteBuddyUse use = new ByteBuddyUse();
        use.print();
        Integer localVar = 0;
        localVar++;
        /*
         LINENUMBER 11 L2
    ICONST_0  加载常量0入栈
    INVOKESTATIC java/lang/Integer.valueOf (I)Ljava/lang/Integer;  装箱
    ASTORE 2 存储0值到局部变量2中

        ALOAD 2  将局部变量2中的引用类型装载到栈顶
        ASTORE 3 存储到局部变量3中
        ALOAD 2 又将局部变量2中的引用类型装载到栈顶
        INVOKEVIRTUAL java/lang/Integer.intValue ()I 调用虚方法拆箱
        ICONST_1  加载常量1值入栈
        IADD  将栈顶两个值相加
        INVOKESTATIC java/lang/Integer.valueOf (I)Ljava/lang/Integer;  调用静态方法装箱
        DUP  复制栈顶一个字长元素，并压栈
        ASTORE 2  存储到局部变量2中
        ASTORE 4 存储到局部变量4中
        ALOAD 3  装载局部变量3中的引用类型
        POP  从栈顶弹出元素*/


        float fl = (float)1;
        fl=3;
        int bn =0;
        bn++;


        int j = 20;
        int a = 0;
        int b = -1;
        int c = -128;
        int d = 127;
        int e = 1289783249;
        int f = 12312;

        int t = a ^ d;
        String s = "hello world i like you very much";
        a = a << 5;
        if (a < b) {

        }


        ByteBuddyUse use2 = new ByteBuddyUse();
        ByteBuddyUse use3 = new ByteBuddyUse();
        if (use2 != use3) {
            throw new RuntimeException("not equal");
        }
    }
}

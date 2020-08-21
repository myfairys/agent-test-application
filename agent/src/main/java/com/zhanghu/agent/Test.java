package com.zhanghu.agent;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test
{
    public static void main(String[] args)
    {
    outputClazz(generate());
    }

    public static byte[] generate()
    {
//        ClassWriter classWriter = new ClassWriter(0);
//        classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "com/zhanghu/agent/OuterClass", null
//                , "java/lang/Object", null);
//        classWriter.visitInnerClass("com/zhanghu/agent/OuterClass$InnerClass", "com/zhanghu/agent/OuterClass"
//        ,"InnerClass",Opcodes.ACC_PRIVATE);

//        classWriter.visitEnd();
        ClassWriter classWriter1 = new ClassWriter(0);
        classWriter1.visit(Opcodes.V1_8, Opcodes.ACC_PRIVATE, "com/zhanghu/agent/OuterClass$InnerClass", null, "java/lang/Object", null);
        classWriter1.visitInnerClass("com/zhanghu/agent/OuterClass$InnerClass","com/zhanghu/agent/OuterClass"
        ,"InnerClass", Opcodes.ACC_PRIVATE);
        classWriter1.visitField(Opcodes.ACC_FINAL+Opcodes.ACC_SYNTHETIC, "this$0","Lcom/zhanghu/agent/TestOuter;",null,null);

        return classWriter1.toByteArray();
    }

    public static void outputClazz(byte[] bytes) {
        // 输出类字节码
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("TestSumOne.class");
            System.out.println("ASM类输出路径：" + (new File("")).getAbsolutePath());
            out.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != out) try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package agent;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.AdviceAdapter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import static org.objectweb.asm.Opcodes.ASM5;


public class AsmTransformer implements ClassFileTransformer
{
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException
    {

        ClassReader classReader = new ClassReader(classfileBuffer);
        ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_MAXS);
        classReader.accept(new MyClassVisitor(classWriter, className),0);
        return classfileBuffer;
    }

    static class MyClassVisitor extends ClassVisitor
    {
        public MyClassVisitor(ClassWriter classWriter, String className)
        {
            super(ASM5,classWriter);
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions)
        {

            if (!"sum".equals(name)) return super.visitMethod(access, name, descriptor, signature, exceptions);

            System.out.println("access：" + access);
            System.out.println("name：" + name);
            System.out.println("desc：" + descriptor);
            System.out.println("signature：" + signature);

            MethodVisitor mv = cv.visitMethod(access, name, descriptor, signature, exceptions);

            return new ProfilingMethodVisitor(mv, access, name, descriptor);
        }

        static class ProfilingMethodVisitor extends AdviceAdapter
        {

            private String name;

            protected ProfilingMethodVisitor(MethodVisitor methodVisitor, int access, String name, String descriptor) {
                super(ASM5, methodVisitor, access, name, descriptor);
                this.name = name;
            }

            @Override
            public void visitVarInsn(int opcode, int var) {
                super.visitVarInsn(opcode, var);
            }

            @Override
            public void visitFieldInsn(int opcode, String owner, String name, String descriptor) {
                super.visitFieldInsn(opcode, owner, name, descriptor);
            }

            @Override
            protected void onMethodEnter() {
                // 输出方法和参数 sum
                mv.visitLdcInsn(name);
                mv.visitInsn(ICONST_2);
                mv.visitIntInsn(NEWARRAY, T_INT);
                mv.visitInsn(DUP);
                mv.visitInsn(ICONST_0);
                mv.visitVarInsn(ILOAD, 1);
                mv.visitInsn(IASTORE);
                mv.visitInsn(DUP);
                mv.visitInsn(ICONST_1);
                mv.visitVarInsn(ILOAD, 2);
                mv.visitInsn(IASTORE);
                mv.visitMethodInsn(INVOKESTATIC, "org/itstack/demo/asm/MonitorLog", "info", "(Ljava/lang/String;[I)V", false);
            }

        }

    }

    private static void outputClazz(byte[] bytes) {
        // 输出类字节码
        FileOutputStream out = null;
        try {
            String pathName = AsmTransformer.class.getResource("/").getPath() + "AsmTestMonitor.class";
            out = new FileOutputStream(new File(pathName));
            System.out.println("ASM类输出路径：" + pathName);
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

package agent;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class JavaassistAgent
{
    public static void premain(String args, Instrumentation instrumentation)
    {
        System.out.println("args: " + args);
        instrumentation.addTransformer(new MyTransformer());
    }

    public static class MyTransformer implements ClassFileTransformer{
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException
        {

            if (className.contains("/controller/"))
            {
                System.out.println("className: " + className);
                String clzName = className.replace("/", ".");
                ClassPool classPool = ClassPool.getDefault();
                try
                {
                    CtClass ctClass = classPool.get(clzName);
                    CtMethod[] ctMethods = ctClass.getDeclaredMethods();
                    for (CtMethod ctMethod : ctMethods)
                    {
                        System.out.println("method:" + ctMethod);
                        ctMethod.insertBefore("System.out.println(111);");
                        ctMethod.insertAfter("System.out.println(111);");
                    }
                    return ctClass.toBytecode();
                }
               catch (Exception e)
               {
                   e.printStackTrace();
               }
            }
            return classfileBuffer;
        }
    }
}

package com.JVM;
import com.sun.crypto.provider.DESKeyFactory;

/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/4/8 10:02
 */
public class myTest {

    private static  User user = new User();
    private  static final int COUNT=100;

    public static void main(String[] args) {
        String.class.getClassLoader();
        System.out.println(String.class.getClassLoader());
        System.out.println(DESKeyFactory.class.getClassLoader());
        System.out.println(myTest.class.getClassLoader());

        System.out.println("-------------------");

        System.out.println(ClassLoader.getSystemClassLoader());
        ClassLoader extclassLoader =  myTest.class.getClassLoader().getParent();
        System.out.println(extclassLoader);
        ClassLoader bootclassloader = extclassLoader.getParent();
        System.out.println(bootclassloader);

        System.out.println("-------------------");

        User user = new User();
        System.out.println("没有赋值    "+user.getAge());

        myTest.user.setAge(10);


    }
}

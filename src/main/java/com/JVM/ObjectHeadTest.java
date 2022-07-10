package com.JVM;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/4/9 0:37
 */
public class ObjectHeadTest {

    public static void main(String[] args) {
        ClassLayout classLayout = ClassLayout.parseClass(Object.class);
        System.out.println(classLayout.toPrintable());
        System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());

        System.out.println("-------------");
        System.out.println(ClassLayout.parseInstance(new int[]{}).toPrintable());

        System.out.println(ClassLayout.parseInstance(new User()).toPrintable());


    }
}

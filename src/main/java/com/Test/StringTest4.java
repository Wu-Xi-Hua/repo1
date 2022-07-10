package com.Test;

/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/5/14 9:43
 */
public class StringTest4 {

   private String a = new String("a");//返回a堆对象
    private String a2 = a.intern();//返回a堆对象
   private String a1 = "a";//返回a池对象

   private String b = new String("b").toString(); //返回b堆对象，b的池对象创建
    private String b2 = b.intern();//返回池对象
   private String b1 = "b";//返回b池对象



    public static void main(String[] args) {

        StringTest4 stringTest = new StringTest4();
//        System.out.println(stringTest.a == stringTest.a1);
//        System.out.println(stringTest.b == stringTest.b1);
//        System.out.println(stringTest.b == stringTest.b2);
        System.out.println(stringTest.a == stringTest.a2);

    }


}

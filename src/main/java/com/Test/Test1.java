package com.Test;



/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/5/10 16:19
 */
public class Test1 {

    public static void main(String[] args) {

        Test1 test1 = new Test1();

        int a =test1.b2() ? (test1.b1() ? test1.method01() : test1.method02() ) :test1.method03();

        System.out.println(a);


//        System.out.println(Runtime.getRuntime().maxMemory());
//
//        String str = "str";
//        boolean notBlank = StringUtils.isNotBlank(str);
//        System.out.println(notBlank);

    }
    public int method01(){
        System.out.println("1");
        return 1;
    }
    public int method02(){
        System.out.println("2");
        return 2;
    }
    public int method03(){
        System.out.println("3");
        return 3;
    }
    public boolean b1(){
        System.out.println("false");
        return false;
    }
    public boolean b2(){
        System.out.println("true");
        return true;
    }
}

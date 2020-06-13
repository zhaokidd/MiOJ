package src.java_think.jvm;

import java.util.ArrayList;
import java.util.List;

public class TestJvmClassLoader {
    //Special-Case: 当访问final静态字段时,不会引发类加载.
    public static int BEGIN = 1;
    //类加载条件-1:当读取访问到类中的静态字段时.
    public static Object object = new Object();

    int b;

    static int c;
    static {
        int sA=0;
        System.out.println("static code");
    }


    //类加载条件-3:当class中有入口函数执行时.
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class clazz = TestJvmClassLoader.class;
        int local1= 1;
        local1 =2;
        System.out.println("test");
        clazz.newInstance();
    }

    //类记载条件-4:当使用到子类时,会先加载父类.
    static class SubTestJvmClassLoader{

    }

    private static void test(){
    }

    private String testOverLoad(List<String> list){
        return "-1";
    }

    private long testOverLoad(List<Integer> list){
        return 1;
    }

}

package src.java_think;

import java.util.HashMap;

/**
 * 内部类引用外部变量，会导致外部变量的引用泄露,可能会引发线程安全问题，所以外部被引用变量需要声明为final类型.
 *
 * */
public class TestInnerClass {
    class MemberInnerClass{
    }

    //静态内部类
    static class StaticInnerClass{

    }

    //匿名内部类
    class AnynomousInnerClass{

    }

    public static void main(String[] args){
        //成员内部类的创建方式
        TestInnerClass testInnerClass = new TestInnerClass();
        testInnerClass.new MemberInnerClass();

        //静态内部类
        StaticInnerClass staticInnerClass = new StaticInnerClass();

        //匿名内部类
        AnynomousInnerClass anynomousInnerClass = testInnerClass.new AnynomousInnerClass(){

        };

        //局部内部类
        final int temp = 2;
        HashMap hashMap = new HashMap();
        class FieldInnerClass{
            private void test(){
                System.out.println(temp);
                System.out.println(hashMap.size());
            }
        }
        //测试打印局部变量.
        FieldInnerClass fieldInnerClass = new FieldInnerClass();
        fieldInnerClass.test();
    }
}





package java_think;

public class AnonymousClassTest {
    private int outerValue;

    private void testAnonymousClass(int value) {
        new InnerMember() {
            @Override
            void printInnerAbstract(int a) {
                System.out.println(value);
            }
        } .printInner(value);
    }

    private void testInnerClass(int count){
        InnerMember innerMember = new InnerMember(){
            @Override
            void printInnerAbstract(int value) {
                System.out.println(count);
            }
        };

        innerMember.printInner(count);
    }

    public static void main(String[] args) {
        AnonymousClassTest test = new AnonymousClassTest();
        test.testAnonymousClass(1);
        test.testInnerClass(1);
    }

}


/**
 * 内部类
 * 1.内部类不允许有静态成员变量.
 * 2.局部内部类和匿名内部类的区别在于：匿名内部类没有显式被赋值给强引用变量.
 * 3.为什么局部内部类和匿名内部类使用的方法变量需要声明为final?是因为方法变量的生命期与匿名内部类对象很可能不一致，会导致内部类有可能访问到过期的方法变量.
 * 4.解决的办法，声明为final后，编译器会复制方法变量为常量存储在内部类中.
 * 5.java8语法糖，如果声明了匿名内部类并且使用了外部类的变量，那么该变量会自动声明为final
 */
abstract class InnerMember {
    private int innerValue;

    void printInner(int value) {
        System.out.println("print inner"+value);
    }

    abstract void printInnerAbstract(int value);
}




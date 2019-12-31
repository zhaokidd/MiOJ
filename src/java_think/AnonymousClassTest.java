package src.java_think;

public class AnonymousClassTest {
    private int outerValue;
    private InnerTestClass innerTestClass = new InnerTestClass(1);
    private static InnerMember innerMember;

    private AnonymousMainClass anonymousMainClass = new AnonymousMainClass(){
        @Override
        public void test() {
            super.test();
        }
    };

    private void testAnonymousClass(final int value) {
        new InnerMember() {
            @Override
            void printInnerAbstract(int a) {
                System.out.println(value);
            }
        } .printInner(value);
    }

    private void testInnerClass(final int count) {
        innerMember = new InnerMember() {
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

    public class InnerTestClass{
        int flag =1;

        public InnerTestClass(int flag) {
            this.flag = flag;
        }
    }

    /**
     * 内部类
     * 1.匿名内部类就是声明了类方法定义的局部内部类
     *   假如 InnerMember声明为非静态内部类,则会持有外部类引用.AnonymousClassTest$InnerMember.this$0
     *       将InnerMemeber声明为静态内部类,则不会持有外部类引用
     *       如果在方法内部声明匿名内部类,则会持有外部类的引用this$0.不同于AnonymousClassTest$InnerMemher.this$0
     *
     *
     * 2.为什么局部内部类和匿名内部类使用的方法变量需要声明为final?是因为方法变量的生命期与匿名内部类对象很可能不一致，会导致内部类有可能访问到过期的方法变量.
     *   解决的办法，声明为final后，编译器会复制方法变量为常量存储在内部类中.
     *   java8语法糖，如果声明了匿名内部类并且使用了外部类的变量，那么该变量会自动声明为final
     */
    static class InnerMember {
        private int innerValue;

        void printInner(int value) {
            System.out.println("print inner" + value);
        }

        void printInnerAbstract(int value) {
        }

    }

}





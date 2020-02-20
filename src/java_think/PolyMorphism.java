package src.java_think;

/**
 * 多态的原则:　当超类变量引用子类对象时，被引用对象的类型决定调用的方法.但是这个被引用类型必须是覆盖超类方法的.
 *
 * 否则按顺序：
 * 1.this.show(o)
 * 2.super.show(o)
 * 3.this.show(super(o))
 * 4.super.show(super(o))
 *
 *
 * eg:
 *         System.out.println("1--" + a1.show(b));// A-A
 *         System.out.println("2--" + a1.show(c));// A-A
 *         System.out.println("3--" + a1.show(d));// A-D
 *         System.out.println("4--" + a2.show(b));// B-A  this.show(super(o))
 *         System.out.println("5--" + a2.show(c));// B-A  this.show(super(o))
 *         System.out.println("6--" + a2.show(d));// A-D  super.show(o)
 * */
public class PolyMorphism {
    public static class A {
        public String show(D obj) {
            return ("A and D");
        }

        public String show(A obj) {
            return ("A and A");
        }

    }

    public static class B extends A {
        public String show(B obj) {
            return ("B and B");
        }

        public String show(A obj) {
            return ("B and A");
        }
    }

    public static class C extends B {

    }

    public static class D extends B {

    }

    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println("1--" + a1.show(b));
        System.out.println("2--" + a1.show(c));
        System.out.println("3--" + a1.show(d));
        System.out.println("4--" + a2.show(b));
        System.out.println("5--" + a2.show(c));
        System.out.println("6--" + a2.show(d));
        System.out.println("7--" + b.show(b));
        System.out.println("8--" + b.show(c));
        System.out.println("9--" + b.show(d));
    }
}

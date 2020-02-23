package src.java_think;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 测试反射机制
 * */
public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //通过包名路径的方式引入class对象，避免了import class类.
        Class clazz = Class.forName("src.java_think.TestReflection$TestObject");

        //通过class对象获取到构造函数，通过构造函数实例化对象.
        Constructor constructor = clazz.getConstructor();
        TestObject testObject = (TestObject) constructor.newInstance();

        testObject.printHello();
    }

    static class TestObject {
        public TestObject() {
        }

        void printHello() {
            System.out.println("Hello World");
        }
    }
}

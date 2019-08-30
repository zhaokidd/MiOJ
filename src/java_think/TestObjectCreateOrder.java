package java_think;

/***
 * 类加载的初始化顺序：
 * 1.父类静态代码段
 * 2.父类静态对象
 * 3.子类静态代码段
 * 4.子类静态对象
 * 5.父类对象初始值
 * 6.父类构造函数
 * 7.子类对象初始值
 * 8.子类构造函数
 *
 * */
public class TestObjectCreateOrder {
    public static void main(String[] args) {
        SubObject subObject = new SubObject();
    }

    public static final BaseObject baseObject = new SubObject();
}

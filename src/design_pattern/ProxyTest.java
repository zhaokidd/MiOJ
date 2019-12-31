package design_pattern;

import com.sun.beans.WeakCache;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    interface Gamer{
        void play();
    }

    static class Player implements Gamer{

        @Override
        public void play() {
            System.out.println("a Player");
        }

    }

    /**
     * static proxy
     *
     * */
    class ProxyPlayer implements Gamer{

        @Override
        public void play() {
            //invoke player.play()
            Player player = new Player();
            player.play();
        }

    }

    //dynamic proxy
    static class DynamicProxyPlayer implements Gamer{

        @Override
        public void play() {
            System.out.println("A Dynamic Player");
        }
    }

    static class PlayerInvocationHandler<T> implements java.lang.reflect.InvocationHandler{
        private T proxyObj;

        public PlayerInvocationHandler() {
        }

        /**
         * @param obj 被代理类，即委托类
         * */
        public Object bindProxy(T obj) {
            if (obj instanceof Gamer) {
                proxyObj = obj;
                return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
            }

            return null;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("invoke before");

            Object result = method.invoke(proxyObj, args);

            System.out.println("invoke after");

            return null;
        }
    }


    public static void main(String[] args) {
        //1.声明被代理类对象.
        Gamer player = new Gamer() {
            @Override
            public void play() {
                System.out.println("anonymous class play()");
            }
        };

        //2.实例化一个 InvocationHandler，传入被代理类.
        PlayerInvocationHandler handler = new PlayerInvocationHandler();

        //3.绑定委托类并实例化代理类，并返回代理类
        Gamer playerProxy = (Gamer) handler.bindProxy(player);

/*        //3.实例化一个代理类
        Gamer gamerProxy = (Gamer)
                Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),player.getClass().getInterfaces(),handler);*/

        //4.调用代理类的方法.
        playerProxy.play();

    }

    private static void test() {
        WeakCache<String, Player> weakCache = new WeakCache<>();
        weakCache.put("ZY", new Player());
    }

}

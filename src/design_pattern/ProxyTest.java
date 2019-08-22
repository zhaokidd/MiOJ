package design_pattern;

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

    static class PlayerInvocationHandler implements java.lang.reflect.InvocationHandler{
        private Gamer gamer;

        public Gamer getGamer() {
            return gamer;
        }

        public void setGamer(Gamer gamer) {
            this.gamer = gamer;
        }

        public PlayerInvocationHandler(Gamer gamePlayer) {
            setGamer(gamePlayer);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("invoke before");

            Object result = method.invoke(gamer, args);

            System.out.println("invoke after");

            return null;
        }
    }


    public static void main(String[] args) {
        Gamer player = new Player();

        PlayerInvocationHandler handler = new PlayerInvocationHandler(player);

        Gamer gamerProxy = (Gamer)
                Proxy.newProxyInstance(handler.getClass().getClassLoader(),player.getClass().getInterfaces(),handler);

        gamerProxy.play();
    }


}

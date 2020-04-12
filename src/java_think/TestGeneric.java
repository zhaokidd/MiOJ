package src.java_think;

public class TestGeneric {
    public static void main(String[] args) {
        Holder<? super BaseGeneric> holder = new Holder<>(new Generic());
        holder.getItem();
    }

    static class Holder<T extends BaseGeneric>{
        T item;

        public Holder(T item) {
            this.item = item;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }
    }

    static class BaseGeneric{

    }

    static class Generic extends BaseGeneric{

    }

    static class SecondaryGeneric<T extends Generic>{

    }
}

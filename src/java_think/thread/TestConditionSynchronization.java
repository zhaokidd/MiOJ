package src.java_think.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 一个Lock锁可以关联多个Condition对象，每个Condition关联一个阻塞队列.
 * 如果要在lock代码块中加入条件控制，需要Condition来做控制.
 */
class TestConditionSynchronization {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Product[] items = new Product[100];
    int putptr, takeptr, count;

    static int index = 0;

    static class Product {
        public Product(int val) {
            this.val = val;
        }

        int val;
    }

    public void put(Product x) throws InterruptedException {
        lock.lock();
        try {
            //当生产者队列中元素已满，则停止等待(等待队列中元素被消费)
            while (count == items.length)
                notFull.await();
            //生产元素
            items[putptr] = x;
            if (++putptr == items.length) putptr = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Product take() throws InterruptedException {
        lock.lock();
        try {
            //消费者队列等待（队列中元素个数为0，等待新的元素放入.）
            while (count == 0)
                notEmpty.await();
            Product x = items[takeptr];
            //FIFO队列，takptr指针从队列头部到队列尾部，再重新回到队列头部.
            if (++takeptr == items.length) takeptr = 0;
            --count;
            if (count <= 0) {
                Thread.sleep(10000);
                notFull.signal();
            }
            return x;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TestConditionSynchronization test = new TestConditionSynchronization();

        Thread takeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Product product = test.take();
                        System.out.println("product:" + product.val);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        test.put(new Product(index++));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        takeThread.start();
        putThread.start();
    }
}
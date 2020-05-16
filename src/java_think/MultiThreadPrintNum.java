package src.java_think;

/**
 * 多个线程轮流打印数字
 */
public class MultiThreadPrintNum {
    static int index = 0;
    final static Object mLock = new Object();

    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Thread A = new Thread() {
            @Override
            public void run() {
                while (index < list.length) {
                    synchronized (mLock) {
                        if (index % 3 == 0) {
                            printNum(index, list);
                            index++;
                        } else {
                            try {
                                System.out.println("Awake,but not qualified, Thread name:"+Thread.currentThread());
                                mLock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };

        Thread B = new Thread() {
            @Override
            public void run() {
                while (index < list.length) {
                    synchronized (mLock) {
                        if (index % 3 == 1) {
                            printNum(index, list);
                            index++;
                        } else {
                            try {
                                System.out.println("Awake,but not qualified, Thread name:"+Thread.currentThread());
                                mLock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };

        Thread C = new Thread() {
            @Override
            public void run() {
                while (index < list.length) {
                    synchronized (mLock) {
                        if (index % 3 == 2) {
                            printNum(index, list);
                            index++;
                        } else {
                            try {
                                System.out.println("Awake,but not qualified, Thread name:"+Thread.currentThread());
                                mLock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };

        A.start();
        B.start();
        C.start();
    }

    private static void printNum(int index, int[] list) {
        System.out.println("num:" + list[index] + "Thread name:"+Thread.currentThread().getName());
        mLock.notifyAll();
    }
}

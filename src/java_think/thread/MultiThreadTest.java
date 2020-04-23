package src.java_think.thread;

public class MultiThreadTest {
    public static void main(String[] args) throws InterruptedException {
        testWait();
    }

    private static void testWait() throws InterruptedException {
        Object object = new Object();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    try {
                        System.out.println("end synchronized, thread name:" + Thread.currentThread().getName());
                        Thread.sleep(400);
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        object.notifyAll();
                    }
                }
            }
        }).start();

        Thread.sleep(500);


        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(runnable);
            thread.setName("priority" + i);
            thread.start();
            Thread.sleep(300);
        }

    }

    private static void testYield() throws InterruptedException {
        boolean isYield = true;

        System.out.println();

        Thread[] threads = new Thread[500];

        Runnable yieldRunnable = new Runnable() {
            @Override
            public void run() {
                long count = 0;
                while (++count != 0) {
                    if (count % 100 == 0 && isYield) {
//                        System.out.println("yield Thread Number:" + Thread.currentThread().getId() + " current state:"
//                                + Thread.currentThread().getState());
                        Thread.yield();
//                        System.out.println("yield Thread Number:" + Thread.currentThread().getId() + " current state:"
//                                + Thread.currentThread().getState());
                    }
                }
            }
        };

        Runnable workerRunnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Worker Thread " +
                            Thread.currentThread().getId() + " loop times " + i);
                    System.out.println("Runnable Thread Count = "+getRunningThreadCount(threads));
                }
            }
        };

        for (int i = 0; i < 200; i++) {
            threads[i] = new Thread(yieldRunnable);
            threads[i].start();
        }

        Thread.sleep(2000);

        for (int j = 0; j < 8; j++) {
            new Thread(workerRunnable).start();
        }
    }

    private static int getRunningThreadCount(Thread[] threadArray){
        int count = 0;
        for (int i = 0; i < threadArray.length;i++){
            if(threadArray[i]!=null && threadArray[i].getState()== Thread.State.RUNNABLE){
                count++;
            }
        }

        return count;
    }
}

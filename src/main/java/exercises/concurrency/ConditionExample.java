package exercises.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample {

    final Lock lock = new ReentrantLock();

    final Condition threadWaiter = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        ConditionExample conditionExample = new ConditionExample();
        conditionExample.run();
        Thread.sleep(2000);
        conditionExample.signal();
        Thread.sleep(5);

        conditionExample.signal();
    }


    void run() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();

                try {
                    System.out.println("Thread is going to run");
                    try {

                        threadWaiter.await();
                        System.out.println("proceed");
                        System.out.println("actually wait again");
                        Thread.sleep(2000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                    System.out.println("thread running");
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }

    private void signal() {

        lock.lock();
        try {
            System.out.println("signal thread");
            threadWaiter.signal();
        } finally {
            lock.unlock();
        }
    }
}

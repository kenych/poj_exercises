package exercises.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class BlockingQueueExample {

    public static void main(String[] args) {

        BlockingQueue queue = new DelayQueue();

        new Consumer(queue).start();
        new Producer(queue).start();


    }



}

package exercises.concurrency;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {

    BlockingQueue<Job> queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

//        while (true) {

            Job job;
            try {
                job = queue.take();

                System.out.println("que size is: "+queue.size());
                job.execute();
            } catch (InterruptedException e) {
                System.out.println(e);
            }

//        }

    }
}

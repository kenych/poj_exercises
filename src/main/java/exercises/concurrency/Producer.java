package exercises.concurrency;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {

    static int i;

    BlockingQueue<Job> queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        Random r = new Random();

//        while (true) {

//            Job job = new Job("number :" + i++, r.nextInt(2000));
            Job job = new Job("number :" + i++, 10);
            try {
                System.out.println("adding job: " + job + " queue size: " + queue.size());

                if(queue.size()>10){
                    System.out.println("waiting queue is full..");
                    Thread.sleep(3000);

                }

//                if (job.getTimeout() < 1000) {
                queue.put(job);
                Thread.sleep(100);
                System.out.println("contains: "+job+ " "+queue.contains(job));
//                } else {
//                    System.out.println("too long job trying to offer immediately or cancel: " + job);
//                    boolean res = queue.offer(job);
//                    System.out.println("job status: " + res);
//                }

            } catch (InterruptedException e) {
                System.out.println(e);
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(e);

//            }

        }

    }
}

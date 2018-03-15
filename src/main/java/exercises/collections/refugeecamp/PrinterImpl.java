package exercises.collections.refugeecamp;

import java.util.PriorityQueue;
import java.util.Queue;

public class PrinterImpl implements Printer {

    Queue<Job> queue = new PriorityQueue<Job>();

    @Override
    public void accept(Job job) {
        queue.offer(job);
    }

    @Override
    public Job retrieve() {
        return queue.poll();
    }
}

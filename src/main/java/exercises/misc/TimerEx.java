package exercises.misc;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.concurrent.Executors.newSingleThreadScheduledExecutor;

public class TimerEx {

    public static Random random = new Random();


    public static void main(String[] args) {


        final AtomicInteger id = new AtomicInteger();

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        ScheduledExecutorService scheduledExecutorService = newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                final int taksId = id.incrementAndGet();
                System.out.println("scheduled task:" + taksId);
                executorService.submit(new Job(taksId));
            }
        }, 0, 25, TimeUnit.MILLISECONDS);
    }
}


class Job implements Runnable {

    int taskId;

    Job(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(TimerEx.random.nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println("thread: " + Thread.currentThread().getId() + " task: " + taskId);
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 9999);

            try(PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));){
                printWriter.write("hi from task " + taskId);
                printWriter.close();
            }

//        socket.close();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

//        System.out.println(bufferedReader.readLine());

//        bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
package exercises.concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        final PriorityBlockingQueue<PlayerHighScore> blockingQueue = new PriorityBlockingQueue(9);

        final Random random = new Random();

        final CountDownLatch countDownLatch = new CountDownLatch(1);


        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {

                    PlayerHighScore highScore = new PlayerHighScore(random.nextInt(100), random.nextInt(3));
                    blockingQueue.add(highScore);
                    System.out.println("added: " + highScore);

                    if (blockingQueue.size() > 10) {
                        try {
                            highScore = blockingQueue.take();
                            System.out.println("removed: " + highScore);
                        } catch (InterruptedException e) {
                            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                        }
                    }
                    try {
                        sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
                countDownLatch.countDown();
            }
        }.start();


        countDownLatch.await();
        PlayerHighScore[] array = blockingQueue.toArray(new PlayerHighScore[]{});

        Arrays.sort(array);

        for (PlayerHighScore highScore : array) {

            System.out.println(highScore);
        }


    }

}

package exercises.concurrency;

public class Threads {

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        System.out.println("started");
        Thread.sleep(2000);
        System.out.println("stoping");
        thread.interrupt();


    }


}

class MyThread extends Thread{
    @Override
    public void run() {

        for(int i=0; i< 10000000; i++){
            if(currentThread().isInterrupted()){
                System.out.println("interupterd");
                break;
            }
//            try {
//                sleep(1000);
                System.out.println("i="+i);
//            } catch (InterruptedException e) {
//                System.out.println("inter sleep");
//            }

        }


    }
}


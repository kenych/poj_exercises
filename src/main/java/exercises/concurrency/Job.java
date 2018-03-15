package exercises.concurrency;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Job implements Delayed {

    private String s;
    private int timeout;
    private long origin;

    public Job(String s, int timeout) {
        this.s = s;
        this.timeout = timeout;
        this.origin = System.currentTimeMillis()/1000;

    }

    public void execute() throws InterruptedException {
        System.out.println("waited: " + timeout + " and executing: " + s);
//        Thread.sleep(timeout);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (s != null ? !s.equals(job.s) : job.s != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return s != null ? s.hashCode() : 0;
    }

    public int getTimeout() {
        return timeout;
    }

    @Override
    public String toString() {
        return "Job{" +
                "s='" + s + '\'' +
                ", timeout=" + timeout +
                ", origin=" + origin +
                '}';
    }

    @Override
    public long getDelay(TimeUnit unit) {
//        long delay = unit.convert(timeout - (System.currentTimeMillis() - origin), TimeUnit.MILLISECONDS);
        long delay = timeout - (System.currentTimeMillis()/1000 - origin);
        return delay;
    }

    @Override
    public int compareTo(Delayed delayed) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

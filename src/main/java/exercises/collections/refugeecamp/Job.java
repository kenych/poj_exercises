package exercises.collections.refugeecamp;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Job implements Comparable<Job> {

    public static final int PRIORITY_THRESHOLD = 3;

    public Job(int arrivalId) {
        this(arrivalId, PRIORITY_THRESHOLD + arrivalId);
    }

    public Job(int arrivalId, int priority) {
        this.arrivalId = arrivalId;
        this.priority = priority;
    }

    Integer arrivalId;
    Integer priority;

    @Override
    public int compareTo(Job other) {
        return this.priority.compareTo(other.priority);
    }

    @Override
    public String toString() {
        return "Job{" +
                "arrivalId=" + arrivalId +
                ", priority=" + priority +
                '}';
    }
}

package exercises.collections;

import exercises.collections.refugeecamp.Job;
import exercises.collections.refugeecamp.Job;

import java.util.TreeSet;

public class TreeSets {
    public static void main(String[] args) {
        TreeSet<Job> treeSet = new TreeSet<Job>();
        treeSet.add(new Job(2, 10));
        treeSet.add(new Job(1, 10));
        treeSet.add(new Job(3, 10));

        if (treeSet.size() > 2) {
            treeSet.remove(treeSet.last());
        }

        for (Job job : treeSet) {
            System.out.println(job);
        }

    }
}

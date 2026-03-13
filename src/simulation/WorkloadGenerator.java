package simulation;

import model.Job;
import java.util.*;

public class WorkloadGenerator {

    public static List<Job> generateJobs(int count) {

        List<Job> jobs = new ArrayList<>();

        Random rand = new Random();

        for (int i = 1; i <= count; i++) {

            int arrivalTime = rand.nextInt(10);     // 0–9
            int burstTime = rand.nextInt(9) + 1;    // 1–9
            int priority = rand.nextInt(3) + 1;     // 1–3
            int memory = (rand.nextInt(4) + 1) * 256;

            Job job = new Job(
                    "J" + i,
                    arrivalTime,
                    burstTime,
                    priority,
                    memory
            );

            jobs.add(job);
        }

        return jobs;
    }
}
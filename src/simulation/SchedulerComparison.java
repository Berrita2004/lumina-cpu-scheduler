package simulation;

import model.Job;
import scheduler.*;
import metrics.MetricsCalculator;

import java.util.*;

public class SchedulerComparison {

    public static void runComparison(List<Job> jobs) {

        System.out.println("\n===== FCFS =====");

        FCFSScheduler fcfs = new FCFSScheduler();
        for (Job j : cloneJobs(jobs)) fcfs.addJob(j);

        fcfs.run();
        MetricsCalculator.printMetrics(fcfs.getCompletedJobs());


        System.out.println("\n===== SJF =====");

        SJFScheduler sjf = new SJFScheduler();
        for (Job j : cloneJobs(jobs)) sjf.addJob(j);

        sjf.run();
        MetricsCalculator.printMetrics(sjf.getCompletedJobs());


        System.out.println("\n===== Round Robin =====");

        RoundRobinScheduler rr = new RoundRobinScheduler(2);
        for (Job j : cloneJobs(jobs)) rr.addJob(j);

        rr.run();
        MetricsCalculator.printMetrics(rr.getCompletedJobs());
    }


    // this.. so that they copy jobs and so algorithms dont share state
    private static List<Job> cloneJobs(List<Job> jobs) {

        List<Job> copy = new ArrayList<>();

        for (Job j : jobs) {

            copy.add(new Job(
                    j.getId(),
                    j.getArrivalTime(),
                    j.getBurstTime(),
                    j.getPriority(),
                    j.getVramRequired()
            ));
        }

        return copy;
    }
}
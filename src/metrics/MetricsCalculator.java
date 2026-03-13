package metrics;

import model.Job;
import java.util.*;

public class MetricsCalculator {

    public static void printMetrics(List<Job> jobs) {

        int totalWT = 0;
        int totalTAT = 0;
        int totalRT = 0;

        int totalBurstTime = 0;
        int totalSimulationTime = 0;

        System.out.println("\nMetrics:");

        for (Job job : jobs) {

            int turnaroundTime =
                    job.getCompletionTime() - job.getArrivalTime();

            int waitingTime =
                    turnaroundTime - job.getBurstTime();

            int responseTime =
                    job.getStartTime() - job.getArrivalTime();

            totalWT += waitingTime;
            totalTAT += turnaroundTime;
            totalRT += responseTime;

            totalBurstTime += job.getBurstTime();

            if (job.getCompletionTime() > totalSimulationTime) {
                totalSimulationTime = job.getCompletionTime();
            }

            System.out.println(
                    job.getId() +
                    " | TAT=" + turnaroundTime +
                    " | WT=" + waitingTime +
                    " | RT=" + responseTime
            );
        }

        int n = jobs.size();

        double avgWT = (double) totalWT / n;
        double avgTAT = (double) totalTAT / n;
        double avgRT = (double) totalRT / n;

        // CPU Utilization
        double cpuUtilization =
                ((double) totalBurstTime / totalSimulationTime) * 100;

        // Throughput
        double throughput =
                (double) n / totalSimulationTime;

        System.out.println("\nAverage Metrics:");

        System.out.println("Avg WT = " + avgWT);
        System.out.println("Avg TAT = " + avgTAT);
        System.out.println("Avg RT = " + avgRT);

        System.out.println("\nSystem Performance:");

        System.out.println("CPU Utilization = " + cpuUtilization + "%");
        System.out.println("Throughput = " + throughput + " jobs/unit time");
    }
}
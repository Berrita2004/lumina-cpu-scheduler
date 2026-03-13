import model.Job;
import simulation.WorkloadGenerator;
import simulation.SchedulerComparison;
import metrics.MetricsCalculator;
import metrics.GanttChartPrinter;
import scheduler.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Lumina Scheduler Simulator ===");
        System.out.println("1. Run FCFS");
        System.out.println("2. Run SJF");
        System.out.println("3. Run Round Robin");
        System.out.println("4. Run Algorithm Comparison");

        System.out.print("Select option: ");

        int choice = scanner.nextInt();

        List<Job> jobs = WorkloadGenerator.generateJobs(5);

        switch (choice) {

            case 1:
                FCFSScheduler fcfs = new FCFSScheduler();

                for (Job j : jobs) {
                    fcfs.addJob(j);
                }

                fcfs.run();

                GanttChartPrinter.print(fcfs.getGanttChart());

                MetricsCalculator.printMetrics(fcfs.getCompletedJobs());

                break;

            case 2:
                SJFScheduler sjf = new SJFScheduler();

                for (Job j : jobs) {
                    sjf.addJob(j);
                }

                sjf.run();

                GanttChartPrinter.print(sjf.getGanttChart());

                MetricsCalculator.printMetrics(sjf.getCompletedJobs());

                break;

            case 3:
                RoundRobinScheduler rr = new RoundRobinScheduler(2);

                for (Job j : jobs) {
                    rr.addJob(j);
                }

                rr.run();

                GanttChartPrinter.print(rr.getGanttChart());

                MetricsCalculator.printMetrics(rr.getCompletedJobs());

                break;

            case 4:

                SchedulerComparison.runComparison(jobs);

                break;

            default:
                System.out.println("Invalid option.");
        }

        scanner.close();
    }
}
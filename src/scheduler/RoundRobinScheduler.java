package scheduler;

import model.Job;
import model.GanttEntry;

public class RoundRobinScheduler extends Scheduler {

    private int quantum;

    public RoundRobinScheduler(int quantum) {
        this.quantum = quantum;
    }

    @Override
    public void run() {

        while (!readyQueue.isEmpty() || !jobPool.isEmpty()) {

            admitJobs();

            if (readyQueue.isEmpty()) {

                System.out.println(
                        "Time " + currentTime + " CPU Idle"
                );

                currentTime++;
                continue;
            }

            Job currentJob = readyQueue.poll();

            if (currentJob.getStartTime() == -1) {
                currentJob.setStartTime(currentTime);
            }

            int start = currentTime;

            int executionTime =
                    Math.min(quantum, currentJob.getRemainingTime());

            System.out.println(
                    "Time " + currentTime +
                    " Running " + currentJob.getId() +
                    " for " + executionTime
            );

            currentJob.reduceRemainingTime(executionTime);

            currentTime += executionTime;

            int end = currentTime;

            ganttChart.add(new GanttEntry(currentJob.getId(), start, end));

            admitJobs();

            if (currentJob.isCompleted()) {

                finishJob(currentJob);

            } else {

                readyQueue.add(currentJob);
            }
        }

        System.out.println("\nAll jobs finished.");
    }
}
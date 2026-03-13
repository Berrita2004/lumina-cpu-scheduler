package scheduler;

import model.Job;
import model.GanttEntry;

public class SJFScheduler extends Scheduler {

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

            Job shortestJob = null;

            for (Job job : readyQueue) {

                if (shortestJob == null ||
                        job.getRemainingTime() < shortestJob.getRemainingTime()) {

                    shortestJob = job;
                }
            }

            readyQueue.remove(shortestJob);

            if (shortestJob.getStartTime() == -1) {
                shortestJob.setStartTime(currentTime);
            }

            int start = currentTime;

            System.out.println(
                    "Time " + currentTime +
                    " Running " + shortestJob.getId()
            );

            int executionTime = shortestJob.getRemainingTime();

            shortestJob.reduceRemainingTime(executionTime);

            currentTime += executionTime;

            int end = currentTime;

            ganttChart.add(new GanttEntry(shortestJob.getId(), start, end));

            finishJob(shortestJob);
        }

        System.out.println("\nAll jobs finished.");
    }
}
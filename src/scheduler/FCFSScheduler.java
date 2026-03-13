package scheduler;

import model.Job;
import model.GanttEntry;

public class FCFSScheduler extends Scheduler {

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

            Job job = readyQueue.poll();

            if (job.getStartTime() == -1) {
                job.setStartTime(currentTime);
            }

            int start = currentTime;

            System.out.println(
                    "Time " + currentTime +
                    " Running " + job.getId()
            );

            int executionTime = job.getRemainingTime();

            job.reduceRemainingTime(executionTime);

            currentTime += executionTime;

            int end = currentTime;

            ganttChart.add(new GanttEntry(job.getId(), start, end));

            finishJob(job);
        }

        System.out.println("\nAll jobs finished.");
    }
}
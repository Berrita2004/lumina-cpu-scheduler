package scheduler;

import model.Job;
import model.GanttEntry;
import resource.VRAMManager;

import java.util.*;

public abstract class Scheduler {

    protected Queue<Job> readyQueue = new LinkedList<>();
    protected List<Job> jobPool = new ArrayList<>();
    protected List<Job> completedJobs = new ArrayList<>();

    // Gantt chart timeline
    protected List<GanttEntry> ganttChart = new ArrayList<>();

    protected VRAMManager vramManager = new VRAMManager(4096);

    protected int currentTime = 0;

    // Jobs first go to job pool
    public void addJob(Job job) {
        jobPool.add(job);
    }

    // Admit jobs when arrival time reached
    protected void admitJobs() {

        Iterator<Job> iterator = jobPool.iterator();

        while (iterator.hasNext()) {

            Job job = iterator.next();

            if (job.getArrivalTime() <= currentTime) {

                if (vramManager.allocate(job.getVramRequired())) {

                    readyQueue.add(job);

                    System.out.println(
                            "Time " + currentTime +
                            " Job " + job.getId() +
                            " arrived (VRAM allocated)"
                    );

                    iterator.remove();

                } else {

                    System.out.println(
                            "Time " + currentTime +
                            " Job " + job.getId() +
                            " waiting for VRAM"
                    );
                }
            }
        }
    }

    protected void finishJob(Job job) {

        job.setCompletionTime(currentTime);

        vramManager.release(job.getVramRequired());

        completedJobs.add(job);

        System.out.println(
                job.getId() +
                " completed at " + currentTime +
                " (VRAM released)"
        );
    }

    public List<Job> getCompletedJobs() {
        return completedJobs;
    }

    // Return Gantt chart timeline
    public List<GanttEntry> getGanttChart() {
        return ganttChart;
    }

    public abstract void run();
}
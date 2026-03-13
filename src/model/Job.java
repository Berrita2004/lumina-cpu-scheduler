package model;

// Job acts like a simplified PCB (Process Control Block)
// It stores all information needed for scheduling simulation

public class Job {

    // Static job properties (do not change after creation)
    private final String id;
    private final int arrivalTime;
    private final int burstTime;
    private final int priority;
    private final int vramRequired;

    // Dynamic execution state
    private int remainingTime;
    private int startTime = -1;
    private int completionTime = -1;

    public Job(String id, int arrivalTime, int burstTime, int priority, int vramRequired) {

        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        this.vramRequired = vramRequired;

        // Initially remaining time = full burst time
        this.remainingTime = burstTime;
    }

    // Getters (encapsulation — other classes cannot directly modify fields)

    public String getId() {
        return id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getPriority() {
        return priority;
    }

    public int getVramRequired() {
        return vramRequired;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void reduceRemainingTime(int time) {
        this.remainingTime -= time;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {

        // Only set start time once (first CPU access)
        if (this.startTime == -1) {
            this.startTime = startTime;
        }
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }

    public boolean isCompleted() {
        return remainingTime <= 0;
    }
}
package model;

public class GanttEntry {

    private String jobId;
    private int start;
    private int end;

    public GanttEntry(String jobId, int start, int end) {
        this.jobId = jobId;
        this.start = start;
        this.end = end;
    }

    public String getJobId() {
        return jobId;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
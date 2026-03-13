package metrics;

import model.GanttEntry;
import java.util.List;

public class GanttChartPrinter {

    public static void print(List<GanttEntry> chart) {

        if (chart == null || chart.isEmpty()) {
            System.out.println("\nNo Gantt chart data.");
            return;
        }

        System.out.println("\nGantt Chart:\n");

        // Print job blocks
        for (GanttEntry entry : chart) {
            System.out.print("| " + entry.getJobId() + " ");
        }
        System.out.println("|");

        // Print timeline
        for (GanttEntry entry : chart) {
            System.out.print(entry.getStart() + "   ");
        }

        System.out.println(chart.get(chart.size() - 1).getEnd());
    }
}
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;

public class ganttChart extends JFrame {



    public ganttChart(String applicationTitle, String chartTitle) {
        super(applicationTitle);

        // based on the dataset we create the chart
        JFreeChart chart = ChartFactory.createGanttChart(chartTitle, "Task", "Time", createDataset());

        // Adding chart into a chart panel
        ChartPanel chartPanel = new ChartPanel(chart);

        // setting default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));

        // add to contentPane
        setContentPane(chartPanel);

    }

    private IntervalCategoryDataset createDataset() {

        TaskSeriesCollection dataset = new TaskSeriesCollection();
        TaskSeries expected = new TaskSeries("Expected Date");
        ZoneId defaultZoneId = ZoneId.systemDefault();
        int numberOfTasks = 3;
        Instant start = LocalDate.of(2020,2,1).atStartOfDay().toInstant(ZoneOffset.UTC);
        Instant end = LocalDate.of(2020,2,25).atStartOfDay().toInstant(ZoneOffset.UTC);
        String taskName = "Create GUI";
        Date.from(LocalDate.of(2018, 9, 19).atStartOfDay().toInstant(ZoneOffset.UTC));

        for (int i = 0; i < numberOfTasks; i++) {
            expected.add(new Task(taskName,Date.from(start),
                    Date.from(end)));
            dataset.add(expected);
        }

        return dataset;

    }


    public static void main(String[] args) {
        String chartTitle = "ProjectName";
        ganttChart chart = new ganttChart("Gantt Chart",
                chartTitle);
        chart.pack();
        chart.setVisible(true);
    }

}
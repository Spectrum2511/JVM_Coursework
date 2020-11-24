import classes.*;

import classes.Task;

import java.util.ArrayList;

public class critical_path {
    programHandler handler = programHandler.getInstance();

    ArrayList<Task> remaining = new ArrayList<>(handler.getCurrentProject().getProjectTasks());
    ArrayList<Task> tasks = new ArrayList<>(handler.getCurrentProject().getProjectTasks());
    Task sp = tasks.get(0);
    Task ep = tasks.get(tasks.size() - 1);
    String output = "";

    public void calculate_critical_path(){
        Task this_node = sp;
        while (!this_node.equals(ep)){
            int highest_cost = 0;
            Task highest_cost_node = null;
            for (Task node: this_node.getNextTasks()){
                if ( node.getDuration() >= highest_cost){
                    highest_cost = node.getDuration();
                    highest_cost_node = node;
                }
            }
            output = output.concat(this_node.getTaskDesc());
            remaining.remove(this_node);
            this_node = highest_cost_node;
            output = output.concat(", ");
        }
        output = output.concat(this_node.getTaskDesc());
        System.out.println(output);
    }


}

import classes.*;

import java.util.ArrayList;

public class critical_path {
    programHandler handler = programHandler.getInstance();
    ArrayList<Task> tasks =  handler.currentProject.getProjectTasks();
    ArrayList<Task> remaining = handler.currentProject.getProjectTasks();
    Task sp = tasks.get(0);
    Task ep = tasks.get(tasks.size() - 1);
    ArrayList<Task> visited = new ArrayList<>();
    ArrayList<Task> criticalPath = new ArrayList<>();
    Task this_node = sp;

    public void calculate_critical_path(){

        while (!this_node.equals(ep)){
            int highest_cost = 0;
            Task highest_cost_node = null;
            for (Task node: this_node.getNextTasks()){
                if ( node.getDuration() >= highest_cost){
                    highest_cost = node.getDuration();
                    highest_cost_node = node;
                }
            }
            criticalPath.add(this_node);

            remaining.remove(this_node);
            this_node = highest_cost_node;
        }
        String output = "";
        for (Task item : criticalPath){
            output = output.concat(item.getTaskDesc()).concat(", ");
        }
        output = output.concat(this_node.getTaskDesc());
        System.out.println(output);
    }


}

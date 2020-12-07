import classes.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;



public class critical_path_further_improved {
    public static programHandler handler;

    public ArrayList <Task> nodes;
    public ArrayList <Task> priorityQueue = new ArrayList<Task>();
    public critical_path_further_improved(programHandler h){
        handler = h;
        nodes = new ArrayList<>(handler.getCurrentProject().getProjectTasks());

    }

    public String calculate_critical_path(){
        Task maxnode = null;
        Task b[] = calculateWeights();
        int max = 0;
        for (int i = 0; i < nodes.size(); i++){
            int a = nodes.get(i).getCritCost();
            nodes.get(i).setdanum(0);
            if (a > max){
                max = a;
                maxnode = nodes.get(i);
            }
        }
        priorityQueue.add(maxnode);
        nodes.remove(maxnode);
        for (int i = 0; i < nodes.size(); i++){
            priorityQueue.add(nodes.get(i));
        }
        ArrayList<Task> checked = new ArrayList<>();
        ArrayList<Task> unchecked = new ArrayList<>(priorityQueue);
        while(!unchecked.isEmpty()){
            Task CurrentNode = priorityQueue.get(0);
            priorityQueue.remove(CurrentNode);
            for (Task item: CurrentNode.getNextTasks()){

            }
        }


        return "yeet";
    }

























    public static Task[] calculateWeights(){
        //Code is based from that of: https://stackoverflow.com/questions/2985317/critical-path-method-algorithm
        //Adapted to use my classes
        //tasks whose critical cost has been calculated
        ArrayList<Task> completed = new ArrayList<Task>();
        //tasks whose ciritcal cost needs to be calculated
        ArrayList<Task> remaining = new ArrayList<Task>();
        for (int i = handler.getCurrentProject().getProjectTasks().size() -1; i >= 0; i--){
            remaining.add(handler.getCurrentProject().getProjectTasks().get(i));
        }

        //Backflow algorithm
        //while there are tasks whose critical cost isn't calculated.
        while(!remaining.isEmpty()){
            boolean progress = false;

            //find a new task to calculate
            for(Iterator<Task> it = remaining.iterator(); it.hasNext();){
                Task task = it.next();
                if(completed.containsAll(task.getNextTasks())){
                    //all dependencies calculated, critical cost is max dependency
                    //critical cost, plus our cost
                    int critical = 0;
                    for(Task t : task.getNextTasks()){
                        if(t.criticalCost > critical){
                            critical = t.criticalCost;
                        }
                    }
                    task.criticalCost = critical+task.getDuration();
                    System.out.println(task.criticalCost);
                    //set task as calculated an remove
                    completed.add(task);
                    it.remove();
                    //note we are making progress
                    progress = true;
                }
            }
            //If we haven't made any progress then a cycle must exist in
            //the graph and we wont be able to calculate the critical path
            if(!progress) throw new RuntimeException("Cyclic dependency, algorithm stopped!");
        }

        //get the tasks
        Task[] ret = completed.toArray(new Task[0]);
        //create a priority list
        Arrays.sort(ret, (o1, o2) -> {
            //sort by cost
            int i= o2.criticalCost-o1.criticalCost;
            if(i != 0)return i;

            //using dependency as a tie breaker
            //note if a is dependent on b then
            //critical cost a must be >= critical cost of b
            if(o1.isDependant(o2))return -1;
            if(o2.isDependant(o1))return 1;
            return 0;
        });
        return ret;
    }


}

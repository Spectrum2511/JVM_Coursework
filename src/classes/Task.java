package classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Task {
    private String TaskDesc;
    //private classes.Team assignedTo;
    private Project AssignedProj;
    private int Duration;
    private LocalDate startDate;
    private boolean isFirst;
    private boolean isLast;
    private ArrayList<Task> nextTask = new ArrayList<>();
    private ArrayList<Task> prevTask = new ArrayList<>();
    private boolean isCompleted = false;
    private Team assignedTeam;


    public Task(String desc, Project p, int d, String addTo){
        TaskDesc = desc;
        AssignedProj = p;
        Duration = d;
        assignedTeam = AssignedProj.nonAssigned;
        if (!addTo.equals("")){
            String[] nodes = addTo.split(",");
            for (String node : nodes) {
                AssignedProj.getTaskOfDescription(node).getNextTasks().add(this);
                this.getPrevTasks().add(AssignedProj.getTaskOfDescription(node));
            }
        }
    }

    public void checkPosition(){
        ArrayList<Task> otherJobs = AssignedProj.getProjectTasks();
        int thisIndex = otherJobs.indexOf(this);
        if((thisIndex == 0) && (prevTask.isEmpty())) {
            isFirst = true;
            isLast = false;
            startDate = AssignedProj.getStartDate();
        }
        if ((thisIndex + 1 == otherJobs.size() && otherJobs.size() > 1)&&(nextTask.isEmpty())){
            isLast = true;
            isFirst = false;
            LocalDate max = LocalDate.parse("1111-11-11");
            for (int i = 0; i < prevTask.size(); i++){
                LocalDate c = this.getPrevTasks().get(i).startDate.plusDays(this.getPrevTasks().get(i).getDuration());
                if (c.compareTo(max) > 0)
                        max = c;
            }
            startDate = max;
        } else if (otherJobs.size() > 1 && thisIndex !=0 && thisIndex != otherJobs.size()-1){
            LocalDate max = LocalDate.parse("1111-11-11");
            for (int i = 0; i < prevTask.size(); i++){
                LocalDate c = this.getPrevTasks().get(i).startDate.plusDays(this.getPrevTasks().get(i).getDuration());
                if (c.compareTo(max) > 0)
                    max = c;
            }
        }
    }

    public String getTaskDesc(){
        return TaskDesc;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public ArrayList<Task> getNextTasks(){
        return nextTask;
    }

    public Boolean getIsCompleted(){
        return isCompleted;
    }

    public void setTaskComplete(){
        isCompleted = true;
    }

    public ArrayList<Task> getPrevTasks(){
        return prevTask;
    }

    public void setAssignedTeam(Team a){
        assignedTeam = a;
    }
    public Team getAssignedTeam(){ return assignedTeam;}

    public Project getAssignedProj() { return AssignedProj; }

    public int getDuration(){ return Duration; }
}

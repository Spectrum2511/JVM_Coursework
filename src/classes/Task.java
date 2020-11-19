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
    private Task nextTask;
    private int thisIndex;
    private Task prevTask;
    private boolean isCompleted = false;
    private Team assignedTeam;

    public Task(String desc, Project p, int d){
        TaskDesc = desc;
        AssignedProj = p;
        Duration = d;
        assignedTeam = AssignedProj.nonAssigned;
    }

    public void checkPosition(){
        ArrayList<Task> otherJobs = AssignedProj.getProjectTasks();
        thisIndex = otherJobs.indexOf(this);
        if(thisIndex == 0) {
            isFirst = true;
            isLast = false;
            startDate = AssignedProj.getStartDate();
            prevTask = null;
            if (otherJobs.size() > 1){
                nextTask = otherJobs.get(thisIndex + 1);
            } else{
                nextTask = null;
            }
        }
        if (thisIndex + 1 == otherJobs.size() && otherJobs.size() > 1){
            isLast = true;
            isFirst = false;
            prevTask = otherJobs.get(thisIndex - 1);
            startDate = prevTask.startDate.plusDays(prevTask.Duration);
            nextTask = null;
        } else if (otherJobs.size() > 1 && thisIndex !=0 && thisIndex != otherJobs.size()-1){
            prevTask = otherJobs.get(thisIndex - 1);
            nextTask = otherJobs.get(thisIndex + 1);
            startDate = prevTask.startDate.plusDays(prevTask.Duration);
        }
    }

    public Task getNextTask(){
        if (isLast){
            System.out.println("last task");
        }
        return nextTask;
    }

    public Task getPrevTask(){
        if (isFirst){
            System.out.println("first task");
        }
        return prevTask;
    }

    public Boolean getIsCompleted(){
        return isCompleted;
    }

    public void setTaskComplete(){
        isCompleted = true;
    }

    public String getTaskDesc(){ return TaskDesc; }

    public LocalDate getStartDate(){
        return startDate;
    }

    public void setAssignedTeam(Team a){
        assignedTeam = a;
    }

    public Team getAssignedTeam(){ return assignedTeam;}

    public Project getAssignedProj() { return AssignedProj; }

    public int getDuration(){ return Duration; }
}

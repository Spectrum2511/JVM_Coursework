package classes;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDate;

public class Project implements Serializable {
    private String projName;//Name of the project
    private String projNote;//Brief description of the project

    private ArrayList<Task> ProjectTasks = new ArrayList<>();
    private ArrayList<Team> ProjectTeams = new ArrayList<>();
    private LocalDate StartDate;
    private int ProjDuration;
    private Task CurrentTask;
    public Team nonAssigned = new Team("N/A");

    //constructor
    public Project(String name, String note, String startdate, int dur){
        projName = name;
        projNote = note;
        StartDate = LocalDate.parse(startdate);
        ProjDuration = dur;
    }

    public void addTask(String desc, int d){
        Task tmp = new Task(desc, Project.this, d);
        this.ProjectTasks.add(tmp);
        tmp.checkPosition();
        for (int i =0; i < this.ProjectTasks.size()-1; i++){
            Task t = ProjectTasks.get(i);
            t.checkPosition();
        }
    }

    public void createTeam(String name, String desc, int n){
        Team tmp = new Team(name, desc, n);
        this.ProjectTeams.add(tmp);
    }

    public void findCurrentTask(Project this){
        for(int i = 0; i < this.ProjectTasks.size(); i++){
            Boolean check = this.ProjectTasks.get(i).getIsCompleted();
            if (check == false){
                this.CurrentTask = this.ProjectTasks.get(i);
                break;
            }
        }
    }

    public void AssignTeamToTask(String team, String task){
        Team te = getTeamOfName(team);
        Task tk = getTaskOfDescription(task);
        if (te == null || tk == null){
            System.out.println("ERROR: task or team does not exist");
        }else {
            tk.setAssignedTeam(te);
            te.assignTask(tk);
        }
    }

    public Team getTeamOfName(String name){
        Team a = null;
        for (int i =0; i < this.ProjectTeams.size(); i++){
            if (this.ProjectTeams.get(i).getTeamName().equals(name)){
                a = this.ProjectTeams.get(i);
                break;
            }
        }
        return a;
    }

    public Task getTaskOfDescription(String description){
        Task a = null;
        for (int i =0; i < ProjectTasks.size(); i++){
            if (ProjectTasks.get(i).getTaskDesc() == description){
                a = ProjectTasks.get(i);
                break;
            }
        }
        return a;
    }

    public void displayTaskData(){
        for (int i =0; i < ProjectTasks.size(); i++){
            Task tmp = ProjectTasks.get(i);
            System.out.println("Description: " + tmp +", "+ tmp.getTaskDesc()+ ", Assigned to: " + tmp.getAssignedTeam().getTeamName() + ", Start Date: " + tmp.getStartDate());
        }
    }

    public void setProjName(String a){//sets the project name
        if (a.length() > 20){
            System.out.print("Error: project name exceeds length");
        } else{
            projName = a;
        }
    }

    public ArrayList<Task> getProjectTasks(){
        return ProjectTasks;
    }

    public String getProjName(){
        return projName;
    }//returns project name

    public String getProjNote(){
        return projNote;
    }

    public int getProjDuration(){
        return ProjDuration;
    }

    public LocalDate getStartDate(){
        return StartDate;
    }

    public Task getCurrentTask() { return CurrentTask; }

    public ArrayList<Team> getProjectTeams() { return ProjectTeams; }
}



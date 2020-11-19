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
        LocalDate expdEndDate = getStartDate().plusDays(ProjDuration);
        ProjDuration = dur;
    }

    public void addTask(String desc, int d, String addTo){
        Task tmp = new Task(desc, this, d, addTo);
        this.ProjectTasks.add(tmp);
        tmp.checkPosition();
        for (int i =0; i < this.ProjectTasks.size()-1; i++){
            Task t = ProjectTasks.get(i);
            t.checkPosition();
        }
    }

    public void findCurrentTask(Project this){
        for (Task projectTask : this.ProjectTasks) {
            Boolean check = projectTask.getIsCompleted();
            if (!check) {
                this.CurrentTask = projectTask;
                break;
            }
        }
    }

    public void createTeam(String name, String desc, int n){
        Team tmp = new Team(name, desc, n);
        this.ProjectTeams.add(tmp);
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
        for (Team projectTeam : ProjectTeams) {
            if (projectTeam.getTeamName().equals(name)) {
                a = projectTeam;
                break;
            }
        }
        return a;
    }

    public Task getTaskOfDescription(String description){
        Task a = null;
        for (Task projectTask : ProjectTasks) {
            if (projectTask.getTaskDesc().equals(description)) {
                a = projectTask;
                break;
            }
        }
        return a;
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

    public void setProjName(@NotNull String a){//sets the project name
        if (a.length() > 20){
            System.out.print("Error: project name exceeds length");
        } else{
            projName = a;
        }
    }

    public LocalDate getStartDate(){
        return StartDate;
    }


    public Task getCurrentTask() {
        return CurrentTask;
    }
}



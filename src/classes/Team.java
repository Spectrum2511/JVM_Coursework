package classes;

import java.util.ArrayList;

public class Team {
    private String TeamName;
    private String TeamDescription;
    private ArrayList<Task> teamTasks = new ArrayList<>();
    private int IDnumb;

    public Team(String name, String desc, int n){
        if (name.length() > 20){
            System.out.print("ERROR: classes.Team name too long");
        } else{
            TeamName = name;
        }
        TeamDescription = desc;
        IDnumb = n;
    }
    public String getTeamName(){
        return TeamName;
    }

    public void assignTask(Task tk){
        teamTasks.add(tk);
    }

    

}

package classes;

import java.util.ArrayList;

public class Team {
    private String TeamName;
    private String TeamDescription;
    private ArrayList<Task> teamTasks;
    private int IDnumb;

    public Team(String name, String desc, int n){
        if (name.length() > 20){
            System.out.print("ERROR: classes.Team name too long");
        } else{
            TeamName = name;
        }
        TeamDescription = desc;
        IDnumb = n;
        teamTasks = new ArrayList<>();
    }

    public Team(String name){
        if (name.equals("N/A") || (name.isEmpty())){
            TeamName = "N/A";
        }
    }

    public String getTeamName(){
        if(TeamName.equals("N/A")){
            return "null";
        } else{
            return TeamName;
        }
    }

    public void assignTask(Task tk){
        teamTasks.add(tk);
    }

    public String getTeamDescription() { return TeamDescription; }

    public int getID() { return IDnumb; }

    

}

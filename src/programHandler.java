import classes.Project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class programHandler {

    private static programHandler instance = new programHandler();
    public static ArrayList<Project> projects;
    public Project currentProject;
    private static final String filepath="C:\\Users\\Sean Daly\\Google Drive\\Uni Stuff\\Year 3\\Term 1\\COMP1815- JVM Programming Languages\\Coursework\\src\\classes";

    private programHandler() {
        projects = new ArrayList<>();
        currentProject = null;
    }

    public static void main(String args[]) throws IOException {
        programHandler handler = getInstance();

        handler.CreateProject("proj1", "aaaaaaaaaaaaa", "2020-11-12", 100);
        handler.CreateProject("proj2", "bbbbbbbbbbbbb", "2020-12-14", 50);
        handler.getProjOfName("proj1").addTask("Create Gui", 20);
        handler.getProjOfName("proj1").addTask("Test GUI", 20);
        handler.getProjOfName("proj1").createTeam("team a", "aaaaaaaaaaa", 1);
        handler.getProjOfName("proj1").AssignTeamToTask("team a", "Test GUI");
        handler.getProjOfName("proj1").AssignTeamToTask("team a", "Create Gui");
        handler.getProjOfName("proj2").addTask("Decode project", 01);

        handler.getProjOfName("proj1").displayTaskData();
        saveInstances();
    }

    public static programHandler getInstance( ) {
        return instance;
    }

    
    public void CreateProject(String name, String note, String startdate, int dur){
        Project tmp = new Project(name, note, startdate, dur);
        projects.add(tmp);
        currentProject = tmp;
    }

    public Project getProjOfName(String name){
        Project a = null;
        for (int i =0; i < projects.size(); i++){
            if (projects.get(i).getProjName() == name){
                a = projects.get(i);
                break;
            }
        }
        return a;
    }

    public static void saveInstances() throws IOException {
        FileWriter csvWriter = new FileWriter("Projects.csv");
        for (int i = 0; i < instance.projects.size(); i++){
            Project j = instance.projects.get(i);
            String Proj_data[] = {"p", j.getProjName(), j.getProjNote(), j.getStartDate().toString(), String.valueOf(j.getProjDuration())};
            for (int c = 0; c < Proj_data.length; c++){
                csvWriter.append(Proj_data[c] + ", ");
            }
            csvWriter.append("\n");
        }







        csvWriter.flush();
        csvWriter.close();
    }




/*
JFrame frame = new JFrame("JVM");
        frame.setContentPane(new JVM().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
 */

}

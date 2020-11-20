import classes.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class programHandler {

    private static final programHandler instance = new programHandler();
    public static ArrayList<Project> projects;
    public Project currentProject;
    private static final String filepath="C:\\Users\\Sean Daly\\Google Drive\\Uni Stuff\\Year 3" +
            "\\Term 1\\COMP1815- JVM Programming Languages\\Coursework\\src\\classes";

    private programHandler() {
        projects = new ArrayList<>();
        currentProject = null;
    }

    public static void main(String args[]) throws IOException {
        //programHandler handler = getInstance();

        //Project proj1 = new Project("Project JVM", "The JVM Coursework", "2021-11-05",100);
    /*   instance.CreateProject("Project JVM", "The JVM Coursework", "2021-11-05",100);
        instance.currentProject.createTeam("Team A","a a a a a a",1);
        instance.currentProject.createTeam("Team B","b b b b b b b", 2);
        instance.currentProject.addTask("A",30, "");
        instance.currentProject.addTask("B", 60, "A");
        instance.currentProject.addTask("C", 30, "A");
        instance.currentProject.addTask("D",20,"A");
        instance.currentProject.addTask("E", 365,"D,B,C");
        instance.currentProject.addTask("F",0,"E");
        instance.currentProject.AssignTeamToTask("Team A","A");
        instance.currentProject.AssignTeamToTask("Team A","B");
        instance.currentProject.AssignTeamToTask("Team A","C");
        instance.currentProject.AssignTeamToTask("Team B","D");
    */
        //System.out.println("==================END TEST==================");

        loadInstances();
        //saveInstances();
        System.out.println("=========END TEST==========");
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
        for (Project project : projects) {
            if (project.getProjName().equals(name)) {
                a = project;
                break;
            }
        }
        return a;
    }

    public static void saveInstances() throws IOException {
        FileWriter csvWriter = new FileWriter("Projects.csv");
        for (Project j : projects) {
            String[] Proj_data = {"p", j.getProjName(), j.getProjNote(), j.getStartDate().toString(),
                    String.valueOf(j.getProjDuration())};
            for (int c = 0; c < Proj_data.length - 1; c++) {
                csvWriter.append(Proj_data[c]).append("%");
            }
            csvWriter.append(Proj_data[Proj_data.length - 1]);
            csvWriter.append("\n");

            for (int h = 0; h < j.getProjectTeams().size(); h++) {
                Team t = j.getProjectTeams().get(h);
                String[] team_data = {"g", t.getTeamName(), t.getTeamDescription(), String.valueOf(t.getID())};
                for (int c = 0; c < team_data.length - 1; c++) {
                    csvWriter.append(team_data[c]).append("%");
                }
                csvWriter.append(team_data[team_data.length - 1]);
                csvWriter.append("\n");
            }
            for (int h = 0; h < j.getProjectTasks().size(); h++) {
                Task t = j.getProjectTasks().get(h);
                String[] task_data = {"t", t.getTaskDesc(), t.getAssignedProj().getProjName(),
                        String.valueOf(t.getDuration()), t.getAssignedTeam().getTeamName(), t.getPredecessors()};
                for (int c = 0; c < task_data.length - 1; c++) {
                    csvWriter.append(task_data[c]).append("%");
                }
                csvWriter.append(task_data[task_data.length - 1]);
                csvWriter.append("\n");
            }
        }
        csvWriter.flush();
        csvWriter.close();
    }

    public static void loadInstances() throws IOException {
        File csvFile = new File("Projects.csv");
        if (csvFile.isFile()) {
            BufferedReader csvReader = new BufferedReader(new FileReader("Projects.csv"));
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split("%");
                if (data[0].equals("p")){
                    instance.CreateProject(data[1],data[2],data[3],Integer.parseInt(data[4]));
                }
                if (data[0].equals("g")){
                    instance.currentProject.createTeam(data[1], data[2], Integer.parseInt(data[3]));
                }
                if(data[0].equals("t")){
                    instance.currentProject.addTask(data[1],Integer.parseInt(data[3]),data[5]);
                    if (!data[4].equals("null")){
                        instance.currentProject.AssignTeamToTask(data[4],data[1]);
                    }
                }

            }
            csvReader.close();





        }


    }




/*
JFrame frame = new JFrame("JVM");
        frame.setContentPane(new JVM().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
 */

}

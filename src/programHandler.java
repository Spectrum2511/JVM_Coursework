import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import classes.*;

public class programHandler {

    public static programHandler instance = new programHandler();
    private static ArrayList<Project> projects;
    private static Project currentProject;
    private static final String filepath="C:\\Users\\Sean Daly\\Google Drive\\Uni Stuff\\Year 3" +
            "\\Term 1\\COMP1815- JVM Programming Languages\\Coursework\\src\\classes";



    public static void main(String args[]) throws IOException {
        projects = new ArrayList<>();
        loadInstances();

        //instance.CreateProject("project 1", "testing project", "2020-11-25", 80);
        //currentProject.createTeam("Team A", "a a a a a a a", 1);
        //currentProject.createTeam("Team B", " b b b b b b", 2);
        //currentProject.addTask("A", 20, "null");
        //currentProject.AssignTeamToTask("Team A", "A");
        //currentProject.getTaskOfDescription("A").setTaskComplete();
        //currentProject.addTask("B", 30, "A");
        //currentProject.AssignTeamToTask("Team A", "B");
        //currentProject.getTaskOfDescription("B").setTaskComplete();
        //currentProject.addTask("C", 50, "A");
        //currentProject.AssignTeamToTask("Team A", "C");
        //currentProject.getTaskOfDescription("C").setTaskComplete();
        //currentProject.addTask("D", 10, "B");
        //currentProject.AssignTeamToTask("Team B", "D");
        //currentProject.addTask("E", 100, "B,C");
        //currentProject.AssignTeamToTask("Team B", "E");
        //currentProject.addTask("F", 15, "D,E");
        //currentProject.addTask("G", 20, "C");
        //currentProject.addTask("H", 0, "F,G");
        //System.out.println(instance.currentProject.getCurrentTask().getTaskDesc());
        //critical_path path = new critical_path();
        //path.calculate_critical_path();
//
        //instance.CreateProject("project 2", "testing project the second", "2020-11-25", 80);
        //currentProject.createTeam("Team C", "c c c c c c", 1);
        //currentProject.createTeam("Team D", " d d d d d d", 2);
        //currentProject.addTask("A", 20, "null");
        //currentProject.AssignTeamToTask("Team C", "A");
        //currentProject.getTaskOfDescription("A").setTaskComplete();
        //currentProject.addTask("B", 30, "A");
        //currentProject.AssignTeamToTask("Team C", "B");
        //currentProject.getTaskOfDescription("B").setTaskComplete();
        //currentProject.addTask("C", 50, "A");
        //currentProject.AssignTeamToTask("Team C", "C");
        //currentProject.getTaskOfDescription("C").setTaskComplete();
        //currentProject.addTask("D", 10, "B");
        //currentProject.AssignTeamToTask("Team D", "D");
        //currentProject.addTask("E", 100, "B,C");
        //currentProject.AssignTeamToTask("Team D", "E");
        //currentProject.addTask("H", 0, "D,E,C");
        //System.out.println(instance.currentProject.getCurrentTask().getTaskDesc());
        //critical_path crit = new critical_path();
        //crit.calculate_critical_path();
//
        //saveInstances();
        System.out.println("=========END TEST==========");
    }

    public static programHandler getInstance( ) {
        return instance;
    }

    public void CreateProject(String name, String note, String startdate, int dur){
        if (startdate.compareTo(String.valueOf(LocalDate.now())) < 0){
            System.out.println("ERROR: starting date is earlier than current date!");
        } else{
            Project tmp = new Project(name, note, startdate, dur);
            projects.add(tmp);
            currentProject = tmp;
        }
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

    public Project getCurrentProject(){
        return currentProject;
    }

    public static void saveInstances() throws IOException {
        FileWriter csvWriter = new FileWriter("Projects.csv");
        for (Project j : projects) {
            ArrayList<String> Proj_data = new ArrayList<>(Arrays.asList("p", j.getProjName(), j.getProjNote(), j.getStartDate().toString(),
                    String.valueOf(j.getProjDuration())));
            Proj_data.forEach((c)->{
                try {
                    csvWriter.append(c).append("%");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            csvWriter.append(Proj_data.get(Proj_data.size() - 1));
            csvWriter.append("\n");
            for (int h = 0; h < j.getProjectTeams().size(); h++) {
                Team t = j.getProjectTeams().get(h);
                ArrayList<String> team_data = new ArrayList<> (Arrays.asList("g", t.getTeamName(), t.getTeamDescription(), String.valueOf(t.getID())));
                team_data.forEach((c)->{
                    try {
                        csvWriter.append(c).append("%");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                csvWriter.append(team_data.get(team_data.size()- 1));
                csvWriter.append("\n");
            }
            for (int h = 0; h < j.getProjectTasks().size(); h++) {
                Task t = j.getProjectTasks().get(h);
                ArrayList<String> task_data = new ArrayList<>(Arrays.asList("t", t.getTaskDesc(), t.getAssignedProj().getProjName(),
                        String.valueOf(t.getDuration()), t.getAssignedTeam().getTeamName(), t.getPredecessors()));
                task_data.forEach((c)->{
                    try {
                        csvWriter.append(c).append("%");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                csvWriter.append(task_data.get(task_data.size() - 1));
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

}

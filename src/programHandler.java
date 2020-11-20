import java.io.*;
import java.util.ArrayList;
import classes.*;

public class programHandler {

    public static programHandler instance = new programHandler();
    public static ArrayList<Project> projects;
    public Project currentProject;
    private static final String filepath="C:\\Users\\Sean Daly\\Google Drive\\Uni Stuff\\Year 3" +
            "\\Term 1\\COMP1815- JVM Programming Languages\\Coursework\\src\\classes";



    public static void main(String args[]) throws IOException {
        projects = new ArrayList<>();
        loadInstances();
        JVM interfase = new JVM();
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

    public void saveInstances() throws IOException {
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

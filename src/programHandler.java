import classes.*;
import GUI_elements.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class programHandler {

    private static programHandler instance = new programHandler();
    public static ArrayList<Project> projects;
    public Project currentProject;
    private static final String filepath="C:\\Users\\Sean Daly\\Google Drive\\Uni Stuff\\Year 3" +
            "\\Term 1\\COMP1815- JVM Programming Languages\\Coursework\\src\\classes";

    private programHandler() {
        projects = new ArrayList<>();
        currentProject = null;
    }

    public static void main(String args[]) throws IOException {
        JVM gui = new JVM();
        /*        programHandler handler = getInstance();

        handler.CreateProject("proj1", "aaaaaaaaaaaaa", "2020-11-12", 100);
        handler.CreateProject("proj2", "bbbbbbbbbbbbb", "2020-12-14", 50);
        handler.getProjOfName("proj1").addTask("Create Gui", 20);
        handler.getProjOfName("proj1").addTask("Test GUI", 20);
        handler.getProjOfName("proj1").createTeam("team a", "aaaaaaaaaaa", 1);
        handler.getProjOfName("proj1").AssignTeamToTask("team a", "Test GUI");
        handler.getProjOfName("proj1").AssignTeamToTask("team a", "Create Gui");
        handler.getProjOfName("proj2").addTask("Decode project", 01);
        handler.getProjOfName("proj2").addTask("finalise proj", 20);
        handler.CreateProject("proj3", "cccccccccccccccc","2020-12-25",365);
        handler.getProjOfName("proj1").displayTaskData();
*/
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
            String Proj_data[] = {"p", j.getProjName(), j.getProjNote(), j.getStartDate().toString(),
                    String.valueOf(j.getProjDuration())};
            for (int c = 0; c < Proj_data.length -1; c++){
                csvWriter.append(Proj_data[c] + ",");
            }
            csvWriter.append(Proj_data[Proj_data.length -1]);
            csvWriter.append("\n");
            for (int h = 0; h < j.getProjectTeams().size(); h++){
                Team g = j.getProjectTeams().get(h);
                String team_data[] = {"g",g.getTeamName(),g.getTeamDescription(),String.valueOf(g.getIDnumb())};
                for (int c = 0; c < team_data.length -1; c++){
                    csvWriter.append(team_data[c] + ",");
                }
                csvWriter.append(team_data[team_data.length -1]);
                csvWriter.append("\n");
            }
            for (int h = 0; h < j.getProjectTasks().size(); h++){
                Task t = j.getProjectTasks().get(h);
                String task_data[] = {"t", t.getTaskDesc(), t.getAssignedProj().getProjName(),
                        String.valueOf(t.getDuration()), t.getAssignedTeam().getTeamName()};
                for (int c = 0; c < task_data.length -1; c++){
                    csvWriter.append(task_data[c] + ",");
                }
                csvWriter.append(task_data[task_data.length -1]);
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
            String row = "";
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                if (data[0].equals("p")){
                    instance.CreateProject(data[1],data[2],data[3],Integer.parseInt(data[4]));
                }
                if (data[0].equals("g")){
                    instance.currentProject.createTeam(data[1],data[2],Integer.parseInt(data[3]));
                }
                if(data[0].equals("t")){
                    instance.currentProject.addTask(data[1],Integer.parseInt(data[3]));
                    if (data[4]!= "N/A" || data[4] != null){
                        instance.currentProject.AssignTeamToTask(data[4],data[1]);
                    }
                }
            }
            csvReader.close();
        } else{

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

import GUI_elements.*;
import classes.Project;
import classes.Team;
import classes.Task;
import javax.swing.JFrame;

public class TestingClass {

    public static void main(String[] args){

        Project proj1 = new Project("Project JVM", "The JVM Coursework", "2021-11-05",100);
        proj1.addTask("A",30, "");
        proj1.addTask("B", 60, "A");
        proj1.addTask("C", 30, "A");
        proj1.addTask("D",20,"A");
        proj1.addTask("E", 365,"D,B,C");
        proj1.addTask("F",0,"E");
        System.out.println("==================END TEST==================");
    }
}

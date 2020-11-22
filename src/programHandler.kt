import classes.Project
import java.io.*
import java.time.LocalDate
import java.util.*
import java.util.function.Consumer

class programHandler {
    fun CreateProject(name: String?, note: String?, startdate: String, dur: Int) {
        if (startdate.compareTo(LocalDate.now().toString()) < 0) {
            println("ERROR: starting date is earlier than current date!")
        } else {
            val tmp = Project(name!!, note!!, startdate, dur)
            projects!!.add(tmp)
            Companion.currentProject = tmp
        }
    }

    fun getProjOfName(name: String): Project? {
        var a: Project? = null
        for (project in projects!!) {
            if (project.getProjName() == name) {
                a = project
                break
            }
        }
        return a
    }

    val currentProject: Project?
        get() = Companion.currentProject

    companion object {
        var instance = programHandler()
        private var projects: ArrayList<Project>? = null
        private var currentProject: Project? = null
        private const val filepath = "C:\\Users\\Sean Daly\\Google Drive\\Uni Stuff\\Year 3" +
                "\\Term 1\\COMP1815- JVM Programming Languages\\Coursework\\src\\classes"

        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            projects = ArrayList()
            //loadInstances();
            instance.CreateProject("project 1", "testing project", "2020-11-25", 80)
            currentProject!!.createTeam("Team A", "a a a a a a a", 1)
            currentProject!!.createTeam("Team B", " b b b b b b", 2)
            currentProject!!.addTask("A", 20, "null")
            currentProject!!.AssignTeamToTask("Team A", "A")
            currentProject!!.getTaskOfDescription("A")!!.setTaskComplete()
            currentProject!!.addTask("B", 30, "A")
            currentProject!!.AssignTeamToTask("Team A", "B")
            currentProject!!.getTaskOfDescription("B")!!.setTaskComplete()
            currentProject!!.addTask("C", 50, "A")
            currentProject!!.AssignTeamToTask("Team A", "C")
            currentProject!!.getTaskOfDescription("C")!!.setTaskComplete()
            currentProject!!.addTask("D", 10, "B")
            currentProject!!.AssignTeamToTask("Team B", "D")
            currentProject!!.addTask("E", 100, "B,C")
            currentProject!!.AssignTeamToTask("Team B", "E")
            currentProject!!.addTask("F", 15, "D,E")
            currentProject!!.addTask("G", 20, "C")
            currentProject!!.addTask("H", 0, "F,G")
            println(currentProject!!.currentTask!!.taskDesc)
            val path = critical_path()
            println(path.calculate_critical_path())
            instance.CreateProject("project 2", "testing project the second", "2020-11-25", 80)
            currentProject!!.createTeam("Team C", "c c c c c c", 1)
            currentProject!!.createTeam("Team D", " d d d d d d", 2)
            currentProject!!.addTask("A", 20, "null")
            currentProject!!.AssignTeamToTask("Team C", "A")
            currentProject!!.getTaskOfDescription("A")!!.setTaskComplete()
            currentProject!!.addTask("B", 30, "A")
            currentProject!!.AssignTeamToTask("Team C", "B")
            currentProject!!.getTaskOfDescription("B")!!.setTaskComplete()
            currentProject!!.addTask("C", 50, "A")
            currentProject!!.AssignTeamToTask("Team C", "C")
            currentProject!!.getTaskOfDescription("C")!!.setTaskComplete()
            currentProject!!.addTask("D", 10, "B")
            currentProject!!.AssignTeamToTask("Team D", "D")
            currentProject!!.addTask("E", 100, "B,C")
            currentProject!!.AssignTeamToTask("Team D", "E")
            currentProject!!.addTask("H", 0, "D,E,C")
            println(currentProject!!.currentTask!!.taskDesc)
            val crit = critical_path()
            println(crit.calculate_critical_path())
            saveInstances()
            println("=========END TEST==========")
        }

        @Throws(IOException::class)
        fun saveInstances() {
            val csvWriter = FileWriter("Projects.csv")
            for (j in projects!!) {
                val Proj_data = ArrayList(
                    Arrays.asList(
                        "p",
                        j.getProjName(),
                        j.projNote,
                        j.startDate.toString(),
                        j.projDuration.toString()
                    )
                )
                Proj_data.forEach(Consumer { c: String? ->
                    try {
                        csvWriter.append(c).append("%")
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                })
                csvWriter.append(Proj_data[Proj_data.size - 1])
                csvWriter.append("\n")
                for (h in j.projectTeams.indices) {
                    val t = j.projectTeams[h]
                    val team_data = ArrayList(
                        Arrays.asList(
                            "g",
                            t.getTeamName(),
                            t.teamDescription,
                            java.lang.String.valueOf(t.iD)
                        )
                    )
                    team_data.forEach(Consumer { c: String? ->
                        try {
                            csvWriter.append(c).append("%")
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    })
                    csvWriter.append(team_data[team_data.size - 1])
                    csvWriter.append("\n")
                }
                for (h in j.projectTasks.indices) {
                    val t = j.projectTasks[h]
                    val task_data = ArrayList(
                        Arrays.asList(
                            "t",
                            t.taskDesc,
                            t.assignedProj.getProjName(),
                            t.duration.toString(),
                            t.assignedTeam.getTeamName(),
                            t.predecessors
                        )
                    )
                    task_data.forEach(Consumer { c: String? ->
                        try {
                            csvWriter.append(c).append("%")
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    })
                    csvWriter.append(task_data[task_data.size - 1])
                    csvWriter.append("\n")
                }
            }
            csvWriter.flush()
            csvWriter.close()
        }

        @Throws(IOException::class)
        fun loadInstances() {
            val csvFile = File("Projects.csv")
            if (csvFile.isFile) {
                val csvReader = BufferedReader(FileReader("Projects.csv"))
                var row: String
                while (csvReader.readLine().also { row = it } != null) {
                    val data = row.split("%".toRegex()).toTypedArray()
                    if (data[0] == "p") {
                        instance.CreateProject(data[1], data[2], data[3], data[4].toInt())
                    }
                    if (data[0] == "g") {
                        currentProject!!.createTeam(data[1], data[2], data[3].toInt())
                    }
                    if (data[0] == "t") {
                        currentProject!!.addTask(data[1], data[3].toInt(), data[5])
                        if (data[4] != "null") {
                            currentProject!!.AssignTeamToTask(data[4], data[1])
                        }
                    }
                }
                csvReader.close()
            }
        }
    }
}
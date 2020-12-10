//Class Task written in Krotlin
package classes

import java.time.LocalDate
import java.util.*

class Task(
    val taskDesc: String,
    val assignedProj: Project, val duration: Int, val predecessors: String //note that predecessors is the input for the
    // tasks this task leads on from
) {

    var taskStartDate: LocalDate? = null //task start date
        private set
    var taskEndDate: LocalDate? = null //task end date
        private set
    private var isFirst = false //flags marking if task is first or last
    private var isLast = false
    val nextTasks = ArrayList<Task>() //pointers to next tasks
    val prevTasks = ArrayList<Task?>() //pointers to previous tasks
    var isCompleted = false
        private set
    var assignedTeam: Team //team that task is assigned to
    @JvmField
    var criticalCost = 0
    var danum = 0;

    //checkPosition is used to calculate the start date and end date depending on the tasks position in the project
    fun checkPosition() {
        val otherJobs = assignedProj.projectTasks
        val thisIndex = otherJobs.indexOf(this)
        if (thisIndex == 0 && prevTasks.isEmpty()) {
            isFirst = true
            isLast = false
            taskStartDate = assignedProj.startDate
        }
        if (thisIndex + 1 == otherJobs.size && otherJobs.size > 1 && nextTasks.isEmpty()) {
            isLast = true
            isFirst = false
            var max = LocalDate.parse("1111-11-11")
            for (i in prevTasks.indices) {
                val c = prevTasks[i]!!.taskStartDate!!.plusDays(prevTasks[i]!!.duration.toLong())
                if (c.compareTo(max) > 0) max = c
            }
            taskStartDate = max
        } else if (otherJobs.size > 1 && thisIndex != 0 && thisIndex != otherJobs.size - 1) {
            var max = LocalDate.parse("1111-11-11")
            for (i in prevTasks.indices) {
                val c = prevTasks[i]!!.taskStartDate!!.plusDays(prevTasks[i]!!.duration.toLong())
                if (c.compareTo(max) > 0) max = c
            }
        }
        taskEndDate = taskStartDate!!.plusDays(duration.toLong())
    }

    fun isDependant(t: Task): Boolean {
        if (nextTasks.contains(t)) {
            return true
        }
        for (g in nextTasks) {
            if (g.isDependant(t)) {
                return true
            }
        }
        return false
    }

    fun setTaskComplete() {
        isCompleted = true
    }

    //getters and setters

    fun getIsCompleted(): Boolean{
        return isCompleted;
    }

    fun getCritCost(): Int{
        return criticalCost;
    }
    fun getdanum(): Int{
        return danum;
    }
    fun setdanum(i: Int){
        danum = i;
    }
    @JvmName("getTaskDesc1")
    fun getTaskDesc(): String{
        return taskDesc;
    }

    @JvmName("getDuration1")
    fun getDuration(): Int{
        return duration;
    }
    init {
        assignedTeam = assignedProj.nonAssigned
        if (predecessors != "null") {
            val nodes = predecessors.split(",".toRegex()).toTypedArray()
            for (node in nodes) {
                assignedProj.getTaskOfDescription(node)!!.nextTasks.add(this)
                prevTasks.add(assignedProj.getTaskOfDescription(node))
            }
        }
    }
}
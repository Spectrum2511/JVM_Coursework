package classes

import java.time.LocalDate
import java.util.*

class Task(
    val taskDesc: String, //private classes.Team assignedTo;
    val assignedProj: Project, val duration: Int, val predecessors: String
) {

    var taskStartDate: LocalDate? = null
        private set
    private var TaskEndDate: LocalDate? = null
    private var isFirst = false
    private var isLast = false
    val nextTasks = ArrayList<Task>()
    val prevTasks = ArrayList<Task?>()
    var isCompleted = false
        private set
    var assignedTeam: Team
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
        TaskEndDate = taskStartDate!!.plusDays(duration.toLong())
    }

    fun setTaskComplete() {
        isCompleted = true
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
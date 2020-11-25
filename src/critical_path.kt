import classes.Task
import java.util.*

class critical_path(h: programHandler) {
    lateinit var output: String
    var tasks: ArrayList<Task>
    var remaining: ArrayList<Task?>
    var sp: Task
    var ep: Task
    fun calculate_critical_path(): String {
        output = "";
        var this_node: Task? = sp
        while (this_node != ep) {
            var highest_cost = 0
            var highest_cost_node: Task? = null
            for (node in this_node!!.nextTasks) {
                if (node.duration >= highest_cost) {
                    highest_cost = node.duration
                    highest_cost_node = node
                }
            }
            output = output + this_node.taskDesc
            remaining.remove(this_node)
            this_node = highest_cost_node
            output = "$output, "
        }
        output = output + this_node.taskDesc
        return output
    }

    init {
        remaining = ArrayList(h.currentProject.projectTasks)
        tasks = ArrayList(h.currentProject.projectTasks)
        sp = tasks[0]
        ep = tasks[tasks.size - 1]
    }
}
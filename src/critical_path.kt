//Krotlin Critical Path method
import classes.Task
import java.util.*

class critical_path(h: programHandler) {

    val passer = h;
    lateinit var output: String;
    lateinit var tasks: ArrayList<Task>
    lateinit var remaining: ArrayList<Task?>
    lateinit var sp: Task
    lateinit var ep: Task
    fun calculate_critical_path(): String {
        remaining = ArrayList(passer.currentProject.projectTasks)
        tasks = ArrayList(passer.currentProject.projectTasks)
        sp = tasks[0]
        ep = tasks[tasks.size - 1]
        output = "";
        //find the neighbour with largest duratio and set it as the current node
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

    }
}
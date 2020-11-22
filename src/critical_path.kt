import classes.Task
import java.util.*

class critical_path {
    var handler = programHandler.instance
    var remaining = ArrayList(handler.currentProject?.projectTasks)
    var tasks = ArrayList(handler.currentProject?.projectTasks)
    var sp = tasks[0]
    var ep = tasks[tasks.size - 1]
    var output = ""
    fun calculate_critical_path(): String {
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
        output += this_node?.taskDesc ?:
        System.out.println(output)
        return output
    }
}
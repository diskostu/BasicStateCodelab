package de.diskostu.android.basicstatecodelab.viewmodel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import de.diskostu.android.basicstatecodelab.WellnessTask

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

/**
 * The view model is the data layer. By using it, the list will survive configuration changes.
 */
class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks


    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }


    fun changeTaskChecked(item: WellnessTask, checked: Boolean) =
        _tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
}
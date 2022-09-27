package de.diskostu.android.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        StatefulCounter(modifier)

        val list = remember { getWellnessTasks().toMutableStateList() }
        WellnessTaskList(
            list = list,
            onCloseTask = { task -> list.remove(task) },
            modifier = modifier
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewWellnessScreen() {
    WellnessScreen()
}
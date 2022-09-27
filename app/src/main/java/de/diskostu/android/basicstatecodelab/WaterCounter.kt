package de.diskostu.android.basicstatecodelab

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("UnrememberedMutableState")
@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by rememberSaveable { mutableStateOf(0) }

        Button(
            onClick = { count++ },
            Modifier.padding(top = 8.dp),
            enabled = count < 10
        ) {
            Text("Add one")
        }

        if (count > 0) {
            Text("You've had $count glasses.")
        }
    }
}

/**
 * This demo Composable shows how fields are "remembered" during recomposition (see the comment inside the function)
 */
@Suppress("unused")
@Composable
fun WaterCounterDemo(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by remember { mutableStateOf(0) }

        Row(Modifier.padding(top = 8.dp)) {
            Button(
                onClick = { count++ },
                enabled = count < 10
            ) {
                Text(text = "One more glass")
            }
            Spacer(modifier = Modifier.padding(start = 16.dp))
            Button(
                onClick = { count = 0 },
                enabled = count > 0
            ) {
                Text(text = "Reset water counter")
            }
        }

        if (count > 0) {
            // if WellnessTaskItem was displayed and then "closed", it will stay "closed"
            // even if you add more glasses of water. This is because "showTask" is remembered if the code
            // inside this "if" is executed during recomposition. "showTask" is never again set to "true", only
            // once on initialization (mutableStateOf(true)).
            // On the other hand, if the count gets reset to 0 with the "reset" button, the code inside
            // this if is NOT executed and thus all "remembered" fields inside this "if"
            // will be forgotten.
            Text("You've had $count glasses.")

            var showTask by remember { mutableStateOf(true) }
            if (showTask) {
                WellnessTaskItem(
                    taskname = "Have you taken your 15 minute walk today?",
                    onClose = { showTask = false })
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun WaterCounterPreview() {
    WaterCounter()
}
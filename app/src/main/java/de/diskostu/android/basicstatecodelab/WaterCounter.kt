package de.diskostu.android.basicstatecodelab

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("UnrememberedMutableState")
@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }

    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "You've had $count glasses."
        )
        Button(
            onClick = { count++ },
            modifier = modifier.padding(top = 8.dp)
        ) {
            Text(text = "One more glass")
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun WaterCounterPreview() {
    WaterCounter()
}
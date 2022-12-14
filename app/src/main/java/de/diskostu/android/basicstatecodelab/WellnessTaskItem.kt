package de.diskostu.android.basicstatecodelab

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.diskostu.android.basicstatecodelab.util.CompletePreviews

@Composable
fun WellnessTaskItem(
    taskname: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = taskname
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        // the onClick-Event now goes a long way up, until WellnessScreen
        IconButton(
            onClick = onClose
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Close"
            )
        }
    }
}


@Composable
@CompletePreviews
fun WellnessTaskItemPreview() {
    WellnessTaskItem(
        taskname = "Do something",
        onClose = { },
        checked = false,
        onCheckedChange = {})
}
package com.hacklord.dynamicplannerandroid.ui.timeline_editor.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hacklord.dynamicplannerandroid.data.FocusLevel

@Composable
fun TaskItem(
    title: String,
    focus: FocusLevel,
    modifier: Modifier = Modifier
) {
    Row {
        Column {
            Text(
                text = title
            )
            Text(
                text = "Focus: " + focus.name
            )
        }

        Spacer(
            modifier = Modifier
                .weight(1f)
        )

        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = "Delete",
            modifier = Modifier
        )
    }
}
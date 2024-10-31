package com.hacklord.dynamicplannerandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hacklord.dynamicplannerandroid.data.DueDate
import com.hacklord.dynamicplannerandroid.data.DueItem
import com.hacklord.dynamicplannerandroid.ui.theme.DynamicPlannerAndroidTheme
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DynamicPlannerAndroidTheme {
                Text(
                    text = Json.encodeToString(DueItem.Task(DueDate(Clock.System.todayIn(TimeZone.currentSystemDefault()))))
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DynamicPlannerAndroidTheme {
        Greeting("Android")
    }
}
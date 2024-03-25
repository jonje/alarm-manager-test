package org.haknet.alarmmanagertest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.haknet.alarmmanagertest.data.AlarmItem
import org.haknet.alarmmanagertest.data.AndroidAlarmScheduler
import org.haknet.alarmmanagertest.ui.theme.AlarmManagerTestTheme
import java.time.LocalDateTime


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val scheduler = AndroidAlarmScheduler(this)
        setContent {
            AlarmManagerTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(scheduler)
                }
            }
        }
    }
}

@Composable
fun Greeting(scheduler: AndroidAlarmScheduler) {
    var secondText by remember {
        mutableStateOf("")
    }
    var message by remember {
        mutableStateOf("")
    }

    var alarmItem: AlarmItem? = null
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = secondText,
            onValueChange = { secondText = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Trigger alarm in seconds")
            })
        OutlinedTextField(
            value = message,
            onValueChange = { message = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Message")
            })
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Button(onClick = {
                alarmItem = AlarmItem(
                    time = LocalDateTime.now()
                        .plusSeconds(secondText.toLong()),
                    message = message
                )

                alarmItem?.let(scheduler::schedule)
                secondText = ""
                message = ""

            }) {
                Text(text = "Schedule")

            }
            Button(onClick = { alarmItem?.let(scheduler::cancel) }) {
                Text(text = "Cancel")

            }
        }
    }
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    val scheduler = AndroidAlarmScheduler()
//    AlarmManagerTestTheme {
//        Greeting()
//    }
//}
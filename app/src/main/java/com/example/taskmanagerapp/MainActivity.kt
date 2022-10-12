package com.example.taskmanagerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagerapp.ui.theme.TaskManagerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),) {
                    AllTasksCompletedWithImage(
                        message = stringResource(id = R.string.message),
                        subtitle = stringResource(id = R.string.subtitle)
                    )
                }
            }
        }
    }
}

@Composable
fun AllTasksCompletedWithImage(message: String, subtitle: String) {
    val image = painterResource(id = R.drawable.ic_task_completed)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
        )
        AllTaskCompletedText(message, subtitle)
    }
}

@Composable
fun AllTaskCompletedText(message: String, subtitle: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(
                    top = 24.dp,
                    bottom = 8.dp
                ),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = subtitle,
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    TaskManagerAppTheme {
        AllTasksCompletedWithImage(
            message = stringResource(id = R.string.message), 
            subtitle = stringResource(id = R.string.subtitle)
        )
    }
}
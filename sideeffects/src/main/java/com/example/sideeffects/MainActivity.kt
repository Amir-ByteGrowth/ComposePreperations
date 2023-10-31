package com.example.sideeffects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sideeffects.ui.theme.ComposePreperationsTheme
import com.example.sideeffects.widgets.ComposableSide1
import com.example.sideeffects.widgets.CoroutineScopePractice
import com.example.sideeffects.widgets.LaunchEffectWithApiCalling
import com.example.sideeffects.widgets.LaunchedEffectP1
import com.example.sideeffects.widgets.LaunchedSideEffectWidget
import com.example.sideeffects.widgets.RememberCoroutineP1
import com.example.sideeffects.widgets.RememberUpdatedStatePractice
import com.example.sideeffects.widgets.SideEffectFreeWidget
import com.example.sideeffects.widgets.ToastSideEffectExample
import com.example.sideeffects.widgets.ToastSideEffectExampleWithLaunch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePreperationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    LaunchedEffectP1()
//                    RememberUpdatedStatePractice()
//                    ToastSideEffectExample()
//                    ToastSideEffectExampleWithLaunch()
//                    LaunchEffectWithApiCalling()
                    CoroutineScopePractice()
                }
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
    ComposePreperationsTheme {
        Greeting("Android")
    }
}
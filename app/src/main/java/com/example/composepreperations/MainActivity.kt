package com.example.composepreperations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.composepreperations.ui.theme.ComposePreperationsTheme
import com.example.composepreperations.widgets.MyAppBar
import com.example.composepreperations.widgets.simpleviewmodel.MyViewModel
import com.example.composepreperations.widgets.simpleviewmodel.ViewModelWidget
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePreperationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                    OutLinedTextFieldWidget()
//                    MyAppBar("Composeable") {
//                        finish()
//                    }

                    var myViewModel=MyViewModel()

                    ViewModelWidget(myViewModel.name.observeAsState().value.toString(),myViewModel)


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
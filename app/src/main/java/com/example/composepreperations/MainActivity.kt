package com.example.composepreperations

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.composepreperations.ui.theme.ComposePreperationsTheme
import com.example.composepreperations.widgets.MyAppBar
import com.example.composepreperations.widgets.simpleviewmodel.MyViewModel
import com.example.composepreperations.widgets.simpleviewmodel.ViewModelWidget
import com.example.composepreperations.widgets.statepractice.MainScreen
import com.example.composepreperations.widgets.statepractice.incrementData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePreperationsTheme {

                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()
                val coroutineScope: CoroutineScope = rememberCoroutineScope()
                // A surface container using the 'background' color from the theme
                Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }, content =
                {
                        innerPadding ->
                    Surface(

                    color = MaterialTheme.colorScheme.background,
                        modifier = Modifier.padding(innerPadding)
                ) {
//                    Greeting("Android")
//                    OutLinedTextFieldWidget()
//                    MyAppBar("Composeable") {
//                        coroutineScope.launch {
//                            snackbarHostState.showSnackbar(
//                                message = "This is your message",
//                                actionLabel = "Do something",
//                                duration = SnackbarDuration.Short
//                            )
//
//                        }
//                    }
//                        var a by remember {
//                            mutableIntStateOf(0)
//                        }
//                        incrementData(a){
//                            a++
//                        }
                        MainScreen()

//                    var myViewModel=MyViewModel()
//
//                    ViewModelWidget(myViewModel.name.observeAsState().value.toString(),myViewModel)


                }

                })


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
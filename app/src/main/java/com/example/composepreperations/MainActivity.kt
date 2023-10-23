package com.example.composepreperations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composepreperations.ui.theme.ComposePreperationsTheme
import com.example.composepreperations.widgets.statepractice.MainScreen
import kotlinx.coroutines.CoroutineScope

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
                { innerPadding ->
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
    var list=userList.groupBy { it.id }
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

data class UserData(var name: String, val id: Int)

var userList = listOf(
    UserData("amir", 1),
    UserData("Rashid", 1),
    UserData("Nomi", 2),
    UserData("Kari", 4)
)
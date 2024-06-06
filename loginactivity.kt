// mainactivity.kt
package com.example.demo

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.demo.ui.theme.DemoTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                             TopAppBar(
                                 title = {
                                 Text("Demo App")
                                 },
                                 navigationIcon = {
                                     IconButton(onClick = {}) {
                                         Icon(Icons.Filled.Menu, contentDescription = "menu" )

                                     }
                                 },
                                 actions = {
                                     IconButton(onClick = {}) {
                                         Icon(Icons.Filled.Search, contentDescription = "search")

                                     }
                                 }

                             )
                    },
                    floatingActionButton = {
                                           FloatingActionButton(onClick = {  }) {
                                               Icon(Icons.Filled.Add, contentDescription = "add")

                                           }
                    },
                    floatingActionButtonPosition = FabPosition.End,
                                 modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        color = MaterialTheme.colorScheme.secondary,
        modifier = Modifier
    )
}

@Preview(showBackground = true, name = "light mode",
    uiMode = Configuration.UI_MODE_TYPE_CAR)
@Preview(showBackground = true, name = "dark mode",
    uiMode = Configuration.UI_MODE_TYPE_APPLIANCE)
@Composable
fun GreetingPreview() {
    DemoTheme {
        Greeting("Android")
    }
}

// loginactivity.kt
package com.example.demo

import android.os.Bundle
import android.os.PersistableBundle
import android.text.LoginFilter.UsernameFilterGeneric
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo.ui.theme.DemoTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Surface (color = MaterialTheme.colorScheme.background ){
                    LoginScreen()
                }
            }
        }
    }
    private fun logged(username:String, password:String){
        if(username == "abc" && password == "123"){
            Toast.makeText(this, "logged!", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "wrong!", Toast.LENGTH_SHORT).show()
        }

    }
    @Composable
    fun LoginScreen(){
        val username = remember { mutableStateOf("")}
        val password = remember { mutableStateOf("") }

        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Text(text = " ! Hello User !", color = Color.Red, fontSize = 20.sp, fontFamily = FontFamily.Monospace,  fontWeight = FontWeight.ExtraBold
            )
            Text(text = " ! Demo App !", color = Color.Black, fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.ExtraBold
            )
            Text(text = " ! Welcome Back !", color = Color.Black, fontSize = 20.sp, fontFamily = FontFamily.Monospace,  fontWeight = FontWeight.ExtraBold
            )
            OutlinedTextField(
                value = username.value,
                onValueChange = {
                    username.value= it
                },
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription ="person" )
                },
                label = {
                    Text(text = "Username")
                },
                placeholder = {
                    Text(text = "Enter username")
                },
                modifier = Modifier.fillMaxWidth()

            )
            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    password.value= it
                },
                leadingIcon = {
                    Icon(Icons.Default.Info, contentDescription ="person" )
                },
                label = {
                    Text(text = "Password")
                },
                placeholder = {
                    Text(text = "Enter password")
                },
                modifier = Modifier.fillMaxWidth()

            )
            OutlinedButton(onClick = {logged(username.value,password.value)  },modifier = Modifier.fillMaxWidth()) {
                Text(text = "Login")

            }
        }
    }

}

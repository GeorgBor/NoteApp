package at.ac.fhcampuswien.mvvmdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import at.ac.fhcampuswien.mvvmdemo.navigation.AppNavigation
import at.ac.fhcampuswien.mvvmdemo.ui.theme.MVVMDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            MVVMDemoTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigation(
                            backgroundColor = MaterialTheme.colors.primary,
                            contentColor = Color.White
                        ) {

                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentRoute = navBackStackEntry?.destination?.route

                            BottomNavigationItem(
                                icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "home") },
                                selected = currentRoute == "homescreen",
                                onClick = {
                                          navController.navigate("homescreen")
                                },
                            )

                            BottomNavigationItem(
                                icon = { Icon(imageVector = Icons.Default.Add, contentDescription = "addnotescreen") },
                                selected = currentRoute == "addnotescreen",
                                onClick = {
                                    navController.navigate("addnotescreen")
                                },
                            )
                        }
                    }
                ) { innerPadding -> // needed so that the bottom bar does not overlap screen contents
                    Box(modifier = Modifier.padding(innerPadding)) {
                        AppNavigation(navController)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MVVMDemoTheme {
        AppNavigation()
    }
}
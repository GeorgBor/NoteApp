package at.ac.fhcampuswien.mvvmdemo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import at.ac.fhcampuswien.mvvmdemo.screens.AddNoteScreen
import at.ac.fhcampuswien.mvvmdemo.screens.HomeScreen

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()){
    NavHost(navController = navController, startDestination = "homescreen"){
        composable(route = "homescreen") { HomeScreen() }

        composable(route = "addnotescreen") { AddNoteScreen() }
    }
}
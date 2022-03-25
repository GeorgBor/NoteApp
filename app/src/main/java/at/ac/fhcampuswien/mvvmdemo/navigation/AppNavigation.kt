package at.ac.fhcampuswien.mvvmdemo.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import at.ac.fhcampuswien.mvvmdemo.screens.AddNoteScreen
import at.ac.fhcampuswien.mvvmdemo.screens.HomeScreen
import at.ac.fhcampuswien.mvvmdemo.viewmodels.NoteViewModel

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()){
    //
    val noteViewModel: NoteViewModel = viewModel()

    NavHost(navController = navController, startDestination = "homescreen"){
        composable(route = "homescreen") { HomeScreen(viewModel = noteViewModel) }

        composable(route = "addnotescreen") { AddNoteScreen(viewModel = noteViewModel) }
    }
}
package at.ac.fhcampuswien.mvvmdemo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import at.ac.fhcampuswien.mvvmdemo.db.NotesDB
import at.ac.fhcampuswien.mvvmdemo.repositories.NoteRepository
import at.ac.fhcampuswien.mvvmdemo.screens.AddNoteScreen
import at.ac.fhcampuswien.mvvmdemo.screens.HomeScreen
import at.ac.fhcampuswien.mvvmdemo.viewmodels.NoteViewModel
import at.ac.fhcampuswien.mvvmdemo.viewmodels.NoteViewModelFactory

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()){
    //
    val context = LocalContext.current
    val db = NotesDB.getDatabase(context = context)
    val repository = NoteRepository(dao = db.notesDao())

    val noteViewModel: NoteViewModel = viewModel(
        factory = NoteViewModelFactory(repository = repository)
    )

    NavHost(navController = navController, startDestination = "homescreen"){
        composable(route = "homescreen") { HomeScreen(viewModel = noteViewModel) }

        composable(route = "addnotescreen") { AddNoteScreen(viewModel = noteViewModel) }
    }
}
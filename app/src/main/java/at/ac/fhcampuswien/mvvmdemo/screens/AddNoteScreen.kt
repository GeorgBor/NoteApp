package at.ac.fhcampuswien.mvvmdemo.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import at.ac.fhcampuswien.mvvmdemo.models.Note
import at.ac.fhcampuswien.mvvmdemo.viewmodels.NoteViewModel
import at.ac.fhcampuswien.mvvmdemo.widgets.AddNoteWidget
import at.ac.fhcampuswien.mvvmdemo.widgets.NoteCards

@Preview(showBackground = true)
@Composable
fun AddNoteScreen(viewModel: NoteViewModel = viewModel()){
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        AddNoteWidget{ note ->
            viewModel.addNote(note)
        }

        Divider()

        val notes: List<Note> by viewModel.notes.collectAsState()

        NoteCards(
            notes = notes
        ) { note ->
            viewModel.removeNote(note)
        }
    }
}
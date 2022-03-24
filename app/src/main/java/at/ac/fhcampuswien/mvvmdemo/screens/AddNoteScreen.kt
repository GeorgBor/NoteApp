package at.ac.fhcampuswien.mvvmdemo.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
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

        AddNoteWidget(onSaveNote = { note ->
            viewModel.addNote(note)
        })

        Divider()

        /*
        val notes = listOf(
            Note("Buy Groceries", "23.03.2022 10:00"),
            Note("Lorem Ipsum", "24.03.2022 11:32"),
        )

         */

        NoteCards(notes = viewModel.getAllNotes())
    }
}
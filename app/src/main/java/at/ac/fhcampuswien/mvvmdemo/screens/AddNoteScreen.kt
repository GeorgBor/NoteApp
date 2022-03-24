package at.ac.fhcampuswien.mvvmdemo.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import at.ac.fhcampuswien.mvvmdemo.models.Note
import at.ac.fhcampuswien.mvvmdemo.widgets.AddNoteWidget
import at.ac.fhcampuswien.mvvmdemo.widgets.NoteCards

@Preview(showBackground = true)
@Composable
fun AddNoteScreen(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        var notes = remember {
            mutableStateListOf<Note>()
        }

        AddNoteWidget(onSaveNote = { note ->
            notes.add(note)
        })

        Divider()

        /*
        val notes = listOf(
            Note("Buy Groceries", "23.03.2022 10:00"),
            Note("Lorem Ipsum", "24.03.2022 11:32"),
        )

         */

        NoteCards(notes = notes)
    }
}
package at.ac.fhcampuswien.mvvmdemo.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import at.ac.fhcampuswien.mvvmdemo.models.Note
import at.ac.fhcampuswien.mvvmdemo.widgets.AddNoteWidget
import at.ac.fhcampuswien.mvvmdemo.widgets.NoteCards
import java.text.SimpleDateFormat
import java.util.*

@Preview(showBackground = true)
@Composable
fun AddNoteScreen(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        AddNoteWidget()

        Divider()

        val notes = listOf(
            Note("Buy Groceries", "23.03.2022 10:00"),
            Note("Lorem Ipsum", "24.03.2022 11:32"),
        )

        NoteCards(notes = notes)
    }
}
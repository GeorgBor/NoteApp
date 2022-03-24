package at.ac.fhcampuswien.mvvmdemo.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import at.ac.fhcampuswien.mvvmdemo.models.Note
import at.ac.fhcampuswien.mvvmdemo.widgets.NoteCards

@Composable
fun HomeScreen(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "My Notes",
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
            style = MaterialTheme.typography.h5)

        val notes = listOf(
            Note("Buy Groceries", "23.03.2022 10:00"),
            Note("Lorem Ipsum", "24.03.2022 11:32"),
        )

        NoteCards(notes = notes)
    }
}

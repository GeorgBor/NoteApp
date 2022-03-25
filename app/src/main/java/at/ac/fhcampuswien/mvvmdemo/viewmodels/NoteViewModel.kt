package at.ac.fhcampuswien.mvvmdemo.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import at.ac.fhcampuswien.mvvmdemo.models.Note

class NoteViewModel : ViewModel() {
    private var notes = mutableStateListOf<Note>()

    init {
        notes.addAll(
            listOf(
                Note("Buy Groceries", "23.03.2022 10:00"),
                Note("Do workout", "24.03.2022 11:32"),
            )
        )
    }

    fun addNote(note: Note){
        notes.add(note)
    }

    fun removeNote(note: Note){
        notes.remove(note)
    }

    fun getAllNotes(): List<Note>{
        return notes
    }

    fun sortNotes(){

    }

    fun filterNotes(){

    }
}
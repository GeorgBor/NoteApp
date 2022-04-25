package at.ac.fhcampuswien.mvvmdemo.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import at.ac.fhcampuswien.mvvmdemo.models.Note
import at.ac.fhcampuswien.mvvmdemo.repositories.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class NoteViewModel(
    private val repository: NoteRepository
) : ViewModel() {

    private var _notes = MutableStateFlow<List<Note>>(emptyList())//mutableStateListOf<Note>()
    val notes = _notes.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) { // launch a coroutine in IO thread
            repository.getAllNotes().distinctUntilChanged()
                .collect{ listOfNotes ->
                    if(listOfNotes.isNullOrEmpty()){
                        Log.d("NoteViewModel", "Empty note list")
                    } else {
                        _notes.value = listOfNotes
                    }
                }
        }
        /*
        notes.addAll(
            listOf(
                Note(text = "Buy Groceries", date = "23.03.2022 10:00"),
                Note(text ="Do workout", date = "24.03.2022 11:32"),
            )
        )

         */
    }

    fun addNote(note: Note){

        viewModelScope.launch {
            repository.addNote(note = note)
        }
        // notes.add(note)
    }

    fun removeNote(note: Note) = viewModelScope.launch { repository.deleteNote(note = note) }

    /*
    fun getAllNotes(): List<Note>{
        return notes
    }

     */

    fun editNote(note: Note) = viewModelScope.launch { repository.editNote(note = note) }

    fun deleteAll() = viewModelScope.launch { repository.deleteAll() }

    fun sortNotes(){

    }

    fun filterNotes(){

    }
}
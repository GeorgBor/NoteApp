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
import kotlinx.coroutines.launch

class NoteViewModel(
    private val repository: NoteRepository
) : ViewModel() {
    //private var notes = mutableStateListOf<Note>()
    private var _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes = _notes.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().collect{ listOfNotes ->
                if(listOfNotes.isNullOrEmpty()){
                    //
                    Log.d("NoteViewModel", "No notes")
                } else {
                    _notes.value = listOfNotes
                }
            }
        }
    }

    fun addNote(note: Note){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNote(note = note)
        }


    }

    fun removeNote(note: Note){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNote(note)
        }
    }

    fun editNote(note: Note){
        viewModelScope.launch(Dispatchers.IO) {
            repository.editNote(note = note)
        }
    }

    fun sortNotes(){

    }

    fun filterNotes(){

    }
}
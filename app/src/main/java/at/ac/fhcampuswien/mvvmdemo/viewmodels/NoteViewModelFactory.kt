package at.ac.fhcampuswien.mvvmdemo.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import at.ac.fhcampuswien.mvvmdemo.repositories.NoteRepository
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class NoteViewModelFactory(private val repository: NoteRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            return NoteViewModel(repository = repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

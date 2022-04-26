package at.ac.fhcampuswien.mvvmdemo.repositories

import at.ac.fhcampuswien.mvvmdemo.db.NotesDao
import at.ac.fhcampuswien.mvvmdemo.models.Note
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val dao: NotesDao) {

    suspend fun addNote(note: Note) = dao.addNote(note = note)

    suspend fun editNote(note: Note) = dao.editNote(note = note)

    suspend fun deleteNote(note: Note) = dao.deleteNote(note = note)

    suspend fun deleteAll() = dao.deleteAll()

    fun getAllNotes(): Flow<List<Note>> = dao.getNotes()


}
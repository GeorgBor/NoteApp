package at.ac.fhcampuswien.mvvmdemo.db

import androidx.room.*
import at.ac.fhcampuswien.mvvmdemo.models.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {
    // suspend functions are functions that can be paused and resumed at a later time
    // they can execute a long running operation without blocking, meaning they run in another thread

    @Insert
    suspend fun addNote(note: Note)

    @Update
    suspend fun editNote(note:Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * from notes")
    fun getNotes(): Flow<List<Note>>

    @Query("DELETE FROM notes")
    fun deleteAll()

    @Query("SELECT * from notes where id =:id")
    suspend fun getNoteById(id: Long): Note
}
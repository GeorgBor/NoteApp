package at.ac.fhcampuswien.mvvmdemo.db

import androidx.room.*
import at.ac.fhcampuswien.mvvmdemo.models.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Insert
    suspend fun addNote(note: Note)

    @Update
    suspend fun editNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * from notes")
    fun getNotes(): Flow<List<Note>>

    @Query("DELETE FROM notes")
    suspend fun deleteAll()

    @Query("SELECT * from notes where id=:id")
    suspend fun getNoteById(id: Long): Note

}
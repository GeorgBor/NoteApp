package at.ac.fhcampuswien.mvvmdemo.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,

    @ColumnInfo(name = "note_text")
    val text: String,
    val date: String)

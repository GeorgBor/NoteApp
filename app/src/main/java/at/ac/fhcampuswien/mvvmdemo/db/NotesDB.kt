package at.ac.fhcampuswien.mvvmdemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import at.ac.fhcampuswien.mvvmdemo.models.Note

@Database(
    entities = [Note::class], // add entities here
    version = 1,
    exportSchema = false
)
abstract class NotesDB: RoomDatabase(){
    abstract fun notesDao(): NotesDao

    companion object {
        private var INSTANCE: NotesDB? = null

        fun getDatabase(context: Context): NotesDB {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also{
                    INSTANCE = it
                }
            }
        }

        private fun buildDatabase(context: Context): NotesDB{
            return Room
                .databaseBuilder(context, NotesDB::class.java, "note_database")
                .addCallback(
                    object : RoomDatabase.Callback(){
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            // do work on first db creation
                        }

                        override fun onOpen(db: SupportSQLiteDatabase) {
                            super.onOpen(db)
                            // do work on each start
                        }
                    }
                )
                .fallbackToDestructiveMigration()
                .build()
        }

    }

}
package com.example.notes

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note:Note)

    @Delete
    suspend fun delete(note:Note)

    @Query("Select * from NotesTable order by id ASC")

    fun getAllNotes():LiveData<List<Note>>
}

package com.example.notes

import android.app.Application
import android.graphics.DiscretePathEffect
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val repository:NoteRepository
    val allNotes:LiveData<List<Note>>
    init {
        val dao=NoteDataBase.getDatabase(application).getNoteDao()
        repository=NoteRepository(dao)
        allNotes=repository.allNotes
    }
    fun deleteNote(note:Note)=viewModelScope.launch(Dispatchers.IO){
        repository.delete(note)
    }
    fun insertNote(note:Note)=viewModelScope.launch(Dispatchers.IO) {
        if(allNotes.value?.contains(note)==false){
            repository.insert(note)
        }
    }
}
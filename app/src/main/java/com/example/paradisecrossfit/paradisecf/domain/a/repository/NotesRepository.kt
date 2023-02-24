package com.example.paradisecrossfit.paradisecf.domain.a.repository

import com.example.paradisecrossfit.paradisecf.domain.a.model.Note
import com.example.paradisecrossfit.paradisecf.util.Resource


interface NotesRepository {

    suspend fun saveNote(note: Note): Resource<Unit>

    suspend fun getAllNotes(): Resource<List<Note>>

    suspend fun deleteNote(note: Note): Resource<Unit>

}
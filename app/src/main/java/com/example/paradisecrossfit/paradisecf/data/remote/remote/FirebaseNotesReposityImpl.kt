package com.example.paradisecrossfit.paradisecf.data.remote.remote

import com.example.paradisecrossfit.paradisecf.data.remote.util.FirebaseConstants.NOTES_COLLECTION
import com.example.paradisecrossfit.paradisecf.domain.a.model.Note
import com.example.paradisecrossfit.paradisecf.domain.a.repository.NotesRepository
import com.example.paradisecrossfit.paradisecf.util.Resource
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirestoreNotesRepositoryImpl @Inject constructor(

): NotesRepository {
//Guardamos notas
    override suspend fun saveNote(note: Note): Resource<Unit> {
        return try {
            //guardamos la nota en el documento id
            var isSuccessful = false
            FirebaseFirestore.getInstance().collection(NOTES_COLLECTION)
                .document(note.id)
                .set(note, SetOptions.merge())
                .addOnCompleteListener { isSuccessful = it.isSuccessful }
                .await()
//En caso afirmativo guardamos un sucess y en caso negativo el mensaje de error
            if (isSuccessful) {
                Resource.Sucess(Unit)
            } else {
                Resource.Error("Error de red")
            }
        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }
//devuelve todas las notas
    override suspend fun getAllNotes(): Resource<List<Note>> {
        return try {
            val notesList = FirebaseFirestore.getInstance().collection(NOTES_COLLECTION)
                .get()
                .await()
                .toObjects(Note::class.java)

            Resource.Sucess(notesList)
        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }
//Eliminamos notas
    override suspend fun deleteNote(note: Note): Resource<Unit> {
        return try {
            var isSuccessful = false
            FirebaseFirestore.getInstance().collection(NOTES_COLLECTION)
                .document(note.id)
                .delete()
                .addOnCompleteListener { isSuccessful = it.isSuccessful }
                .await()

            if (isSuccessful) {
                Resource.Sucess(Unit)
            } else {
                Resource.Error("Error de red")
            }
        } catch (e :Exception) {
            Resource.Error(e.message.toString())
        }
    }

}

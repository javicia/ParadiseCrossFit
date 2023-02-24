package com.example.paradisecrossfit.paradisecf.domain.a.repository.usecase

import com.example.paradisecrossfit.paradisecf.domain.a.model.Note
import com.example.paradisecrossfit.paradisecf.domain.a.repository.NotesRepository
import com.example.paradisecrossfit.paradisecf.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FirebaseDeleteNoteUseCase @Inject constructor(
    private val notesRepository: NotesRepository
) {

    suspend operator fun invoke(note: Note): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading)

        val networkRequest = notesRepository.deleteNote(note)

        when(networkRequest) {
            is Resource.Sucess -> emit(Resource.Sucess(Unit))
            is Resource.Error -> emit(Resource.Error(networkRequest.message))
            else -> Resource.Finished
        }
    }
}

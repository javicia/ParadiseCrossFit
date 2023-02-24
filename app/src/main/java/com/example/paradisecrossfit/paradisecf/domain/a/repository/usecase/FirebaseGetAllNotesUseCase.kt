package com.example.paradisecrossfit.paradisecf.domain.a.repository.usecase

import com.example.paradisecrossfit.paradisecf.domain.a.model.Note
import com.example.paradisecrossfit.paradisecf.domain.a.repository.NotesRepository
import com.example.paradisecrossfit.paradisecf.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FirebaseGetAllNotesUseCase @Inject constructor(
    private val notesRepository: NotesRepository
) {

    suspend operator fun invoke(): Flow<Resource<List<Note>>> = flow {
        emit(Resource.Loading)

        val networkRequest = notesRepository.getAllNotes()

        when(networkRequest) {
            is Resource.Sucess -> emit(Resource.Sucess(networkRequest.data))
            is Resource.Error -> emit(Resource.Error(networkRequest.message))
            else -> Resource.Finished
        }
    }
}

package com.example.paradisecrossfit.paradisecf.domain.a.repository.usecase

import com.example.paradisecrossfit.paradisecf.util.Resource
import javax.inject.Inject
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await


class FirebasePasswordRecoveryUseCase
@Inject constructor() {

    suspend operator fun invoke(email: String): Flow<Resource<Boolean>> = flow {
        try {
            emit(Resource.Loading)
            var isSuccessful = false
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener { isSuccessful = it.isSuccessful }
                .await()
            emit(Resource.Sucess(isSuccessful))
            emit(Resource.Finished)
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
            emit(Resource.Finished)
        }
    }

}
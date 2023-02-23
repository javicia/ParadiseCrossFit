package com.example.paradisecrossfit.firebaseyt.domain.a.repository.usecase

import com.example.paradisecrossfit.firebaseyt.domain.a.repository.AuthRepository
import com.example.paradisecrossfit.firebaseyt.util.Resource
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow
import javax.inject.Inject

class FirebaseSignUpUseCase @Inject constructor(
    private val authRepository: AuthRepository
){
    suspend operator fun invoke(email:String, password:String): kotlinx.coroutines.flow.Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading)
        val isSignUpSuccessfully : Boolean = authRepository.signup(email, password)
        if (isSignUpSuccessfully){
            emit(Resource.Sucess(true))
        }else{
            emit(Resource.Error("Error en el sign up"))
        }
    }
    }

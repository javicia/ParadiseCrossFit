package com.example.paradisecrossfit.firebaseyt.domain.a.repository.usecase


import com.example.paradisecrossfit.firebaseyt.domain.a.repository.AuthRepository
import com.example.paradisecrossfit.firebaseyt.util.Resource
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
    //Repositorio de autentificación
class FirebaseLoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
){
    suspend operator fun invoke(email:String, password:String): Flow <Resource<Boolean>> = flow {
        emit(Resource.Loading)
        val userUID: String = authRepository.signup(email, password)
        //En caso de estar vacío hacemos un Succes
        if (userUID.isNotEmpty()){
            emit(Resource.Sucess(true))
            emit(Resource.Finished)
            //En caso contrario lanza el error
        }else{
            emit(Resource.Error("Error en el acceso"))
            emit(Resource.Finished)
        }
    }

}
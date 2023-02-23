package com.example.paradisecrossfit.firebaseyt.domain.a.repository

import com.example.paradisecrossfit.firebaseyt.domain.a.model.User


//Creamos el repositorio de usuario
//Creamos usuario
//Devolvemos usuario
interface UserRepository {
    suspend fun createUser(user:User): Boolean
    suspend fun getUser(uid:String): User
}
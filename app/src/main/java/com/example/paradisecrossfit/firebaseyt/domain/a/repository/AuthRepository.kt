package com.example.paradisecrossfit.firebaseyt.domain.a.repository

interface AuthRepository {
    suspend fun login(email:String, password:String): Boolean

    suspend fun signup (email:String, password:String): String
}
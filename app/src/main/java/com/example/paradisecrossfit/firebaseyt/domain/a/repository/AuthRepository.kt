package com.example.paradisecrossfit.firebaseyt.domain.a.repository

interface AuthRepository {
    suspend fun login(email:String, password:String): String

    suspend fun signup (email:String, password:String): String
}
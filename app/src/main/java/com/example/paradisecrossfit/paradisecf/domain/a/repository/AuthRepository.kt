package com.example.paradisecrossfit.paradisecf.domain.a.repository

interface AuthRepository {
    suspend fun login(email:String, password:String): String

    suspend fun signup (email:String, password:String): String
}
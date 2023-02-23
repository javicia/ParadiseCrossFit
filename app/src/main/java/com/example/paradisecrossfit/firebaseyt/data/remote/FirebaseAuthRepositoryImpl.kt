package com.example.paradisecrossfit.firebaseyt.data.remote

import com.example.paradisecrossfit.firebaseyt.domain.a.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
): AuthRepository {
    override suspend fun login(email: String, password: String): Boolean {
        return try {
            var isSuccessful:Boolean= false
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener { isSuccessful = true }
                .addOnFailureListener { isSuccessful = false }
                .await()
            isSuccessful
        }catch (e: Exception){
            false
        }
    }
    override suspend fun signup(email: String, password: String): String {
        return try {
            var userUID = ""
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                userUID = it.user?.uid?: ""
            }
            .await()
             userUID
        }catch (e:Exception){
            ""
        }
    }
}
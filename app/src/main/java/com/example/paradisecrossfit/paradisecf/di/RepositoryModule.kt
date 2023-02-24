package com.example.paradisecrossfit.paradisecf.di

import com.example.paradisecrossfit.paradisecf.data.remote.remote.FirebaseAuthRepositoryImpl
import com.example.paradisecrossfit.paradisecf.data.remote.remote.FirestoreUserRepositoryImpl
import com.example.paradisecrossfit.paradisecf.domain.a.repository.AuthRepository
import com.example.paradisecrossfit.paradisecf.domain.a.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//Realizamos en binds de la interface con la implementación
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAuthRepository(authRepository: FirebaseAuthRepositoryImpl): AuthRepository

    @Binds
    abstract fun bindUserRepository(userRepository: FirestoreUserRepositoryImpl): UserRepository
}
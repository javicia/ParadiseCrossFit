package com.example.paradisecrossfit.firebaseyt.di

import com.example.paradisecrossfit.firebaseyt.data.remote.FirebaseAuthRepositoryImpl
import com.example.paradisecrossfit.firebaseyt.domain.a.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn (SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindAuthRepository(authRepository: FirebaseAuthRepositoryImpl):AuthRepository
}
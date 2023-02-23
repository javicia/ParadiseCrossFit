package com.example.paradisecrossfit.firebaseyt.util

sealed class Resource <out R> {

    data class Sucess<out T>(val data: T): Resource<T>()
    data class Error(val message: String): Resource<Nothing>()
    object Loading: Resource<Nothing>()
    object Finished: Resource<Nothing>()
}
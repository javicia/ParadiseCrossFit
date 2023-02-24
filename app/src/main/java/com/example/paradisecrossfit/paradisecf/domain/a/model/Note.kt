package com.example.paradisecrossfit.paradisecf.domain.a.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Note (
    val id: String = UUID.randomUUID().toString(), //Creamos id aleatorio
    val note: String = "",
    val author: String = ""
): Parcelable
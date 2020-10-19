package com.abdelrahman.kotlincleanarch.remote.model

import com.google.gson.annotations.SerializedName


/**
 *@author: Abdel-Rahman El-Shikh on 09-May-20.
 */
data class ApiResponseRemote<T>(
    @SerializedName("data") val data: List<T>,
    @SerializedName("message") val message: String,
    @SerializedName("success") val success: Boolean
)
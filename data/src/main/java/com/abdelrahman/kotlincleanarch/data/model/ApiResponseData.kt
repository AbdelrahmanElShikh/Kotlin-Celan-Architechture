package com.abdelrahman.kotlincleanarch.data.model


/**
 *@author: Abdel-Rahman El-Shikh on 09-May-20.
 */
data class ApiResponseData<T>(
    val data: List<T>,
    val message: String,
    val success: Boolean
)
package com.abdelrahman.kotlincleanarch.presentation.model


/**
 *@author: Abdel-Rahman El-Shikh on 09-May-20.
 */
data class ApiResponseUi<T>(
    val data: List<T>,
    val message: String,
    val success: Boolean
)
package com.abdelrahman.kotlincleanarch.domain.entities


/**
 *@author: Abdel-Rahman El-Shikh on 09-May-20.
 */
data class ApiResponseDomain<T>(
    val data: List<T>,
    val message: String,
    val success: Boolean
)
package com.abdelrahman.kotlincleanarch.presentation.model


/**
 *@author: Abdel-Rahman El-Shikh on 09-May-20.
 */
class ApiError(
    val errorMsg : String?,
    val errorCode : Int?,
    val extras : Map<String,Any>?
)
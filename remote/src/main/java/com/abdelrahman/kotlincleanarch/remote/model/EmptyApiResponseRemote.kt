package com.abdelrahman.kotlincleanarch.remote.model

import com.google.gson.annotations.SerializedName


/**
 *@author: Abdel-Rahman El-Shikh on 11-May-20.
 */
data class EmptyApiResponseRemote(
    @SerializedName("success") val success: Boolean
)
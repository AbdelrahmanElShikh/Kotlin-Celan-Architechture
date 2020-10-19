package com.abdelrahman.kotlincleanarch.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @Author : Abdel-Rahman El-Shikh
 * @Date : 02-Oct-20
 * @Project : com.abdelrahman.kotlincleanarch.remote.model
 */
data class BlogRemote(

    @SerializedName("pk")
    @Expose
    var id: Int,

    @SerializedName("title")
    @Expose
    var title: String,

    @SerializedName("body")
    @Expose
    var body: String,

    @SerializedName("image")
    @Expose
    var image: String,

    @SerializedName("category")
    @Expose
    var category: String
)

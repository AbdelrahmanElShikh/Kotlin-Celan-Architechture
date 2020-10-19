package com.abdelrahman.kotlincleanarch.remote.api

import com.abdelrahman.kotlincleanarch.remote.model.BlogRemote
import retrofit2.Response
import retrofit2.http.GET


/**
 *@author: Abdel-Rahman El-Shikh on 08-May-20.
 */
interface ApiService {

    @GET("blogs")
    suspend fun getBlogs(): Response<List<BlogRemote>>
}
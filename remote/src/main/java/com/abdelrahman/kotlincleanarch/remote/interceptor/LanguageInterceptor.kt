package com.abdelrahman.kotlincleanarch.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.util.*
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 09-May-20.
 */
class LanguageInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Accept-Language", Locale.getDefault().language)
            .build()
        return chain.proceed(request)
    }
}
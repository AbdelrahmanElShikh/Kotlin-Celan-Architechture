package com.abdelrahman.kotlincleanarch.di

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import com.abdelrahman.kotlincleanarch.data.model.BlogData
import com.abdelrahman.kotlincleanarch.data.source.BlogRemoteDataSource
import com.abdelrahman.kotlincleanarch.remote.api.ApiService
import com.abdelrahman.kotlincleanarch.remote.interceptor.LanguageInterceptor
import com.abdelrahman.kotlincleanarch.remote.mapper.Mapper
import com.abdelrahman.kotlincleanarch.remote.mapper.RemoteResourceMapper
import com.abdelrahman.kotlincleanarch.remote.mapper.blog.BlogRemoteToDataMapper
import com.abdelrahman.kotlincleanarch.remote.model.BlogRemote
import com.abdelrahman.kotlincleanarch.remote.source.BlogRemoteDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @Author : Abdel-Rahman El-Shikh
 * @Date : 01-Oct-20
 * @Project : com.abdelrahman.kotlincleanarch.di
 */

@Module
@InstallIn(ApplicationComponent::class)
object RemoteModule {

    @Singleton
    @Provides
    fun provideBlogRemoteMapper(): Mapper<BlogRemote, BlogData> {
        return BlogRemoteToDataMapper()
    }

    @Singleton
    @Provides
    fun bindsBlogRemoteDataSource(
        blogMapper: RemoteResourceMapper<BlogRemote, BlogData>,
        apiService: ApiService
    ): BlogRemoteDataSource {
        return BlogRemoteDataSourceImp(blogMapper, apiService)
    }


    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideOkHttp(languageInterceptor: LanguageInterceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.networkInterceptors().add(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val requestBuilder = chain.request().newBuilder()
                requestBuilder.header("Accept", "application/json")
                return chain.proceed(requestBuilder.build())
            }
        })
        httpClient.addInterceptor(languageInterceptor)
        httpClient.addInterceptor(
            LoggingInterceptor.Builder()
                .setLevel(Level.BODY)
                .log(Log.VERBOSE)
                .build()
        )
        return httpClient.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://open-api.xyz/placeholder/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit.Builder): ApiService = retrofit
        .build()
        .create(ApiService::class.java)
}
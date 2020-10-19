package com.abdelrahman.kotlincleanarch.di

import com.abdelrahman.kotlincleanarch.domain.entities.BlogDomain
import com.abdelrahman.kotlincleanarch.presentation.mapper.Mapper
import com.abdelrahman.kotlincleanarch.presentation.mapper.blogs.BlogUiMapper
import com.abdelrahman.kotlincleanarch.presentation.model.BlogUi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * @author : Abdel-Rahman El-Shikh on Sun , 10/4/2020
 */

@Module
@InstallIn(ApplicationComponent::class)
object PresentationModule {

    @Singleton
    @Provides
    fun provideBlogUiMapper(): Mapper<BlogDomain, BlogUi> {
        return BlogUiMapper()
    }
}
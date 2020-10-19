package com.abdelrahman.kotlincleanarch.di

import com.abdelrahman.kotlincleanarch.data.mapper.DataResourceMapper
import com.abdelrahman.kotlincleanarch.data.mapper.Mapper
import com.abdelrahman.kotlincleanarch.data.mapper.blog.BlogDataToDomainMapper
import com.abdelrahman.kotlincleanarch.data.model.BlogData
import com.abdelrahman.kotlincleanarch.data.repository.BlogRepositoryImp
import com.abdelrahman.kotlincleanarch.data.source.BlogRemoteDataSource
import com.abdelrahman.kotlincleanarch.domain.entities.BlogDomain
import com.abdelrahman.kotlincleanarch.domain.repositories.BlogRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * @Author : Abdel-Rahman El-Shikh
 * @Date : 04-Oct-20
 * @Project : com.abdelrahman.kotlincleanarch.di
 */
@Module
@InstallIn(ApplicationComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideBlogsDataMapper(): Mapper<BlogData, BlogDomain>{
        return BlogDataToDomainMapper()
    }

    @Singleton
    @Provides
    fun provideBlogsReposiotry(
        blogMapper: DataResourceMapper<BlogData, BlogDomain>,
        blogRemoteDataSource: BlogRemoteDataSource
    ): BlogRepository {
        return BlogRepositoryImp(blogMapper, blogRemoteDataSource)
    }
}
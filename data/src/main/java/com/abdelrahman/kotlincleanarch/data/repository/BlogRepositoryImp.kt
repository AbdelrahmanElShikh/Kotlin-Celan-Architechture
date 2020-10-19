package com.abdelrahman.kotlincleanarch.data.repository

import com.abdelrahman.kotlincleanarch.data.mapper.DataResourceMapper
import com.abdelrahman.kotlincleanarch.data.model.BlogData
import com.abdelrahman.kotlincleanarch.data.source.BlogRemoteDataSource
import com.abdelrahman.kotlincleanarch.domain.entities.BlogDomain
import com.abdelrahman.kotlincleanarch.domain.repositories.BlogRepository
import com.abdelrahman.kotlincleanarch.domain.resource.DomainResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author : Abdel-Rahman El-Shikh
 * @Date : 03-Oct-20
 * @Project : com.abdelrahman.kotlincleanarch.data.repository
 */
class BlogRepositoryImp @Inject constructor(
    private val blogMapper: DataResourceMapper<BlogData, BlogDomain>,
    private val blogRemoteDataSource: BlogRemoteDataSource
) : BlogRepository {
    override suspend fun getBlogs(): Flow<DomainResource<List<BlogDomain>>> = flow{
        val blogs = blogRemoteDataSource.getBlogs().map { blogMapper.mapList(it) }
        emitAll(blogs)
    }
//    override suspend fun getBlogs(): Flow<DomainResource<List<BlogDomain>>> = flow{
//        blogRemoteDataSource.getBlogs()
//            .map { blogMapper.mapList(it) }
//    }



}
package com.abdelrahman.kotlincleanarch.domain.repositories

import com.abdelrahman.kotlincleanarch.domain.entities.BlogDomain
import com.abdelrahman.kotlincleanarch.domain.resource.DomainResource
import kotlinx.coroutines.flow.Flow

/**
 * @Author : Abdel-Rahman El-Shikh
 * @Date : 03-Oct-20
 * @Project : com.abdelrahman.kotlincleanarch.domain.repositories
 */
interface BlogRepository {
    suspend fun getBlogs():Flow<DomainResource<List<BlogDomain>>>
}
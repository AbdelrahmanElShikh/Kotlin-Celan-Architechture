package com.abdelrahman.kotlincleanarch.domain.usecase

import com.abdelrahman.kotlincleanarch.domain.entities.BlogDomain
import com.abdelrahman.kotlincleanarch.domain.repositories.BlogRepository
import com.abdelrahman.kotlincleanarch.domain.resource.DomainResource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author : Abdel-Rahman El-Shikh
 * @Date : 03-Oct-20
 * @Project : com.abdelrahman.kotlincleanarch.domain.usecase
 */
class GetBlogsUseCase @Inject constructor(
    private val blogsRepository: BlogRepository
) {
    suspend fun getBlogs():Flow<DomainResource<List<BlogDomain>>>{
        return blogsRepository.getBlogs()
    }
}
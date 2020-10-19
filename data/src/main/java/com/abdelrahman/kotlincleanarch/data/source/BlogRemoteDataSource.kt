package com.abdelrahman.kotlincleanarch.data.source

import com.abdelrahman.kotlincleanarch.data.model.BlogData
import com.abdelrahman.kotlincleanarch.data.resource.DataResource
import kotlinx.coroutines.flow.Flow


/**
 * @Author : Abdel-Rahman El-Shikh
 * @Date : 02-Oct-20
 * @Project : com.abdelrahman.kotlincleanarch.data.source
 */
interface BlogRemoteDataSource {
    suspend fun getBlogs() : Flow<DataResource<List<BlogData>>>
}
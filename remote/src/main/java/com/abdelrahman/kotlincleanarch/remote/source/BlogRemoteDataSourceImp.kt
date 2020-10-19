package com.abdelrahman.kotlincleanarch.remote.source

import com.abdelrahman.kotlincleanarch.data.model.BlogData
import com.abdelrahman.kotlincleanarch.data.resource.DataResource
import com.abdelrahman.kotlincleanarch.data.source.BlogRemoteDataSource
import com.abdelrahman.kotlincleanarch.remote.api.ApiService
import com.abdelrahman.kotlincleanarch.remote.mapper.RemoteResourceMapper
import com.abdelrahman.kotlincleanarch.remote.model.BlogRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * @Author : Abdel-Rahman El-Shikh
 * @Date : 02-Oct-20
 * @Project : com.abdelrahman.kotlincleanarch.remote.source
 */
class BlogRemoteDataSourceImp @Inject constructor(
    private val blogMapper: RemoteResourceMapper<BlogRemote, BlogData>,
    private val apiService: ApiService
) : BlogRemoteDataSource {
    override suspend fun getBlogs(): Flow<DataResource<List<BlogData>>> = flow{
        val response = apiService.getBlogs()
        val blogs = blogMapper.mapList(response)
        emit(blogs)
    }

//    override suspend fun getBlogs(): Flow<DataResource<List<BlogData>>> =
//         flow<Response<List<BlogRemote>>> {
//            apiService.getBlogs()
//        }
//            .map {
//                    blogs ->blogMapper.mapList(blogs)
//
//            }




}
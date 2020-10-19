package com.abdelrahman.kotlincleanarch.remote.mapper

import com.abdelrahman.kotlincleanarch.data.resource.DataResource
import com.abdelrahman.kotlincleanarch.remote.resource.ErrorResponse
import com.google.gson.Gson
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 09-May-20.
 */
class RemoteResourceMapper<IN, OUT> @Inject constructor(
    private val mapper: Mapper<IN, OUT>
) {
    @Throws(IOException::class)
    fun map(response: Response<IN>): DataResource<OUT> {
        return when (response.code()) {
            200 -> DataResource.success(mapper.map(response.body()!!))
            401, 429, 500 -> DataResource.error(
                response.message(),
                response.code(),
                null
            )
            else -> {
                val errorResponse: ErrorResponse =
                    Gson().fromJson(response.errorBody()!!.string(), ErrorResponse::class.java)
                return DataResource.error(
                    errorResponse.errorMsg,
                    response.code(),
                    errorResponse.extras
                )
            }
        }
    }


    fun mapList(response: Response<List<IN>>): DataResource<List<OUT>> {
        return when (response.code()) {
            200 -> DataResource.success(mapper.map(response.body()!!))
            401, 429, 500 -> DataResource.error(
                response.message(),
                response.code(),
                null
            )
            else -> {
                val errorResponse: ErrorResponse =
                    Gson().fromJson(response.errorBody()!!.string(), ErrorResponse::class.java)
                return DataResource.error(
                    errorResponse.errorMsg,
                    response.code(),
                    errorResponse.extras
                )
            }
        }
    }

}
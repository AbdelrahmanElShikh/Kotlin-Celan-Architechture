package com.abdelrahman.kotlincleanarch.data.mapper

import com.abdelrahman.kotlincleanarch.data.model.EmptyApiResponseData
import com.abdelrahman.kotlincleanarch.domain.entities.EmptyApiResponseDomain
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 11-May-20.
 */
class EmptyApiResponseDataMapper @Inject constructor() :
    Mapper<EmptyApiResponseData, EmptyApiResponseDomain>() {
    override fun map(input: EmptyApiResponseData?): EmptyApiResponseDomain {
        return EmptyApiResponseDomain(
            input!!.success
        )
    }
}
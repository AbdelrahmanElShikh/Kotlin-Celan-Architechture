package com.abdelrahman.kotlincleanarch.presentation.mapper

import com.abdelrahman.kotlincleanarch.domain.resource.DomainResource
import com.abdelrahman.kotlincleanarch.presentation.resource.PresentationResource
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 09-May-20.
 */
class PresentationResourceMapper<INPUT,OUTPUT> @Inject constructor(
    private val mapper : Mapper<INPUT,OUTPUT>
) {
    fun map(input : DomainResource<INPUT>): PresentationResource<OUTPUT> {
        return when(input.status){
            DomainResource.Status.SUCCESS -> PresentationResource.success(mapper.map(input.data))
            else -> PresentationResource.apiError(input.message,input.errorCode,input.errorExtras)
        }
    }

    fun mapList(input : DomainResource<List<INPUT>>): PresentationResource<List<OUTPUT>> {
        return when(input.status){
            DomainResource.Status.SUCCESS -> PresentationResource.success(mapper.map(input.data))
            else -> PresentationResource.apiError(input.message,input.errorCode,input.errorExtras)
        }
    }
}
package com.abdelrahman.kotlincleanarch.presentation.mapper

import com.abdelrahman.kotlincleanarch.domain.entities.EmptyApiResponseDomain
import com.abdelrahman.kotlincleanarch.presentation.model.EmptyApiResponseUi
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 11-May-20.
 */
class EmptyApiResponseUiMapper @Inject constructor() :
    Mapper<EmptyApiResponseDomain, EmptyApiResponseUi>() {
    override fun map(input: EmptyApiResponseDomain?): EmptyApiResponseUi {
        return EmptyApiResponseUi(
            input!!.success
        )
    }
}
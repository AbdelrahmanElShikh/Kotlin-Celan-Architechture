package com.abdelrahman.kotlincleanarch.remote.mapper

import com.abdelrahman.kotlincleanarch.data.model.EmptyApiResponseData
import com.abdelrahman.kotlincleanarch.remote.model.EmptyApiResponseRemote
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 11-May-20.
 */
class EmptyApiResponseRemoteMapper @Inject constructor():Mapper<EmptyApiResponseRemote, EmptyApiResponseData>() {
    override fun map(input: EmptyApiResponseRemote): EmptyApiResponseData {
        return EmptyApiResponseData(input.success)
    }
}
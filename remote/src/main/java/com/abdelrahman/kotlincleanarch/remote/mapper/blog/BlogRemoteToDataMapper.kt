package com.abdelrahman.kotlincleanarch.remote.mapper.blog

import com.abdelrahman.kotlincleanarch.data.model.BlogData
import com.abdelrahman.kotlincleanarch.remote.mapper.Mapper
import com.abdelrahman.kotlincleanarch.remote.model.BlogRemote
import javax.inject.Inject

/**
 * @Author : Abdel-Rahman El-Shikh
 * @Date : 02-Oct-20
 * @Project : com.abdelrahman.kotlincleanarch.remote.mapper.blog
 */
class BlogRemoteToDataMapper @Inject constructor() : Mapper<BlogRemote,BlogData>() {
    override fun map(input: BlogRemote): BlogData {
        return BlogData(
            id = input.id,
            body = input.body,
            category =  input.category,
            image =  input.image,
            title = input.title
        )
    }
}
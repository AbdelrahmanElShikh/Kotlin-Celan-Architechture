package com.abdelrahman.kotlincleanarch.data.mapper.blog

import com.abdelrahman.kotlincleanarch.data.mapper.Mapper
import com.abdelrahman.kotlincleanarch.data.model.BlogData
import com.abdelrahman.kotlincleanarch.domain.entities.BlogDomain
import javax.inject.Inject

/**
 * @author : Abdel-Rahman El-Shikh on Sun , 10/4/2020
 */
class BlogDataToDomainMapper @Inject constructor() : Mapper<BlogData, BlogDomain>() {
    override fun map(input: BlogData?): BlogDomain {
        return BlogDomain(
            id = input!!.id,
            title = input.title,
            body = input.body,
            category = input.category,
            image = input.image
        )
    }
}
package com.abdelrahman.kotlincleanarch.presentation.mapper.blogs

import com.abdelrahman.kotlincleanarch.domain.entities.BlogDomain
import com.abdelrahman.kotlincleanarch.presentation.mapper.Mapper
import com.abdelrahman.kotlincleanarch.presentation.model.BlogUi
import javax.inject.Inject

/**
 * @Author : Abdel-Rahman El-Shikh
 * @Date : 04-Oct-20
 * @Project : com.pharmashop.presentation.mapper.blogs
 */
class BlogUiMapper @Inject constructor() : Mapper<BlogDomain, BlogUi>() {
    override fun map(input: BlogDomain?): BlogUi {
        return BlogUi(
            id = input!!.id,
            title = input.title,
            body = input.body,
            category = input.category,
            image = input.image
        )
    }
}
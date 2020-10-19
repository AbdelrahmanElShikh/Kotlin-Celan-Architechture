package com.abdelrahman.kotlincleanarch.domain.entities

/**
 * @Author : Abdel-Rahman El-Shikh
 * @Date : 02-Oct-20
 * @Project : com.abdelrahman.kotlincleanarch.domain.entities
 */
data class BlogDomain (
    var id: Int,
    var title: String,
    var body: String,
    var image: String,
    var category: String
)
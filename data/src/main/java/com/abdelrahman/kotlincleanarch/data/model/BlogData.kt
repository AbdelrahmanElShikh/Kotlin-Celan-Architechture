package com.abdelrahman.kotlincleanarch.data.model

/**
 * @Author : Abdel-Rahman El-Shikh
 * @Date : 02-Oct-20
 * @Project : com.abdelrahman.kotlincleanarch.data.model
 */
data class BlogData(
    var id: Int,
    var title: String,
    var body: String,
    var image: String,
    var category: String
)
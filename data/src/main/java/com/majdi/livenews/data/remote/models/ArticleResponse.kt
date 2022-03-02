package com.majdi.livenews.data.remote.models

import com.squareup.moshi.Json
/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
data class ArticleResponse(
    @field:Json(name = "author") val author: String,
    @field:Json(name = "content") val content: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "publishedAt") val publishedAt: String,
    @field:Json(name = "source") val source: SourceResponse,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "url") val url: String,
    @field:Json(name = "urlToImage") val urlToImage: String
)
package com.majdi.livenews.data.remote.models

import com.squareup.moshi.Json
/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
data class NewsResponse(
    @field:Json(name = "articles") val articles: List<ArticleResponse>,
    @field:Json(name = "status") val status: String,
    @field:Json(name = "totalResults") val totalResults: Int
)
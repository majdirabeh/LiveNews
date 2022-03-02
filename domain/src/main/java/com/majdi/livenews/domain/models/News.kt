package com.majdi.livenews.domain.models
/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
data class News(val articles: List<Article>, val status: String, val totalResults: Int)
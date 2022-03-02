package com.majdi.livenews.data.remote.api

import com.majdi.livenews.data.remote.models.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
interface NewsApi {

    @GET("top-headlines")
    suspend fun getNews(@Query("country") lang: String,
                        @Query("apiKey") params: String): NewsResponse

}
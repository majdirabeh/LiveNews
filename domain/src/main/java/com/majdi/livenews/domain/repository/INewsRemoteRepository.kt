package com.majdi.livenews.domain.repository

import com.majdi.livenews.domain.models.News
import kotlinx.coroutines.flow.Flow
/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
interface INewsRemoteRepository {
    suspend fun getAllRemoteNews(apiKey: String, lang: String): Flow<News>
}
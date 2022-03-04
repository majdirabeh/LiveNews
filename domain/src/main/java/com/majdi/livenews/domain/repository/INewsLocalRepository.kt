package com.majdi.livenews.domain.repository

import com.majdi.livenews.domain.models.Article
import com.majdi.livenews.domain.models.News
import kotlinx.coroutines.flow.Flow
/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
interface INewsLocalRepository {
    suspend fun getAllLocalNews(): Flow<List<Article>>
    suspend fun insertNew(articles: List<Article>): Flow<Boolean>
    suspend fun deleteNews(): Flow<Int>
}
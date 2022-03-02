package com.majdi.livenews.data.local.repository

import com.majdi.livenews.data.local.dao.ArticleDao
import com.majdi.livenews.data.local.mappers.toDomain
import com.majdi.livenews.domain.models.Article
import com.majdi.livenews.domain.models.News
import com.majdi.livenews.domain.repository.INewsLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
class LocalNewsRepository(private val articleDao: ArticleDao) : INewsLocalRepository {

    override suspend fun getAllLocalNews(): Flow<List<Article>> = flow {
        val articlesEntity = articleDao.getAll()
        val articles = mutableListOf<Article>()
        for (articleEntity in articlesEntity) {
            //val source = articleEntity.source.toDomain()
            val article = articleEntity.toDomain()
            articles.add(article)
        }
    }

    override suspend fun insertNew(news: News): Flow<Long> = flow {
        val result = articleDao.insert(news)
        emit(result)
    }

    override suspend fun deleteNews(): Flow<Int> = flow {
        val result = articleDao.deleteAll()
        emit(result)
    }


}
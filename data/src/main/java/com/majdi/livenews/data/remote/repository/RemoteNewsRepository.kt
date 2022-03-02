package com.majdi.livenews.data.remote.repository

import com.majdi.livenews.data.remote.api.NewsApi
import com.majdi.livenews.data.remote.mappers.toDomain
import com.majdi.livenews.domain.models.Article
import com.majdi.livenews.domain.models.News
import com.majdi.livenews.domain.repository.INewsLocalRepository
import com.majdi.livenews.domain.repository.INewsRemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
class RemoteNewsRepository(private val newsApi: NewsApi) : INewsRemoteRepository {

    override suspend fun getAllRemoteNews(apiKey: String, lang: String): Flow<News> = flow {
        val newsResponse = newsApi.getNews(apiKey, lang)
        val listArticle = mutableListOf<Article>()
        for (article in newsResponse.articles) {
            val articleDomain = article.toDomain(article.source.toDomain())
            listArticle.add(articleDomain)
        }
        emit(newsResponse.toDomain(listArticle))
    }

}
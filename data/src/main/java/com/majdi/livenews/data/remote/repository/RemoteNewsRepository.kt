package com.majdi.livenews.data.remote.repository

import com.majdi.livenews.data.remote.api.NewsApi
import com.majdi.livenews.data.remote.mappers.toDomain
import com.majdi.livenews.domain.models.ApiState
import com.majdi.livenews.domain.models.Article
import com.majdi.livenews.domain.models.News
import com.majdi.livenews.domain.models.Params
import com.majdi.livenews.domain.repository.INewsRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber

/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
class RemoteNewsRepository(private val newsApi: NewsApi) : INewsRemoteRepository {
    override suspend fun getAllRemoteNews(params: Params): Flow<ApiState<List<Article>>> = flow {
        // get the Data from the api
        val newsResponse = newsApi.getNews(params.apiKey, params.lang)
        val listArticle = mutableListOf<Article>()
        for (article in newsResponse.articles) {
            Timber.e("Article ==> $article")
            val articleDomain = article.toDomain(article.source.toDomain())
            listArticle.add(articleDomain)
        }
        // Emit this data wrapped in
        emit(ApiState.success(listArticle))
    }.flowOn(Dispatchers.IO)


}
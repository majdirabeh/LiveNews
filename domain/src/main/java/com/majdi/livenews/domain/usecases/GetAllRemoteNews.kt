package com.majdi.livenews.domain.usecases

import com.majdi.livenews.domain.models.Article
import com.majdi.livenews.domain.models.News
import com.majdi.livenews.domain.repository.INewsLocalRepository
import com.majdi.livenews.domain.repository.INewsRemoteRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
typealias GetAllRemoteNewsBase = BaseUseCase<Unit, Flow<News>>

class GetAllRemoteNews(
    private val newsRepository: INewsRemoteRepository,
    private val apiKey: String,
    private val lang: String
) : GetAllRemoteNewsBase {
    override suspend fun invoke(params: Unit) = newsRepository.getAllRemoteNews(apiKey, lang)
}
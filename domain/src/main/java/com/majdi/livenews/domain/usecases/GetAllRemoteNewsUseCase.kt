package com.majdi.livenews.domain.usecases

import com.majdi.livenews.domain.models.ApiState
import com.majdi.livenews.domain.models.Article
import com.majdi.livenews.domain.models.News
import com.majdi.livenews.domain.models.Params
import com.majdi.livenews.domain.repository.INewsRemoteRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
typealias GetAllRemoteNewsBase = BaseUseCase<Params, Flow<ApiState<List<Article>>>>

class GetAllRemoteNewsUseCase(
    private val newsRepository: INewsRemoteRepository) : GetAllRemoteNewsBase {
    override suspend operator fun invoke(params: Params): Flow<ApiState<List<Article>>> =
        newsRepository.getAllRemoteNews(params)

}
package com.majdi.livenews.domain.usecases

import com.majdi.livenews.domain.models.Article
import com.majdi.livenews.domain.models.News
import com.majdi.livenews.domain.repository.INewsLocalRepository
import kotlinx.coroutines.flow.Flow
/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
typealias GetAllLocalNewsBase = BaseUseCase<Unit, Flow<List<Article>>>

class GetAllLocalNews(
    private val newsRepository: INewsLocalRepository
) : GetAllLocalNewsBase {
    override suspend fun invoke(params: Unit) = newsRepository.getAllLocalNews()
}
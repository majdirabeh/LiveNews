package com.majdi.livenews.domain.usecases

import com.majdi.livenews.domain.models.News
import com.majdi.livenews.domain.repository.INewsLocalRepository
import kotlinx.coroutines.flow.Flow
/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
typealias InsertNewsBase = BaseUseCase<Unit, Flow<Long>>

class InsertNews(
    private val newsRepository: INewsLocalRepository,
    private val news: News
) : InsertNewsBase {
    override suspend fun invoke(params: Unit): Flow<Long> = newsRepository.insertNew(news)
}
package com.majdi.livenews.domain.usecases

import com.majdi.livenews.domain.models.Article
import com.majdi.livenews.domain.models.News
import com.majdi.livenews.domain.repository.INewsLocalRepository
import kotlinx.coroutines.flow.Flow
/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
typealias InsertNewsBase = BaseUseCase<List<Article>, Flow<Boolean>>

class InsertNewsUseCase(
    private val newsRepository: INewsLocalRepository
) : InsertNewsBase {
    override suspend operator fun invoke(articles: List<Article>): Flow<Boolean> = newsRepository.insertNew(articles)
}
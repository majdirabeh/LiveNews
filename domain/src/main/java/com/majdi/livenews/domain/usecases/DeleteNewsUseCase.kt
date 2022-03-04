package com.majdi.livenews.domain.usecases

import com.majdi.livenews.domain.models.News
import com.majdi.livenews.domain.repository.INewsLocalRepository
import kotlinx.coroutines.flow.Flow
/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
typealias DeleteNewsBase = BaseUseCase<Unit, Flow<Int>>

class DeleteNewsUseCase(
    private val newsRepository: INewsLocalRepository
) : DeleteNewsBase {
    override suspend operator fun invoke(params: Unit): Flow<Int> = newsRepository.deleteNews()
}
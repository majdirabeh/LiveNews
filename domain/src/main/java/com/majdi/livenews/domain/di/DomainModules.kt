package com.majdi.livenews.domain.di

import com.majdi.livenews.domain.models.News
import com.majdi.livenews.domain.repository.INewsLocalRepository
import com.majdi.livenews.domain.repository.INewsRemoteRepository
import com.majdi.livenews.domain.usecases.*
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
val DomainModules = module {
    single(named("GetAllRemoteNews")) {
        provideGetAllRemoteNewsUseCase(get(), get(), get())
    }

    single(named("GetAllLocalNews")) {
        provideGetAllLocalNewsUseCase(get())
    }
    single(named("DeleteAllNews")) {
        provideDeleteUseCase(get())
    }
    single(named("InsertNews")) {
        provideInsertUseCase(get(), get())
    }
}

fun provideGetAllRemoteNewsUseCase(
    newRepository: INewsRemoteRepository,
    apiKey: String,
    lang: String
): GetAllRemoteNewsBase {
    return GetAllRemoteNews(newRepository, apiKey, lang)
}

fun provideGetAllLocalNewsUseCase(
    newRepository: INewsLocalRepository
): GetAllLocalNewsBase {
    return GetAllLocalNews(newRepository)
}

fun provideDeleteUseCase(
    newRepository: INewsLocalRepository
): DeleteNewsBase {
    return DeleteNews(newRepository)
}

fun provideInsertUseCase(
    newRepository: INewsLocalRepository, news: News
): InsertNewsBase {
    return InsertNews(newRepository, news)
}
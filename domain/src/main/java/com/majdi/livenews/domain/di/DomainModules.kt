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
    single(named("GetAllRemoteNewsUseCase")) {
        provideGetAllRemoteNewsUseCase(get())
    }

    single(named("GetAllLocalNewsUseCase")) {
        provideGetAllLocalNewsUseCase(get())
    }
    single(named("DeleteAllNewsUseCase")) {
        provideDeleteUseCase(get())
    }
    single(named("InsertNewsUseCase")) {
        provideInsertUseCase(get())
    }
}

fun provideGetAllRemoteNewsUseCase(
    newRepository: INewsRemoteRepository
): GetAllRemoteNewsBase {
    return GetAllRemoteNewsUseCase(newRepository)
}

fun provideGetAllLocalNewsUseCase(
    newRepository: INewsLocalRepository
): GetAllLocalNewsBase {
    return GetAllLocalNewsUseCase(newRepository)
}

fun provideDeleteUseCase(
    newRepository: INewsLocalRepository
): DeleteNewsBase {
    return DeleteNewsUseCase(newRepository)
}

fun provideInsertUseCase(
    newRepository: INewsLocalRepository
): InsertNewsBase {
    return InsertNewsUseCase(newRepository)
}
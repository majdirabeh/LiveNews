package com.majdi.livenews.data.remote.di

import com.majdi.livenews.data.remote.repository.RemoteNewsRepository
import com.majdi.livenews.domain.repository.INewsRemoteRepository
import org.koin.dsl.module

/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
val DataRemoteModules = module {
    single<INewsRemoteRepository> { RemoteNewsRepository(newsApi = get()) }
}

package com.majdi.livenews.data.local.di

import androidx.room.Room
import com.majdi.livenews.data.local.dao.ArticleDao
import com.majdi.livenews.data.local.db.DataBaseConfig
import com.majdi.livenews.data.local.repository.LocalNewsRepository
import com.majdi.livenews.domain.repository.INewsLocalRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */

val DataLocalModules = module {
    single { provideArticleDao(db = get()) }
    single {
        Room.databaseBuilder(
            androidContext(),
            DataBaseConfig::class.java, "news_db"
        ).build()
    }
    single<INewsLocalRepository> { LocalNewsRepository(articleDao = get()) }
}

internal fun provideArticleDao(db: DataBaseConfig): ArticleDao = db.articleDao()
package com.majdi.livenews.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.majdi.livenews.data.local.dao.ArticleDao
import com.majdi.livenews.data.local.models.ArticleEntity


@Database(entities = [ArticleEntity::class], version = 1, exportSchema = false)
abstract class DataBaseConfig : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}
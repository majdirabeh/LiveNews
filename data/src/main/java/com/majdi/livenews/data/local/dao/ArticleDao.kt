package com.majdi.livenews.data.local.dao

import androidx.room.*
import com.majdi.livenews.data.local.mappers.toEntity
import com.majdi.livenews.data.local.models.ArticleEntity
import com.majdi.livenews.domain.models.Article
import com.majdi.livenews.domain.models.News

/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
@Dao
interface ArticleDao {

    @Transaction
    @Query("DELETE FROM article")
    fun deleteAll(): Int

    @Transaction
    @Query("SELECT * FROM article")
    fun getAll(): List<ArticleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(articleEntity: ArticleEntity): Long

    @Transaction
    fun insert(articles: List<Article>): Boolean {
        deleteAll()
        for (article in articles) {
            val articleEntity = article.toEntity()
            insert(articleEntity)
            return true
        }
        return false
    }

}
package com.majdi.livenews.data.local.mappers

import com.majdi.livenews.data.local.models.ArticleEntity
import com.majdi.livenews.domain.models.Article
import com.majdi.livenews.domain.models.Source

/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */

internal fun ArticleEntity.toDomain(): Article {
    return Article(
        author = author,
        content = content,
        description = description,
        publishedAt = publishedAt,
        title = title,
        url = url,
        urlToImage = urlToImage,
        source = null
    )
}
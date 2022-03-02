package com.majdi.livenews.data.local.mappers

import com.majdi.livenews.data.local.models.ArticleEntity
import com.majdi.livenews.domain.models.Article

/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */

//internal fun Source.toEntity(): SourceEntity {
//    return SourceEntity(id = id, name = name)
//}

internal fun Article.toEntity(): ArticleEntity {
    return ArticleEntity(
        author = author,
        content = content,
        description = description,
        publishedAt = publishedAt,
        title = title,
        url = url,
        urlToImage = urlToImage
    )
}
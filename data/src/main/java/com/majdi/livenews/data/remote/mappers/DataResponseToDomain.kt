package com.majdi.livenews.data.remote.mappers

import com.majdi.livenews.data.remote.models.ArticleResponse
import com.majdi.livenews.data.remote.models.NewsResponse
import com.majdi.livenews.data.remote.models.SourceResponse
import com.majdi.livenews.domain.models.Article
import com.majdi.livenews.domain.models.News
import com.majdi.livenews.domain.models.Source
/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
internal fun NewsResponse.toDomain(articles: List<Article>): News {
    return News(articles, this.status, this.totalResults)
}

internal fun SourceResponse.toDomain(): Source {
    return Source(this.id, this.name)
}

internal fun ArticleResponse.toDomain(source: Source): Article {
    return Article(
        this.author,
        this.content,
        this.description,
        this.publishedAt,
        source,
        this.title,
        this.url,
        this.urlToImage
    )
}

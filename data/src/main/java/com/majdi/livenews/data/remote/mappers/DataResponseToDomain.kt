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
    return News(articles, this.status.orEmpty(), this.totalResults)
}

internal fun SourceResponse.toDomain(): Source {
    return Source(this.id.orEmpty(), this.name.toString())
}

internal fun ArticleResponse.toDomain(source: Source): Article {
    return Article(
        author = author.orEmpty(),
        this.content.orEmpty(),
        this.description.orEmpty(),
        this.publishedAt.orEmpty(),
        source,
        this.title.orEmpty(),
        this.url.orEmpty(),
        this.urlToImage.orEmpty()
    )
}

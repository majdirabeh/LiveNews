package fr.com.tn.majdi.livenews.mappers

import com.majdi.livenews.domain.models.Article
import com.majdi.livenews.domain.models.News
import com.majdi.livenews.domain.models.Source
import fr.com.tn.majdi.livenews.models.ArticlePresentation
import fr.com.tn.majdi.livenews.models.NewsPresentation
import fr.com.tn.majdi.livenews.models.SourcePresentation

/**
 * Created by Majdi RABEH on 29/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */

internal fun NewsPresentation.toDomain(): News {
    return News(
        articlesDomain(articles),
        status,
        totalResults
    )
}

internal fun articlesDomain(articles: List<ArticlePresentation>): List<Article> {
    val articlesDomain = mutableListOf<Article>()
    for (article in articles) {
        articlesDomain.add(article.toDomain())
    }
    return articlesDomain
}

internal fun ArticlePresentation.toDomain(): Article {
    return Article(
        author.orEmpty(),
        content.orEmpty(),
        description.orEmpty(),
        publishedAt.orEmpty(),
        source.toDomain(),
        title.orEmpty(),
        url.orEmpty(),
        urlToImage.orEmpty()
    )
}

internal fun SourcePresentation.toDomain(): Source {
    return Source(id, name)
}
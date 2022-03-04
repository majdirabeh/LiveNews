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

internal fun News.toPresentation(): NewsPresentation {
    return NewsPresentation(
        articlesPresentation(articles.orEmpty()),
        status.orEmpty(),
        totalResults
    )
}

internal fun articlesPresentation(articles: List<Article>): List<ArticlePresentation> {
    val articlesPresentation = mutableListOf<ArticlePresentation>()
    for (article in articles) {
        articlesPresentation.add(article.toPresentation())
    }
    return articlesPresentation
}

internal fun Article.toPresentation(): ArticlePresentation {
    return ArticlePresentation(
        author.orEmpty(),
        content.orEmpty(),
        description.orEmpty(),
        publishedAt.orEmpty(),
        source!!.toPresentation(),
        title.orEmpty(),
        url.orEmpty(),
        urlToImage.orEmpty()
    )
}

internal fun Source.toPresentation(): SourcePresentation {
    return SourcePresentation(id.orEmpty(), name.orEmpty())
}
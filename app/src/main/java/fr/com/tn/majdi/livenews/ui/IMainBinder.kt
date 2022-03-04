package fr.com.tn.majdi.livenews.ui

import fr.com.tn.majdi.livenews.models.ArticlePresentation

/**
 * Created by Majdi RABEH on 03/03/2022.
 * Email : m.rabeh.majdi@gmail.com
 */
internal interface IMainBinder {
    fun bindNews(articles: List<ArticlePresentation>)
}
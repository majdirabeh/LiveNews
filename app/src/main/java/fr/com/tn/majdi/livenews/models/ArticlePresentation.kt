package fr.com.tn.majdi.livenews.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Majdi RABEH on 29/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
@Parcelize
data class ArticlePresentation(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: SourcePresentation,
    val title: String,
    val url: String,
    val urlToImage: String
): Parcelable
package fr.com.tn.majdi.livenews.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Majdi RABEH on 29/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
@Parcelize
data class NewsPresentation(
    val articles: List<ArticlePresentation>,
    val status: String,
    val totalResults: Int
): Parcelable
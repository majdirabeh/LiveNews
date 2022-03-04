package fr.com.tn.majdi.livenews.adapters

import fr.com.tn.majdi.livenews.R
import fr.com.tn.majdi.livenews.models.ArticlePresentation
import me.ibrahimyilmaz.kiel.adapterOf

/**
 * Created by Majdi RABEH on 03/03/2022.
 * Email : m.rabeh.majdi@gmail.com
 */
internal fun createArticleAdapter() = adapterOf<ArticlePresentation> {
    diff(
        areItemsTheSame = { old, new -> old === new },
        areContentsTheSame = { old, new -> old.title == new.title }
    )
    register(
        layoutResource = R.layout.new_row,
        viewHolder = ::ArticleViewHolder,
        onBindViewHolder = { viewHolder, _, presentation ->
            viewHolder.binding.article = presentation
        }
    )
}
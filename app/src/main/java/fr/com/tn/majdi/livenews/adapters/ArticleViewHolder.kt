package fr.com.tn.majdi.livenews.adapters

import android.icu.number.NumberFormatter.with
import android.view.View
import com.squareup.picasso.Picasso
import fr.com.tn.majdi.livenews.R
import fr.com.tn.majdi.livenews.databinding.NewRowBinding
import fr.com.tn.majdi.livenews.models.ArticlePresentation
import me.ibrahimyilmaz.kiel.core.RecyclerViewHolder

/**
 * Created by Majdi RABEH on 03/03/2022.
 * Email : m.rabeh.majdi@gmail.com
 */
internal class ArticleViewHolder(view: View) : RecyclerViewHolder<ArticlePresentation>(view) {
    val binding = NewRowBinding.bind(view)
    override fun bind(position: Int, item: ArticlePresentation) {
        super.bind(position, item)
        Picasso.get().load(item.urlToImage).into(binding.image)
        binding.executePendingBindings()
    }
}
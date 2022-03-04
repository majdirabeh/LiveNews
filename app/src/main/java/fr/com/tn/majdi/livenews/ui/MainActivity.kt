package fr.com.tn.majdi.livenews.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.majdi.livenews.domain.models.Params
import com.majdi.livenews.domain.models.Status
import fr.com.tn.majdi.livenews.R
import fr.com.tn.majdi.livenews.adapters.createArticleAdapter
import fr.com.tn.majdi.livenews.base.BaseActivity
import fr.com.tn.majdi.livenews.commons.Constants
import fr.com.tn.majdi.livenews.databinding.ActivityMainBinding
import fr.com.tn.majdi.livenews.mappers.toPresentation
import fr.com.tn.majdi.livenews.models.ArticlePresentation
import fr.com.tn.majdi.livenews.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

/**
 * Created by Majdi RABEH on 27/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
internal class MainActivity : BaseActivity(), IMainBinder {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModel<MainViewModel>()
    private val articlesAdapter = createArticleAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val params = Params(Constants.APIKEY, Constants.LANG)
        observeNetworkChanges(params)
        getRemoteArticles(params)

        binding.save.setOnClickListener {
            getLocalArticles()
        }
    }

    private fun getRemoteArticles(params: Params) {
        mainViewModel.getRemoteNews(params)
        lifecycleScope.launch {
            mainViewModel.apiState.collect {
                when (it.status) {
                    Status.LOADING -> {
                        binding.progress.isVisible = true
                    }
                    Status.SUCCESS -> {
                        binding.progress.isVisible = false
                        it.data?.let { news ->
                            val articles = arrayListOf<ArticlePresentation>()
                            for (article in news) {
                                articles.add(article.toPresentation())
                            }
                            bindNews(articles)
                        }
                    }
                    else -> {
                        binding.progress.isVisible = false
                        Toast.makeText(this@MainActivity, "${it.message}", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }


    private fun observeNetworkChanges(params: Params) {
        onNetworkChange { isConnected ->
            if (isConnected) {
                getRemoteArticles(params)
            } else {
                getLocalArticles()
            }
        }
    }

    private fun getLocalArticles() {
        mainViewModel.getLocalArticles()
        lifecycleScope.launch {
            mainViewModel.apiState.collect {
                when (it.status) {
                    Status.LOADING -> {
                        binding.progress.isVisible = true
                    }
                    Status.SUCCESS -> {
                        binding.progress.isVisible = false
                        it.data?.let { localArticles ->
                            val articles = arrayListOf<ArticlePresentation>()
                            for (article in localArticles) {
                                articles.add(article.toPresentation())
                            }
                            bindNews(articles)
                        }
                    }
                    else -> {
                        binding.progress.isVisible = false
                        Toast.makeText(this@MainActivity, "${it.message}", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }

    }

    override fun bindNews(articles: List<ArticlePresentation>) {
        Timber.e("Total Article %s ", articles.size)
        articles.let {
            with(binding.recyclerView) {
                binding.recyclerView.apply {
                    adapter = articlesAdapter.apply { submitList(it) }
                }
            }
        }
    }

}
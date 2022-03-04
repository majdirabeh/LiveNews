package fr.com.tn.majdi.livenews.viewmodel

import androidx.lifecycle.viewModelScope
import com.majdi.livenews.domain.models.*
import com.majdi.livenews.domain.usecases.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by Majdi RABEH on 29/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
internal class MainViewModel(
    private val getAllRemoteNewsBase: GetAllRemoteNewsBase,
    private val getAllLocalNewsBase: GetAllLocalNewsBase,
    private val insertNewsBase: InsertNewsBase,
    private val deleteNewsBase: DeleteNewsBase

) : BaseViewModel() {

    private val listArticle = mutableListOf<Article>()

    val apiState = MutableStateFlow(
        ApiState(
            Status.LOADING,
            listArticle,
            ""
        )
    )

    /**
     * Get News From Api Rest
     */
    fun getRemoteNews(params: Params) {
        // initial value to loading state
        apiState.value = ApiState.loading()
        viewModelScope.launch(Dispatchers.IO) {
            getAllRemoteNewsBase(params).catch {
                apiState.value = ApiState.error(it.message.toString())
            }.collect {
                listArticle.addAll(it.data!!)
                apiState.value = ApiState.success(listArticle)
                insertArticles(listArticle)
            }
        }
    }

    fun insertArticles(articles: List<Article>) {
        deleteAllArticle()
        viewModelScope.launch(Dispatchers.IO) {
            insertNewsBase(articles)
        }
    }

    fun deleteAllArticle() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteNewsBase(Unit)
        }
    }

    fun getLocalArticles() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllLocalNewsBase(Unit).catch {
                apiState.value = ApiState.error(it.message.toString())
            }.collect {
                listArticle.addAll(it)
                apiState.value = ApiState.success(listArticle)
            }
        }
    }
}
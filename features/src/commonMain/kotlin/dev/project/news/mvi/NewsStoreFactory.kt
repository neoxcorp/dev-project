package dev.project.news.mvi

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import dev.project.news.di.NEWS_STORE_NAME
import dev.project.news.mvi.NewsStore.NewsIntent
import dev.project.news.mvi.NewsStore.NewsLabel
import dev.project.news.mvi.NewsStore.NewsState

class NewsStoreFactory(
    private val storeFactory: StoreFactory,
) {
    internal fun create(): NewsStore =
        object :
            NewsStore,
            Store<NewsIntent, NewsState, NewsLabel> by storeFactory.create(
                name = NEWS_STORE_NAME,
                initialState = NewsState.Idle,
                bootstrapper = NewsBootstrapper(),
                executorFactory = ::NewsExecutor,
                reducer = NewsReducer,
            ) {
        }
}

package dev.project.news.mvi

import com.arkivanov.mvikotlin.core.store.Reducer
import dev.project.news.mvi.NewsStore.NewsState

internal object NewsReducer : Reducer<NewsState, NewsMsg> {
    override fun NewsState.reduce(msg: NewsMsg): NewsState =
        when (msg) {
            is NewsMsg.Loading -> NewsState.Loading
            is NewsMsg.Finish -> NewsState.Loaded
            is NewsMsg.Initialized -> NewsState.Initialized
        }
}

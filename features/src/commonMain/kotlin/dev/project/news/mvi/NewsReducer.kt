package dev.project.news.mvi

import com.arkivanov.mvikotlin.core.store.Reducer
import dev.project.news.mvi.NewsStore.NewsState

internal object NewsReducer : Reducer<NewsState, NewsMsg> {
    override fun NewsState.reduce(msg: NewsMsg): NewsState =
        when (msg) {
            is NewsMsg.Idle -> NewsState.Idle
            is NewsMsg.Loading -> NewsState.Loading
            is NewsMsg.Loaded -> NewsState.Loaded(loadedData = msg.data)
            is NewsMsg.Error -> NewsState.Error(error = msg.error)
        }
}

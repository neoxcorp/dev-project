package dev.project.news.mvi

import com.arkivanov.mvikotlin.core.store.Store
import dev.project.news.mvi.NewsStore.NewsIntent
import dev.project.news.mvi.NewsStore.NewsLabel
import dev.project.news.mvi.NewsStore.NewsState

internal interface NewsStore : Store<NewsIntent, NewsState, NewsLabel> {
    sealed interface NewsIntent {
        data object Loading : NewsIntent

        data object Finish : NewsIntent
    }

    sealed interface NewsLabel {
        data object Idle : NewsLabel

        data object OpenNews : NewsLabel
    }

    sealed interface NewsState {
        data object Idle : NewsState

        data object Initialized : NewsState

        data object Loading : NewsState

        data object Loaded : NewsState
    }
}

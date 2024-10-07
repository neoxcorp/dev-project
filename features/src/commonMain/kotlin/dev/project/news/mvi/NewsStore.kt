package dev.project.news.mvi

import com.arkivanov.mvikotlin.core.store.Store
import dev.project.news.mvi.NewsStore.NewsIntent
import dev.project.news.mvi.NewsStore.NewsLabel
import dev.project.news.mvi.NewsStore.NewsState

internal interface NewsStore : Store<NewsIntent, NewsState, NewsLabel> {
    sealed interface NewsIntent {
        data object LoadAgain : NewsIntent

        data class Log(
            val log: String,
        ) : NewsIntent
    }

    sealed interface NewsLabel {
        data class PrintLog(
            val log: String,
        ) : NewsLabel
    }

    sealed interface NewsState {
        data object Idle : NewsState

        data object Loading : NewsState

        data class Loaded(
            val loadedData: String = "",
        ) : NewsState

        data class Error(
            val error: String = "",
        ) : NewsState
    }
}

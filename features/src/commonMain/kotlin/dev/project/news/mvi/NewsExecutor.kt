package dev.project.news.mvi

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import dev.project.news.mvi.NewsStore.NewsIntent
import dev.project.news.mvi.NewsStore.NewsIntent.Finish
import dev.project.news.mvi.NewsStore.NewsIntent.Loading
import dev.project.news.mvi.NewsStore.NewsLabel
import dev.project.news.mvi.NewsStore.NewsLabel.OpenNews
import dev.project.news.mvi.NewsStore.NewsState

internal class NewsExecutor : CoroutineExecutor<NewsIntent, NewsAction, NewsState, NewsMsg, NewsLabel>() {
    override fun executeIntent(intent: NewsIntent) =
        when (intent) {
            is Loading -> dispatch(NewsMsg.Loading)
            is Finish -> dispatch(NewsMsg.Finish)
        }

    override fun executeAction(action: NewsAction) {
        when (action) {
            is NewsAction.Init -> dispatch(NewsMsg.Loading)
            is NewsAction.Initialized -> {
                dispatch(NewsMsg.Finish)
                dispatch(NewsMsg.Initialized)
                publish(OpenNews)
            }
        }
    }
}

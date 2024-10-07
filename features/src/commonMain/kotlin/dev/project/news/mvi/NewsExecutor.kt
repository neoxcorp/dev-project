package dev.project.news.mvi

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import dev.project.news.mvi.NewsStore.NewsIntent
import dev.project.news.mvi.NewsStore.NewsIntent.Log
import dev.project.news.mvi.NewsStore.NewsLabel
import dev.project.news.mvi.NewsStore.NewsState
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class NewsExecutor(
    private val client: HttpClient = HttpClient(),
) : CoroutineExecutor<NewsIntent, NewsAction, NewsState, NewsMsg, NewsLabel>() {
    override fun executeIntent(intent: NewsIntent) =
        when (intent) {
            is Log -> publish(NewsLabel.PrintLog(intent.log))
            is NewsIntent.LoadAgain -> executeAction(NewsAction.Load)
        }

    override fun executeAction(action: NewsAction) {
        when (action) {
            is NewsAction.Load -> {
                dispatch(NewsMsg.Loading)
                scope.launch {
                    withContext(Dispatchers.IO) {
                        try {
//                            delay(200)
//                            throw RuntimeException("test of handling exceptions")
                            delay(2000)
                            val data = client.get("https://ktor.io/docs/").bodyAsText()
                            withContext(Dispatchers.Main) {
                                dispatch(NewsMsg.Loaded(data = data))
                            }
                        } catch (e: Exception) {
                            withContext(Dispatchers.Main) {
                                dispatch(NewsMsg.Error(e.toString()))
                                publish(NewsLabel.PrintLog(e.toString()))
                            }
                        }
                    }
                }
            }
        }
    }
}

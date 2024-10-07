package dev.project.news.mvi

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineBootstrapper
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class NewsBootstrapper : CoroutineBootstrapper<NewsAction>() {
    override fun invoke() {
        scope.launch {
            dispatch(NewsAction.Init)
            delay(500)
            dispatch(NewsAction.Initialized)
        }
    }
}

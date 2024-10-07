package dev.project.news.mvi

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineBootstrapper
import io.ktor.client.request.get

internal class NewsBootstrapper : CoroutineBootstrapper<NewsAction>() {
    override fun invoke() {
//        dispatch(NewsAction.Load)
    }
}

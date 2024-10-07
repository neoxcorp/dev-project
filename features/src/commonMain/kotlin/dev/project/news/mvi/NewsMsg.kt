package dev.project.news.mvi

internal sealed interface NewsMsg {
    data object Loading : NewsMsg

    data object Finish : NewsMsg

    data object Initialized : NewsMsg
}

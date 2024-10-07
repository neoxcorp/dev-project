package dev.project.news.mvi

internal sealed interface NewsMsg {
    data object Idle : NewsMsg

    data object Loading : NewsMsg

    data class Loaded(
        val data: String,
    ) : NewsMsg

    data class Error(
        val error: String,
    ) : NewsMsg
}

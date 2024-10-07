package dev.project.news.mvi

internal sealed interface NewsAction {
    data object Init : NewsAction

    data object Initialized : NewsAction
}

package dev.project.news.mvi

internal sealed interface NewsAction {
    data object Load : NewsAction
}

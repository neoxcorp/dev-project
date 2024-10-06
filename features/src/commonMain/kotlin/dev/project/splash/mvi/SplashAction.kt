package dev.project.splash.mvi

internal sealed interface SplashAction {
    data object Init : SplashAction

    data object Initialized : SplashAction
}

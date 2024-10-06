package dev.project.splash.mvi

internal sealed interface SplashMsg {
    data object Loading : SplashMsg

    data object Finish : SplashMsg

    data object Initialized : SplashMsg
}

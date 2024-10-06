package dev.project.splash.mvi

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineBootstrapper
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class SplashBootstrapper : CoroutineBootstrapper<SplashAction>() {
    override fun invoke() {
        scope.launch {
            dispatch(SplashAction.Init)
            delay(500)
            dispatch(SplashAction.Initialized)
        }
    }
}

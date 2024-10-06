package dev.project.splash.mvi

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import dev.project.splash.mvi.SplashStore.SplashIntent
import dev.project.splash.mvi.SplashStore.SplashIntent.Finish
import dev.project.splash.mvi.SplashStore.SplashIntent.Loading
import dev.project.splash.mvi.SplashStore.SplashLabel
import dev.project.splash.mvi.SplashStore.SplashState

internal class SplashExecutor : CoroutineExecutor<SplashIntent, SplashAction, SplashState, SplashMsg, SplashLabel>() {
    override fun executeIntent(intent: SplashIntent) =
        when (intent) {
            is Loading -> {
                println("SplashStore.SplashIntent executeIntent $intent")
                dispatch(SplashMsg.Loading)
            }

            is Finish -> {
                println("SplashStore.SplashIntent executeIntent $intent")
                dispatch(SplashMsg.Finish)
            }
        }

    override fun executeAction(action: SplashAction) {
        when (action) {
            is SplashAction.Init -> dispatch(SplashMsg.Loading)
            is SplashAction.Initialized -> {
                dispatch(SplashMsg.Finish)
                dispatch(SplashMsg.Initialized)
                publish(SplashLabel.OpenNews)
            }
        }
    }
}

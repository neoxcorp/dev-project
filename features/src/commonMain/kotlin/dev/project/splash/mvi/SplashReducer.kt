package dev.project.splash.mvi

import com.arkivanov.mvikotlin.core.store.Reducer
import dev.project.splash.mvi.SplashStore.SplashState

internal object SplashReducer : Reducer<SplashState, SplashMsg> {
    override fun SplashState.reduce(msg: SplashMsg): SplashState =
        when (msg) {
            is SplashMsg.Loading -> SplashState.Loading
            is SplashMsg.Finish -> SplashState.Loaded
            is SplashMsg.Initialized -> SplashState.Initialized
        }
}
